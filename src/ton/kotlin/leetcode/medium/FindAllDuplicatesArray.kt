package ton.kotlin.leetcode.medium

import java.util.*
import java.util.stream.Collectors
import kotlin.math.abs

fun main() {
    println(findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)))

}

fun findDuplicates(nums: IntArray): List<Int> {

    val arrayList = LinkedList<Int>()

    for (v in nums) {
        val mod = abs(v)
        if (nums[mod - 1] < 0) {
            arrayList.addFirst(mod)
        } else {
            nums[mod - 1] *= -1
        }
    }

    return arrayList
}

fun findDuplicates2(nums: IntArray): List<Int> {
    val mutableSetOf = mutableSetOf<Int>()

    for (ind in nums.indices) {
        var desiredInd = nums[ind] - 1

        while (desiredInd != ind) {
            if (nums[desiredInd] == (desiredInd + 1)) {
                mutableSetOf.add(desiredInd + 1)
                break
            } else {
                nums[ind] = nums[desiredInd]
                nums[desiredInd] = desiredInd + 1
            }
            desiredInd = nums[ind] - 1
        }

    }

    return mutableSetOf.stream().collect(Collectors.toList())
}