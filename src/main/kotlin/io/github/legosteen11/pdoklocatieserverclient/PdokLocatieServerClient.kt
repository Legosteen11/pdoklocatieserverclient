package io.github.legosteen11.pdoklocatieserverclient

import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import io.github.legosteen11.pdoklocatieserverclient.http.EndpointType
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.LookupResponse
import io.github.legosteen11.pdoklocatieserverclient.response.suggest.SuggestResponse
import mu.KLogging
import java.io.IOException

object PdokLocatieServerClient: KLogging() {
    /**
     * Make an async 'lookup' type request to PDOK.
     *
     * This will get detailed info about an object.
     *
     * @param query The search query.
     * @param callback The callback on success.
     * @param onFailure The callback on failure.
     */
    fun doLookup(id: String, onFailure: () -> Unit = { logger.error("Connection to PDOK failed.") }, callback: (LookupResponse) -> Unit) {
        doGetRequestAsync(EndpointType.LOOKUP.getFullUrl(), listOf(Pair("id", id)), { data ->
            val lookupObject = Gson().fromJson(data, LookupResponse::class.java)

            callback(lookupObject)
        }, {
            onFailure()
        })
    }

    /**
     * Make an async 'suggest' type request to PDOK.
     *
     * This will suggest objects based on a search query.
     *
     * @param query The search query.
     * @param callback The callback on success.
     * @param onFailure The callback on failure.
     */
    fun doSuggest(query: String, onFailure: () -> Unit = { logger.error("Connection to PDOK failed.") }, callback: (SuggestResponse) -> Unit) {
        doGetRequestAsync(EndpointType.SUGGEST.getFullUrl(), listOf(Pair("q", query)), { data ->
            val lookupObject = Gson().fromJson(data, SuggestResponse::class.java)

            callback(lookupObject)
        }, {
            onFailure()
        })
    }

    /**
     * Make an async 'free' type request to PDOK.
     *
     * This will get detailed info about objects based on a search query.
     *
     * @param query The search query.
     * @param callback The callback on success.
     * @param onFailure The callback on failure.
     */
    fun doFree(query: String, onFailure: () -> Unit = { logger.error("Connection to PDOK failed.") }, callback: (LookupResponse) -> Unit) {
        doGetRequestAsync(EndpointType.FREE.getFullUrl(), listOf(Pair("q", query)), { data ->
            val lookupObject = Gson().fromJson(data, LookupResponse::class.java)

            callback(lookupObject)
        }, {
            onFailure()
        })
    }

    /**
     * Make a blocking 'lookup' type request to PDOK.
     *
     * This will get detailed info about an object.
     *
     * @param id The object id.
     *
     * @return A lookupresponse.
     *
     * @throws IOException if the connection failed or if no data was received.
     */
    fun doBlockingLookup(id: String): LookupResponse {
        val data = doGetRequestBlocking(EndpointType.LOOKUP.getFullUrl(), listOf(Pair("id", id)))

        return Gson().fromJson(data, LookupResponse::class.java)
    }

    /**
     * Make a blocking 'suggest' type request to PDOK.
     *
     * This will suggest objects based on a search query.
     *
     * @param query The search query
     *
     * @return A suggestresponse.
     *
     * @throws IOException if the connection failed or if no data was received.
     */
    fun doBlockingSuggest(query: String): SuggestResponse {
        val data = doGetRequestBlocking(EndpointType.SUGGEST.getFullUrl(), listOf(Pair("q", query)))

        return Gson().fromJson(data, SuggestResponse::class.java)
    }

    /**
     * Make a blocking 'free' type request to PDOK.
     *
     * This will get detailed info about objects based on a search query.
     *
     * @param query The search query
     *
     * @return A lookupresponse.
     *
     * @throws IOException if the connection failed or if no data was received.
     */
    @Throws(IOException::class)
    fun doBlockingFree(query: String): LookupResponse {
        val data = doGetRequestBlocking(EndpointType.FREE.getFullUrl(), listOf(Pair("q", query)))

        return Gson().fromJson(data, LookupResponse::class.java)
    }

    /**
     * Make an async request and execute a callback
     *
     * @param url The url
     * @param parameters The parameters
     * @param callback The callback that will be executed after a result was found
     *
     * @throws IOException if the connection failed or if no data was received.
     */
    @Throws(IOException::class)
    private fun doGetRequestAsync(url: String, parameters: List<Pair<String, String>>, callback: (String) -> Unit, onFailure: () -> Unit) {
        url.httpGet(parameters).responseString { request, response, result ->
            val (data, error) = result
            if(error != null) {
                onFailure()

                throw IOException("Connection to PDOK failed with error: $error")
            }

            if(data == null) {
                onFailure()

                throw IOException("Did not receive data from PDOK.")
            }

            callback(data)
        }
    }

    /**
     * Make a blocking get request and get the response
     *
     * @param url The url
     * @param parameters The parameters
     *
     * @return Returns the response data
     *
     * @throws IOException if the connection failed or if no data was received.
     */
    @Throws(IOException::class)
    private fun doGetRequestBlocking(url: String, parameters: List<Pair<String, String>>): String {
        val (request, response, result) = url.httpGet(parameters).responseString()
        val (data, error) = result

        if(error != null) {
            throw IOException("Connection to PDOK failed with error: $error")
        }

        if(data == null) {
            throw IOException("Did not receive data from PDOK.")
        }

        return data
    }
}