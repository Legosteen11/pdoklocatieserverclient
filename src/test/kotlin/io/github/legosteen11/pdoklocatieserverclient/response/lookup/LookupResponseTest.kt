package io.github.legosteen11.pdoklocatieserverclient.response.lookup

import com.google.gson.Gson
import io.github.legosteen11.pdoklocatieserverclient.response.ObjectType
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.Response
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.docs.Doc
import org.junit.Assert.*
import org.junit.Test

class LookupResponseTest {
    @Test
    fun testParse() {
        val parsedResponse = Gson().fromJson("""
            {
  "response": {
    "numFound": 1,
    "start": 0,
    "maxScore": 15.693415,
    "docs": [
      {
        "bron": "BAG",
        "identificatie": "0344",
        "provinciecode": "PV26",
        "type": "gemeente",
        "provincienaam": "Utrecht",
        "centroide_ll": "POINT(5.07475463 52.09113813)",
        "gemeentecode": "0344",
        "weergavenaam": "Gemeente Utrecht",
        "provincieafkorting": "UT",
        "centroide_rd": "POINT(133587.205 455921.61)",
        "id": "gem-df0ca8ab37eccea5217e2a13f74d2833",
        "gemeentenaam": "Utrecht"
      }
    ]
  }
}
        """.trimIndent(), LookupResponse::class.java)

        assertEquals(LookupResponse(
                Response(
                        1,
                        0,
                        15.693415,
                        listOf(
                                Doc(
                                        "BAG",
                                        "0344",
                                        "PV26",
                                        ObjectType.GEMEENTE,
                                        "Utrecht",
                                        "POINT(5.07475463 52.09113813)",
                                        "0344",
                                        "Gemeente Utrecht",
                                        "UT",
                                        "POINT(133587.205 455921.61)",
                                        "gem-df0ca8ab37eccea5217e2a13f74d2833",
                                        "Utrecht"
                                )
                        )
                )
        ), parsedResponse)
    }
}