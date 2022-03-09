package ton.`try`.kotlin.leetcode.climbingstairs

import kotlin.system.measureTimeMillis



fun main() {
//    val measureTimeMillis = measureTimeMillis {
//        println(climbStairs(1))
//        println(climbStairs(2))
//        println(climbStairs(3))
//        println(climbStairs(4))
//        println(climbStairs(5))
//        println(climbStairs(45))
//    }
//    println("Appoximate time is $measureTimeMillis")


    val sample = ClimbWithCache()
    val measureTimeMillis2 = measureTimeMillis {
        println(sample.climbStairs(1))
        println(sample.climbStairs(2))
        println(sample.climbStairs(3))
        println(sample.climbStairs(4))
        println(sample.climbStairs(5))
        println(sample.climbStairs(45))
    }
    println("Appoximate time is $measureTimeMillis2")

    val measureTimeMillis3 = measureTimeMillis {
        println(climbUsingArray(1))
        println(climbUsingArray(2))
        println(climbUsingArray(3))
        println(climbUsingArray(4))
        println(climbUsingArray(5))
        println(climbUsingArray(45))
    }
    println("Appoximate time is $measureTimeMillis3")

    val measureTimeMillis4 = measureTimeMillis {
        println(climbFibonacci(1))
        println(climbFibonacci(2))
        println(climbFibonacci(3))
        println(climbFibonacci(4))
        println(climbFibonacci(5))
        println(climbFibonacci(45))
    }
    println("Appoximate time fro fibanacci is $measureTimeMillis4")
}

fun climbStairs(n: Int): Int {
    if(n == 1) {
        return 1
    }
    if(n == 2) {
        return 2
    }

    return climbStairs(n-1) + climbStairs(n-2)
}

fun climbUsingArray(n: Int): Int {
    if(n == 1) {
        return 1
    }
    if(n == 2) {
        return 2
    }
    val intArray = IntArray(n)
    intArray[0] = 1
    intArray[1] = 2

    for (i in 2 until n) {
        intArray[i] = intArray[i-1] + intArray[i-2]
    }

    return intArray.last()
}

fun climbFibonacci(n: Int): Int {
    if(n == 1) {
        return 1
    }
    if(n == 2) {
        return 2
    }

    var n1 = 1
    var n2 = 2

    for (i in 3..n) {
        n2 = (n2 + n1).also { n1 = n2 }
    }

    return n2
}