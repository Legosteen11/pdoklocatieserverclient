package io.github.legosteen11.pdoklocatieserverclient

import io.github.legosteen11.pdoklocatieserverclient.response.ObjectType
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.LookupResponse
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.Response
import io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.docs.Doc
import org.junit.Test

import org.junit.Assert.*

class PdokLocatieServerClientTest {
    @Test
    fun doBlockingLookup() {
        //println("Lookup 'gem-df0ca8ab37eccea5217e2a13f74d2833':")

        //println(PdokLocatieServerClient.doBlockingLookup("gem-df0ca8ab37eccea5217e2a13f74d2833"))

        val lookup = PdokLocatieServerClient.doBlockingLookup("gem-df0ca8ab37eccea5217e2a13f74d2833")

        assertEquals(
                LookupResponse(response= Response(numFound=1, start=0, maxScore=lookup.response.maxScore, docs= listOf(Doc(bron = "BAG", identificatie = "0344", provinciecode="PV26", type=ObjectType.GEMEENTE, provincienaam="Utrecht", centroide_ll="POINT(5.07475463 52.09113813)", gemeentecode="0344", weergavenaam="Gemeente Utrecht", provincieafkorting="UT", centroide_rd="POINT(133587.205 455921.61)", id="gem-df0ca8ab37eccea5217e2a13f74d2833", gemeentenaam="Utrecht")))),
                lookup
        )
    }

    @Test
    fun doBlockingSuggest() {
        //println("Suggest 'utrecht':")

        //println(PdokLocatieServerClient.doBlockingSuggest("utrecht"))

        val suggest = PdokLocatieServerClient.doBlockingSuggest("utrecht").response.docs.first()

        assertEquals(
                io.github.legosteen11.pdoklocatieserverclient.response.suggest.response.docs.Doc(type=ObjectType.GEMEENTE, weergavenaam="Gemeente Utrecht", id="gem-df0ca8ab37eccea5217e2a13f74d2833", score=suggest.score),
                suggest
        )
    }

    @Test
    fun doBlockingFree() {
        //println("Free 'utrecht':")

        assertEquals(
                Doc(bron = "BAG", identificatie = "0344", provinciecode="PV26", type=ObjectType.GEMEENTE, provincienaam="Utrecht", centroide_ll="POINT(5.07475463 52.09113813)", gemeentecode="0344", weergavenaam="Gemeente Utrecht", provincieafkorting="UT", centroide_rd="POINT(133587.205 455921.61)", id="gem-df0ca8ab37eccea5217e2a13f74d2833", gemeentenaam="Utrecht"),
                PdokLocatieServerClient.doBlockingFree("utrecht").response.docs.first()
        )
    }
}