package ton.`try`.kotlin.leetcode

fun main() {
    val root2    = TreeNode(1)
    val first2 = TreeNode(2)
//    val second2 = TreeNode(3)
//    val third2 = TreeNode(4)
//    val forth2 = TreeNode(4)

    root2.left = first2
//    root2.right = second2
//    second2.left =third2
//    second2.right =forth2

    val root = TreeNode(1)
    val first = TreeNode(2)
//    val second = TreeNode(3)
//    val third = TreeNode(4)
//    val forth = TreeNode(5)

    root.left = null
    root.right = first
//    second.left = s
//    second.right =forth

    println(isSameTree(root2, root)) //true

}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    val deque = ArrayDeque<TreeNode?>()

    deque.addFirst(p)
    deque.addLast(q)

    while (deque.isNotEmpty()) {
        val first = deque.removeFirstOrNull()
        val last = deque.removeLastOrNull()

        if (first == null && last == null) {
            continue
        }

        if (first == null || last == null || first.`val` != last.`val`) {
            return false
        }

        deque.addFirst(first.left)
        deque.addFirst(first.right)
        deque.addLast(last.left)
        deque.addLast(last.right)
    }

    return true

}


fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {

    val firstDeque = ArrayDeque<TreeNode?>()
    val secondDeque = ArrayDeque<TreeNode?>()

    firstDeque.addFirst(p)
    secondDeque.addFirst(q)

    while (firstDeque.isNotEmpty()) {
        if (firstDeque.first()?.`val` != secondDeque.first()?.`val`) {
            return false
        }
        val first = firstDeque.removeFirst()
        val second = secondDeque.removeFirst()

        if (first?.left != null || second?.left != null) {
            firstDeque.addFirst(first?.left)
            secondDeque.addFirst(second?.left)
            if (firstDeque.first()?.`val` != secondDeque.first()?.`val`) {
                return false
            }

        }
        if (first?.right != null || second?.right != null) {
            firstDeque.addFirst(first?.right)
            secondDeque.addFirst(second?.right)
        }

    }

    if (secondDeque.isNotEmpty()) {
        return false
    }

    return true

}
