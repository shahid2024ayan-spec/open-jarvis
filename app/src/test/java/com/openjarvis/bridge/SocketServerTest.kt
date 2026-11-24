package com.openjarvis.bridge

import org.junit.Assert.*
import org.junit.Test

class SocketServerTest {
    @Test
    fun parseRequestReadsCommandAndRequestId() {
        val result = SocketServer.parseRequestLine("""{"cmd":"open chrome","requestId":"abc123"}""")
        assertNotNull(result)
        assertEquals("abc123", result?.first)
        assertEquals("open chrome", result?.second)
    }

    @Test
    fun parseRequestRejectsMissingOrBlankCommand() {
        assertNull(SocketServer.parseRequestLine("""{"requestId":"abc123"}"""))
        assertNull(SocketServer.parseRequestLine("""{"cmd":"  "}"""))
    }

    @Test
    fun parseRequestRejectsMalformedJson() {
        assertNull(SocketServer.parseRequestLine("not json"))
        assertNull(SocketServer.parseRequestLine("{"))
        assertNull(SocketServer.parseRequestLine("[]"))
    }

    @Test
    fun escapeJsonEscapesControlCharactersAndQuotes() {
        val escaped = SocketServer.escapeJsonValue("hello\nworld\"test\tvalue")
        assertTrue(escaped.contains("\\n"))
        assertTrue(escaped.contains("\\\""))
        assertTrue(escaped.contains("\\t"))
    }

    @Test
    fun errorResponseIncludesRequestAndError() {
        val response = SocketServer.errorResponse("req123", "test error")
        assertTrue(response.contains("req123"))
        assertTrue(response.contains("error"))
        assertTrue(response.contains("test error"))
    }
}
