package ton.kotlin.leetcode

import ton.`try`.kotlin.leetcode.linkedlistcycle.createNodesTo
import ton.kotlin.leetcode.linkedlistcycle.ListNode

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2, 4))
    var secondNode = createNodesTo(intArrayOf(1, 3, 4))
    println(mergeTwoLists(firstNode, secondNode)?.`val`) //1

    firstNode = createNodesTo(intArrayOf(1,1,4,8,8,11,12,12))
    secondNode = createNodesTo(intArrayOf(2,4,9,9,11,15))
    println(mergeTwoLists(firstNode, secondNode)?.`val`) //1

    firstNode = createNodesTo(intArrayOf())
    secondNode = createNodesTo(intArrayOf())
    println(mergeTwoLists(firstNode, secondNode)?.`val`) //null

    firstNode = createNodesTo(intArrayOf())
    secondNode = createNodesTo(intArrayOf(7))
    println(mergeTwoLists(firstNode, secondNode)?.`val`) //7

    firstNode = createNodesTo(intArrayOf(2, 2, 4, 3, 2, 3))
    secondNode = createNodesTo(intArrayOf(2, 2, 4, 3, 2, 3))
    println(mergeTwoLists(firstNode, secondNode)?.`val`) //2
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }

    val resHead: ListNode?
    var anotherHead: ListNode?

    if (list1.`val` > list2.`val`) {
        resHead = list2
        anotherHead = list1
    } else {
        resHead = list1
        anotherHead = list2
    }
    var stepper = resHead

    while (stepper?.next != null) {
        if (stepper.next?.`val`?.compareTo(anotherHead?.`val`!!) == 1) {
            stepper.next = anotherHead.also { anotherHead = stepper?.next }
        } else {
            stepper = stepper.next
        }
    }
    stepper?.next = anotherHead

    return resHead
}

