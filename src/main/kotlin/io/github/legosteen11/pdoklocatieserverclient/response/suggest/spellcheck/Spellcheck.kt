package io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck

import io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck.collations.Collation
import io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck.suggestions.Suggestion

data class Spellcheck (
        val suggestions: Map<String, Suggestion>,
        val collations: Map<String, Collation>
)