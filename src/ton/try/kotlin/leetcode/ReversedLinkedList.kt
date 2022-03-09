package ton.`try`.kotlin.leetcode

import ton.`try`.kotlin.leetcode.linkedlistcycle.ListNode
import ton.`try`.kotlin.leetcode.linkedlistcycle.createNodesTo

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5))
    println(reverseList(firstNode)?.`val`) //5

    firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5, 6))
    println(reverseList(firstNode)?.`val`) //6

    firstNode = createNodesTo(intArrayOf(1, 2, 3))
    println(reverseList(firstNode)?.`val`) //3

    firstNode = createNodesTo(intArrayOf(-21, 10))
    println(reverseList(firstNode)?.`val`) //10
}


fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var previous = head
    var currentNode = head.next
    head.next = null

    while (currentNode?.next != null) {
        val newCur = currentNode.next
        currentNode.next = previous
        previous = currentNode
        currentNode = newCur
    }
    currentNode?.next = previous

    return currentNode
}

