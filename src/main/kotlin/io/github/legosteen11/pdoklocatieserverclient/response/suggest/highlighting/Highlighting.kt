package io.github.legosteen11.pdoklocatieserverclient.response.suggest.highlighting

data class Highlighting (
    val suggest: List<String>
) {
    fun getSuggestion() = suggest.first()
}