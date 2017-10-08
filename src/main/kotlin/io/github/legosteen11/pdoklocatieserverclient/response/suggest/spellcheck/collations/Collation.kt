package io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck.collations

data class Collation(
        val collationQuery: String,
        val hits: Int,
        val misspellingsAndCorrections: Pair<String, String>
)