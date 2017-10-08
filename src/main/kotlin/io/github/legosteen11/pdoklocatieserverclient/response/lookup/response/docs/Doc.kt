package io.github.legosteen11.pdoklocatieserverclient.response.lookup.response.docs

import io.github.legosteen11.pdoklocatieserverclient.response.ObjectType
import io.github.legosteen11.pdoklocatieserverclient.response.Point
import java.text.ParseException

data class Doc(
        val bron: String,
        val identificatie: String,
        val provinciecode: String,
        val type: ObjectType,
        val provincienaam: String,
        val centroide_ll: String,
        val gemeentecode: String,
        val weergavenaam: String,
        val provincieafkorting: String,
        val centroide_rd: String,
        val id: String,
        val gemeentenaam: String
) {
    /**
     * Get point ll
     *
     * @return Returns the ll point
     *
     * @throws ParseException The point could not be parsed.
     */
    @Throws(ParseException::class)
    fun getCoordinates(): Point = Point.parse(centroide_ll)

    /**
     * Get point rd
     *
     * @return returns the rd point
     * @throws ParseException The point could not be parsed.
     */
    @Throws(ParseException::class)
    fun getPointRd(): Point = Point.parse(centroide_rd)
}