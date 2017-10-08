package io.github.legosteen11.pdoklocatieserverclient.response.suggest

import io.github.legosteen11.pdoklocatieserverclient.response.suggest.response.Response
import io.github.legosteen11.pdoklocatieserverclient.response.suggest.spellcheck.Spellcheck

/**
 * Suggest response.
 *
 * Contains searched objects.
 */
data class SuggestResponse(
        val response: Response,
        @Transient
        val highlighting: Any? = null,
        @Transient
        val spellcheck: Spellcheck? = null
)