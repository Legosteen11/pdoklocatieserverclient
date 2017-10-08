package io.github.legosteen11.pdoklocatieserverclient.response

import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

class PointTest {
    @Test
    fun testParse() {
        assertEquals(Point(BigDecimal("52.09113813"), BigDecimal("5.07475463")), Point.parse("POINT(5.07475463 52.09113813)"))
    }
}