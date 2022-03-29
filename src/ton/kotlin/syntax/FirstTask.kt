package ton.kotlin.syntax

import java.lang.StringBuilder

fun main() {

  // [1, 2, 3, 2, 0] & [5, 1, 2, 7, 3, 2]
    //нужно найти пересечение с учетом кол-ва раз: [1, 2, 2, 3] (порядок неважен)

   find(arrayOf(1, 2, 3, 2, 0), arrayOf(5, 1, 2, 7, 3, 2)).forEach { println(it) }
    println(count("AAMVBBAAAALLUUUStT"))

    println(findGroups(arrayOf("eat","tea", "tan", "ate", "nat", "bat")))
}

fun find(first: Array<Int>, second: Array<Int>): Array<Int> {
    val map = first.groupBy { it }.mapValues { it.value.size }.toMutableMap()

    val result = mutableListOf<Int>()
    second.forEach {
        run {
            if (map.containsKey(it)) {
                result.add(it)
                val count = map.get(it)
                if (count == null || count == 1) map.remove(it) else map.put(it, count.minus(1))
            }
        }
    }
    return result.toTypedArray()
}

fun count(inData: String): String {

    var counter = 0
    var currentLetter = ' '
    val buffer = StringBuilder()
    inData.trim().toCharArray().forEach { run {
        if (it == currentLetter) {
            counter++
        } else {
            buffer.append(counter)
            counter = 1
            buffer.append(it)
            currentLetter = it
        }
    } }
    buffer.append(counter)

    return buffer.removePrefix("0").toString()
}

fun findGroups(inData: Array<String>): MutableCollection<MutableList<String>> {
    val resMap = mutableMapOf<String, MutableList<String>>()
    inData.forEach { run {
        val sortedString = it.toCharArray().sorted().joinToString("")
        if (resMap.containsKey(sortedString)) {
            resMap[sortedString]?.add(it)
        } else {
            resMap[sortedString] = mutableListOf(it)
        }
    } }

    return resMap.values
}