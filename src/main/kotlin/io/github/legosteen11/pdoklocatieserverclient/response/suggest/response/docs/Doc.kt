package io.github.legosteen11.pdoklocatieserverclient.response.suggest.response.docs

import io.github.legosteen11.pdoklocatieserverclient.response.ObjectType

data class Doc(
        val type: ObjectType,
        val weergavenaam: String,
        val id: String,
        val score: Double
)