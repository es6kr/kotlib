package kr.es6.kotlib

import org.junit.Assert.*
import org.junit.Test
import java.util.*

internal class Base64EncoderTest {

    @Test
    fun testEncodeByteArray() {
        val encoder = Base64EncoderImpl()
        val input = "Hello, world!".toByteArray()
        val expectedOutput = "SGVsbG8sIHdvcmxkIQ=="
        val actualOutput = encoder.encode(input)
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testEncodeLong() {
        val encoder = Base64EncoderImpl()
        val input = 123456L
        val expectedOutput = "AeJA"
        val actualOutput = encoder.encode(input)
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testEncodeUUID() {
        val encoder = Base64EncoderImpl()
        val input = UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
        val expectedOutput = "+B1Prn3sEdA=p2UAoMkea/Y="
        val actualOutput = encoder.encode(input)
        assertEquals(expectedOutput, actualOutput)
    }

    private class Base64EncoderImpl : Base64Encoder() {
        override fun encode(byteArray: ByteArray): String {
            return Base64.getEncoder().encodeToString(byteArray)
        }
    }
}
