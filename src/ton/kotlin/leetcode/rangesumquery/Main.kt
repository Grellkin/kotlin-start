package ton.kotlin.leetcode.rangesumquery

fun main() {
    var obj = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(obj.sumRange(0, 2))
    println(obj.sumRange(2, 5))
    println(obj.sumRange(0, 5))
}