package ton.`try`.kotlin.leetcode

import java.util.*
import kotlin.Comparator


class Interval {
    var start: Int = 0
    var end: Int = 0

    constructor(start: Int, end: Int) {
        this.start = start
        this.end = end
    }
}

fun main() {
    println(canAttendMeetings(mutableListOf(Interval(0, 30), Interval(5,10), Interval(15,20)))) //false
    println(canAttendMeetings(mutableListOf(Interval(5,8), Interval(9,15)))) //true
    println(canAttendMeetings(mutableListOf(Interval(0, 30), Interval(36,38), Interval(30,36)))) //true
}

fun canAttendMeetings(intervals: MutableList<Interval?>): Boolean {

    val comparator = Comparator<Interval?> { o1, o2 ->
        when {
            (o1 != null && o2 != null && o1.end <= o2.start) -> -1
            (o1 != null && o2 != null && o1.start >= o2.end) -> 1
            else -> 0
        }
    }

    val treeSet = TreeSet<Interval?>(comparator)

    for (i in intervals) {
        if (treeSet.contains(i)) return false
        else treeSet.add(i)
    }
    return true
}