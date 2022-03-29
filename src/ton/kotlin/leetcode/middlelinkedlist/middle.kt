package ton.`try`.kotlin.leetcode.linkedlistcycle

import ton.kotlin.leetcode.linkedlistcycle.ListNode

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5))
    println(middleNode(firstNode)?.`val`) //3

    firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5, 6))
    println(middleNode(firstNode)?.`val`) //4

    firstNode = createNodesTo(intArrayOf(1, 2, 3))
    println(middleNode(firstNode)?.`val`) //2

    firstNode = createNodesTo(intArrayOf(-21, 10))
    println(middleNode(firstNode)?.`val`) //10
}


fun middleNode(head: ListNode?): ListNode? {

    var currantNode = head
    var middleNode = head

    while (currantNode?.next != null) {
        currantNode = currantNode.next
        currantNode = currantNode?.next

        middleNode = middleNode?.next
    }

    return middleNode
}


fun middleNode3(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var currantNode = head
    var middleNode = head
    var counter = 1

    while (currantNode?.next != null) {
        currantNode = currantNode.next
        counter++
        if (counter % 2 == 1) {
            middleNode = middleNode?.next
        }
    }

    if (counter % 2 == 0) {
        middleNode = middleNode?.next
    }

    return middleNode
}


fun middleNode2(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var currantNode = head
    var counter = 1

    while (currantNode?.next != null) {
        currantNode = currantNode.next
        counter++
    }
    counter = (counter / 2) + 1

    currantNode = head
    while (counter != 1) {
        currantNode = currantNode?.next
        counter--
    }

    return currantNode
}

fun createNodesTo(array: IntArray): ListNode? {
    if (array.size == 0) {
        return null;
    }

    var currentNode = ListNode(array[0])
    val firstNode = currentNode

    for (i in 1..array.lastIndex) {
        val newNode = ListNode(array[i])
        currentNode.next = newNode
        currentNode = newNode
    }

    return firstNode
}