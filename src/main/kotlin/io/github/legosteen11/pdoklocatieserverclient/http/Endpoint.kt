package io.github.legosteen11.pdoklocatieserverclient.http

val API_BASE_URL = "http://geodata.nationaalgeoregister.nl/locatieserver/v3/"

fun getEndPointUrl(type: EndpointType) = "$API_BASE_URL${type.getEndpointUrlString()}"