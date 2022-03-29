package ton.kotlin.leetcode.climbingstairs

class ClimbWithCache {
    var cacheMap = mutableMapOf<Int, Int>()


    fun climbStairs(n: Int): Int {
        if(n == 1) {
            return 1
        }
        if(n == 2) {
            return 2
        }

        val minusOne : Int
        val minusTwo : Int
        if (cacheMap.containsKey(n-1)) {
            minusOne = cacheMap.getValue(n-1)
        } else {
            minusOne = climbStairs(n-1)
            cacheMap.put(n-1, minusOne)
        }
        if (cacheMap.containsKey(n-2)) {
            minusTwo = cacheMap.getValue(n-2)
        } else {
            minusTwo = climbStairs(n-2)
            cacheMap.put(n-2, minusTwo)
        }

        return minusOne + minusTwo
    }

}