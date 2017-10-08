package io.github.legosteen11.pdoklocatieserverclient.http

enum class EndpointType {
    SUGGEST,
    LOOKUP,
    FREE;

    fun getEndpointUrlString() = name.toLowerCase()

    fun getFullUrl() = getEndPointUrl(this)
}