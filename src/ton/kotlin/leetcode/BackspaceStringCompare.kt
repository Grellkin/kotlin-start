package ton.kotlin.leetcode

import kotlin.math.max

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "a#d#"))
    println(backspaceCompare("ab##", "a#d"))
    println(backspaceCompare("", ""))
    println(backspaceCompare("###abd", "abd#d"))
}

fun backspaceCompare(s: String, t: String): Boolean {

    val sArray = s.toCharArray()
    val tArray = t.toCharArray()
    var sPointer = sArray.lastIndex
    var tPointer = tArray.lastIndex

    while (sPointer >= 0 || tPointer >= 0) {
        sPointer = findIndexForComparison(sArray, sPointer)
        tPointer = findIndexForComparison(tArray, tPointer)

        if (sPointer < 0 && tPointer < 0) {
            return true
        }
        if (sPointer < 0 || tPointer < 0) {
            return false
        }
        if (sArray[sPointer] != tArray[tPointer]) {
            return false
        }
        sPointer--
        tPointer--
    }

    return true
}

fun findIndexForComparison(chars: CharArray, fromInd: Int): Int {
    var start = fromInd
    var counter = 0
    while (start >= 0) {
        if (chars[start] == '#') {
            counter++
        } else if (counter > 0) {
            counter--
        } else {
            return start
        }
        start--
    }

    return -1
}

//this is more effective, tested
fun backspaceCompare2(s: String, t: String): Boolean {
    val sBuf = StringBuffer(s)
    val tBuf = StringBuffer(t)

    applyBackspaces(sBuf)
    applyBackspaces(tBuf)

    return sBuf.toString() == tBuf.toString()
}

private fun applyBackspaces(buffer: StringBuffer) {
    var index = buffer.indexOfFirst { it == '#' }
    while (index >= 0) {
        buffer.delete(max(0, index - 1), index + 1)
        index = buffer.indexOfFirst { it == '#' }
    }
}
