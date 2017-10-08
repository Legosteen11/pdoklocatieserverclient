package io.github.legosteen11.pdoklocatieserverclient.response

import java.math.BigDecimal
import java.text.ParseException

/**
 * Point like: POINT(5.07475463 52.09113813)
 */
data class Point(
        val latitude: BigDecimal,
        val longitude: BigDecimal
) {
    companion object {
        /**
         * Parse a string like POINT(5.07475463 52.09113813) to a coordinate
         *
         * @param point The point string, in the form of POINT(latitude longitude)
         *
         * @throws ParseException The point could not be parsed.
         */
        @Throws(ParseException::class)
        fun parse(point: String): Point {
            try {
                // POINT(5.07475463 52.09113813) -> {5.07475463, 52.09113813}
                val coords = point
                        .replace("POINT(", "")
                        .replace(")", "")
                        .split(" ")
                        .map { BigDecimal(it) }

                if(coords.size != 2) {
                    throw ParseException("Could not parse coordinates: $point", 0)
                }

                return Point(coords[1], coords[0])
            } catch (e: NumberFormatException) {
                throw ParseException("Could not parse coordinates: $point", 0)
            }
        }
    }
}