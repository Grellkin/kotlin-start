
fun main() {
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
    println(majorityElement(intArrayOf(3,2,3)))
    println(majorityElement(intArrayOf(7)))
}

fun majorityElement(nums: IntArray): Int {
    var vote = 0
    var major = nums.first()

    for (v in nums) {
        if (major == v) {
            vote++
        } else if (vote > 0) {
            vote--
        } else {
            major = v
        }
    }

    return major
}


fun majorityElement2(nums: IntArray): Int {
    val map: MutableMap<Int, Int> = mutableMapOf()
    val half = nums.size / 2

    for (v in nums) {
        val count = map.getOrDefault(v, 0) + 1
        if (count > half) {
            return v
        }
        map[v] = count
    }
    return 0
}