package io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck.suggestions

data class Suggestion(
        val numFound: Int,
        val startOffset: Int,
        val endOffset: Int,
        val suggestion: List<String>
)