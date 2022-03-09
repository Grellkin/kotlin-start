package ton.`try`.kotlin.leetcode.linkedlistcycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    var firstNode = createNodes(intArrayOf(3, 2, 0, -4), 1)
    println(hasCycle3(firstNode))

    firstNode = createNodes(intArrayOf(1, 2), 0)
    println(hasCycle3(firstNode))

    firstNode = createNodes(intArrayOf(1), -1)
    println(hasCycle3(firstNode))

    firstNode = createNodes(intArrayOf(-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5), -1)
    println(hasCycle3(firstNode))
}

fun hasCycle(head: ListNode?): Boolean {

    var currentNode = head

    while (currentNode?.next != null) {

        val newNode = currentNode.next
        currentNode.next = head
        currentNode = newNode

        if (currentNode == null) {
            return false
        }

        if (currentNode.equals(head)) {
            return true
        }

    }

    return false
}

fun hasCycle2(head: ListNode?): Boolean {
    val set = mutableSetOf<ListNode>()
    var currentHead = head
    if (head != null) {
        set.add(head)
    }
    while (currentHead?.next != null) {
        currentHead = currentHead.next

        if (currentHead != null) {
            if (set.contains(currentHead)) {
                return true
            }
            set.add(currentHead)
        }

    }

    return false
}

fun hasCycle3(head: ListNode?): Boolean {

    var hare = head
    var tortle = head

    while(true) {
        if(hare?.next != null && tortle?.next != null) {
            tortle = tortle.next
            hare = hare.next
            if (hare?.next != null) {
                hare = hare?.next
            } else {
                return false
            }
            if (tortle?.equals(hare) == true) {
                return true
            }
        } else {
            return false
        }
    }
}

fun createNodes(array: IntArray, pos: Int): ListNode {

    var currentNode = ListNode(array[0])
    val firstNode = currentNode
    var cycleNode: ListNode? = null

    for (i in 1..array.lastIndex) {
        val newNode = ListNode(array[i])
        currentNode.next = newNode
        currentNode = newNode
        if (i == pos) {
            cycleNode = currentNode
        }
    }
    if (cycleNode != null) {
        currentNode.next = cycleNode
    }
    if (pos == 0 && array.size > 1) {
        currentNode.next = firstNode
    }

    return firstNode
}