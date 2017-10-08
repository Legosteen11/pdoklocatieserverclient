package io.github.legosteen11.pdoklocatieserverclient.response.lookup.response

import io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.docs.Doc

data class Response(
        val numFound: Int,
        val start: Int,
        val maxScore: Double,
        val docs: List<Doc>
)