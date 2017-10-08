package io.github.legosteen11.pdoklocatieserverclient.response.suggest

import com.google.gson.Gson
import io.github.legosteen11.pdoklocatieserverclient.response.ObjectType
import io.github.legosteen11.pdoklocatieserverclient.response.suggest.response.Response
import io.github.legosteen11.pdoklocatieserverclient.response.suggest.response.docs.Doc
import org.junit.Assert.*
import org.junit.Test

class SuggestResponseTest {
    @Test
    fun testParse() {
        val parsedResponse = Gson().fromJson(
                //"""{"response":{"numFound":172912,"start":0,"maxScore":21.429117,"docs":[{"type":"gemeente","weergavenaam":"Gemeente Utrecht","id":"gem-df0ca8ab37eccea5217e2a13f74d2833","score":21.429117},{"type":"woonplaats","weergavenaam":"Utrecht, Utrecht, Utrecht","id":"wpl-d7676180b7f172bcb7356429b19563a5","score":18.635588}]},"highlighting":{"gem-df0ca8ab37eccea5217e2a13f74d2833":{"suggest":["Gemeente <b>Utrecht</b>"]},"wpl-d7676180b7f172bcb7356429b19563a5":{"suggest":["<b>Utrecht</b>, <b>Utrecht</b>, <b>Utrecht</b>"]},"gem-79f2df23df8ee16a3dc53b081ef11124":{"suggest":["Gemeente <b>Utrechtse</b> Heuvelrug"]},"wpl-9ccbd861496d43dfd87d01b3e6be5198":{"suggest":["Amerongen, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]},"wpl-37eaac1d90a16cec7d6ead9c5e68fccd":{"suggest":["De Meern, <b>Utrecht</b>, <b>Utrecht</b>"]},"wpl-494df56c81b6843b056fb98a7730af3d":{"suggest":["Doorn, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]},"wpl-d026e71ba8ef05c528c22f900e1dcbc8":{"suggest":["Haarzuilens, <b>Utrecht</b>, <b>Utrecht</b>"]},"wpl-ce920ee6808e893f72002db10d2aec2d":{"suggest":["Leersum, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]},"wpl-3ab1345a90ff3ae00d29e95060a7f117":{"suggest":["Maarn, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]},"wpl-b86f633e9b17a21af910bd5cb611e07e":{"suggest":["Maarsbergen, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]}},"spellcheck":{"suggestions":[],"collations":[]}}"""
                """
                    {
	"response": {
		"numFound": 172912,
		"start": 0,
		"maxScore": 21.429117,
		"docs": [{
			"type": "gemeente",
			"weergavenaam": "Gemeente Utrecht",
			"id": "gem-df0ca8ab37eccea5217e2a13f74d2833",
			"score": 21.429117
		}, {
			"type": "woonplaats",
			"weergavenaam": "Utrecht, Utrecht, Utrecht",
			"id": "wpl-d7676180b7f172bcb7356429b19563a5",
			"score": 18.635588
		}]
	},
	"highlighting": {
		"gem-df0ca8ab37eccea5217e2a13f74d2833": {
			"suggest": ["Gemeente <b>Utrecht</b>"]
		},
		"wpl-d7676180b7f172bcb7356429b19563a5": {
			"suggest": ["<b>Utrecht</b>, <b>Utrecht</b>, <b>Utrecht</b>"]
		},
		"gem-79f2df23df8ee16a3dc53b081ef11124": {
			"suggest": ["Gemeente <b>Utrechtse</b> Heuvelrug"]
		},
		"wpl-9ccbd861496d43dfd87d01b3e6be5198": {
			"suggest": ["Amerongen, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]
		},
		"wpl-37eaac1d90a16cec7d6ead9c5e68fccd": {
			"suggest": ["De Meern, <b>Utrecht</b>, <b>Utrecht</b>"]
		},
		"wpl-494df56c81b6843b056fb98a7730af3d": {
			"suggest": ["Doorn, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]
		},
		"wpl-d026e71ba8ef05c528c22f900e1dcbc8": {
			"suggest": ["Haarzuilens, <b>Utrecht</b>, <b>Utrecht</b>"]
		},
		"wpl-ce920ee6808e893f72002db10d2aec2d": {
			"suggest": ["Leersum, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]
		},
		"wpl-3ab1345a90ff3ae00d29e95060a7f117": {
			"suggest": ["Maarn, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]
		},
		"wpl-b86f633e9b17a21af910bd5cb611e07e": {
			"suggest": ["Maarsbergen, <b>Utrechtse</b> Heuvelrug, <b>Utrecht</b>"]
		}
	},
	"spellcheck": {
		"suggestions": [],
		"collations": []
	}
}
                    """.trimIndent()
                , SuggestResponse::class.java)

        assertEquals(SuggestResponse(
                Response(
                        172912,
                        0,
                        21.429117,
                        listOf(
                                Doc(
                                        ObjectType.GEMEENTE,
                                        "Gemeente Utrecht",
                                        "gem-df0ca8ab37eccea5217e2a13f74d2833",
                                        21.429117),
                                Doc(
                                        ObjectType.WOONPLAATS,
                                        "Utrecht, Utrecht, Utrecht",
                                        "wpl-d7676180b7f172bcb7356429b19563a5",
                                        18.635588)
                        )
                )
        ), parsedResponse)
    }
}