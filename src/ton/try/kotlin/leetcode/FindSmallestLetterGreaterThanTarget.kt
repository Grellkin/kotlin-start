package ton.`try`.kotlin.leetcode

fun main() {
    println(nextGreatestLetter(charArrayOf('c','f','j'), 'a')) //c
    println(nextGreatestLetter(charArrayOf('c','f','j'), 'c')) //f
    println(nextGreatestLetter(charArrayOf('c','f','j'), 'd')) //f
    println(nextGreatestLetter(charArrayOf('a', 'b'), 'z')) //a
    println(nextGreatestLetter(charArrayOf('a', 'b'), 'b')) //a
    println(nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'g')) //j
    println(nextGreatestLetter(charArrayOf('c', 'f', 'j', 'j', 'j'), 'y')) //c
}

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var searchRes = letters.binarySearch(target + 1)
    if (searchRes < 0) {
        searchRes = -searchRes - 1
    }

    while (searchRes > 0 && letters[searchRes - 1] > target) {
        searchRes--
    }

    return if (searchRes > letters.lastIndex) letters[0] else letters[searchRes]
}


fun nextGreatestLetter2(letters: CharArray, target: Char): Char {
    var start = 0
    var end = letters.lastIndex

    while (start <= end) {
        val realMiddle = start + (end - start) / 2
        if (letters[realMiddle] > target) {
            end = realMiddle - 1
        } else {
            start = realMiddle + 1
        }
    }

    return letters[start % letters.size]
}
