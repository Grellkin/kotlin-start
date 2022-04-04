package ton.kotlin.leetcode.medium

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}


fun lengthOfLongestSubstring(s: String): Int {
    val seenChars = mutableSetOf<Char>()

    fun countMax(pointer: Int, startChar: Int) : Int {
        var endChar = pointer
        if (pointer >= s.lastIndex) {
            return s.length - startChar
        }

        while (endChar < s.length && !seenChars.contains(s[endChar])) {
            seenChars.add(s[endChar])
            endChar++
        }
        seenChars.remove(s[startChar])

        return max(countMax(endChar, startChar + 1), endChar - startChar)
    }

    return countMax(0, 0)
}




