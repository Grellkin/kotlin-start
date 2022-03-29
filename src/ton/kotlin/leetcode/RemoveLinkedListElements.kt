package ton.kotlin.leetcode

import ton.`try`.kotlin.leetcode.linkedlistcycle.createNodesTo
import ton.kotlin.leetcode.linkedlistcycle.ListNode

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5))
    println(removeElements(firstNode, 3)?.`val`) //1

    firstNode = createNodesTo(intArrayOf(1,2,6,3,4,5,6))
    println(removeElements(firstNode, 6)?.`val`) //1

    firstNode = createNodesTo(intArrayOf())
    println(removeElements(firstNode, 1)?.`val`) //null

    firstNode = createNodesTo(intArrayOf(7,7,7,7))
    println(removeElements(firstNode, 7)?.`val`) //null

    firstNode = createNodesTo(intArrayOf(2, 2, 4, 3, 2, 3))
    println(removeElements(firstNode, 2)?.`val`) //4
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val mock = ListNode(`val` + 1)
    mock.next = head

    var currentNode: ListNode? = mock

    while (currentNode != null && currentNode.next != null) {
        if (currentNode.next?.`val` == `val`) {
            currentNode.next = currentNode.next?.next
        } else {
            currentNode = currentNode.next
        }
    }

    return mock.next
}


fun removeElements2(head: ListNode?, `val`: Int): ListNode? {
    var currentNode = head
    var newHead: ListNode? = null
    var previous: ListNode? = null

    while (currentNode != null) {
        if (currentNode.`val` != `val`) {
            if (newHead == null) {
                newHead = currentNode
            } else {
                previous?.next = currentNode
            }
            previous = currentNode
        }
        currentNode = currentNode.next
    }
    previous?.next = null

    return newHead
}

