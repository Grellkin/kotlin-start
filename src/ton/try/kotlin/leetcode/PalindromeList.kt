package ton.`try`.kotlin.leetcode

import ton.`try`.kotlin.leetcode.linkedlistcycle.ListNode
import ton.`try`.kotlin.leetcode.linkedlistcycle.createNodesTo
import ton.`try`.kotlin.leetcode.linkedlistcycle.middleNode

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2))
    println(isPalindrome(firstNode)) //false

    firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5))
    println(isPalindrome(firstNode)) //false

    firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5, 6))
    println(isPalindrome(firstNode)) //false

    firstNode = createNodesTo(intArrayOf(1, 2, 2, 1))
    println(isPalindrome(firstNode)) //true

    firstNode = createNodesTo(intArrayOf(-21, 10, 56, 56, 10, -21))
    println(isPalindrome(firstNode)) //true

    firstNode = createNodesTo(intArrayOf(1))
    println(isPalindrome(firstNode)) //true

    firstNode = createNodesTo(intArrayOf(1,1))
    println(isPalindrome(firstNode)) //true
}



fun isPalindrome(head: ListNode?): Boolean {

    var headTwo = head //stupid kotlin
    var middleNode = middleNode(head)
    middleNode = reverseList(middleNode) //this is the last from right now

    while (middleNode != null) {
        if (middleNode.`val` != headTwo?.`val`) {
            return false
        }
        middleNode = middleNode.next
        headTwo = headTwo.next
    }

    return true
}

fun isPalindrome2(head: ListNode?): Boolean {
    if (head?.next == null) {
        return true
    }

    var hare = head.next
    var turtlePrevious = head
    var turtleCurrent = head.next
    head.next = null
    var counter = 2

    //hare goes as usual, turtle flip references after itself
    while (hare?.next != null && turtleCurrent?.next != null) {
        hare = hare.next
        counter++
        if (hare?.next != null) {
            hare = hare?.next
            counter++

            val nevCur = turtleCurrent.next
            turtleCurrent.next = turtlePrevious
            turtlePrevious = turtleCurrent
            turtleCurrent = nevCur
        }
    }


    if (counter%2 == 1) {
        turtleCurrent = turtleCurrent?.next
    }
    hare = turtlePrevious

    if (hare?.`val` != turtleCurrent?.`val`) {
        return false
    }

    while (hare?.next != null) {
        hare = hare.next
        turtleCurrent = turtleCurrent?.next
        if (hare?.`val` != turtleCurrent?.`val`) {
            return false
        }
    }

    return true
}

