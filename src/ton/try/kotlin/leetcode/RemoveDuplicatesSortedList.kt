package ton.`try`.kotlin.leetcode

import ton.`try`.kotlin.leetcode.linkedlistcycle.ListNode
import ton.`try`.kotlin.leetcode.linkedlistcycle.createNodesTo
import java.util.*

fun main() {
    var firstNode = createNodesTo(intArrayOf(1, 2, 3, 4, 5))
    println(deleteDuplicates(firstNode)?.`val`) //1

    firstNode = createNodesTo(intArrayOf(1,2,6,3,4,5,6))
    println(deleteDuplicates(firstNode)?.`val`) //1

    firstNode = createNodesTo(intArrayOf())
    println(deleteDuplicates(firstNode)?.`val`) //null

    firstNode = createNodesTo(intArrayOf(7,7,7,7))
    println(deleteDuplicates(firstNode)?.`val`) //7

    firstNode = createNodesTo(intArrayOf(2, 2, 4, 3, 2, 3))
    println(deleteDuplicates(firstNode)?.`val`) //2
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
         return null
    }

    val fakeNode = ListNode(head.`val` - 1 )
    fakeNode.next = head
    var currentNode: ListNode? = fakeNode

    while (currentNode?.next != null) {
        val next = currentNode.next
        if (next?.`val` == currentNode.`val`) {
            currentNode.next = next.next
        } else {
            currentNode = next
        }
    }

    return fakeNode.next
}

fun deleteDuplicates3(head: ListNode?): ListNode? {
    val comparator = kotlin.Comparator<ListNode?> { o1, o2 -> o2?.`val`?.compareTo(o1?.`val`!!)!! }

    val sortedSet = TreeSet(comparator)

    var currentNode = head
    while (currentNode != null) {
        sortedSet.add(currentNode)
        currentNode = currentNode.next
    }

    var previous: ListNode? = null
    sortedSet.iterator().forEach {
        run {
            currentNode = it
            currentNode?.next = previous
            previous = currentNode
        }
    }

    return currentNode
}



fun deleteDuplicates2(head: ListNode?): ListNode? {
    val sortedSet = TreeSet(Comparator.comparingInt<ListNode?> { it.`val` }.reversed())

    var currentNode = head
    while (currentNode != null) {
        sortedSet.add(currentNode)
        currentNode = currentNode.next
    }

    var previous: ListNode? = null
    sortedSet.iterator().forEach {
        run {
            currentNode = it
            currentNode?.next = previous
            previous = currentNode
        }
    }

    return currentNode
}

