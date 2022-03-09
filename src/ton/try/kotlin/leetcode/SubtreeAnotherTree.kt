package ton.`try`.kotlin.leetcode

fun main() {
    val root = TreeNode(6)
    val first = TreeNode(2)
    val second = TreeNode(8)
    val third = TreeNode(0)
    val forth = TreeNode(4)

    val fifth = TreeNode(7)
    val sixth = TreeNode(9)

    val seventh = TreeNode(3)
    val eight = TreeNode(5)

    root.left = first
    root.right = second

    first.left = third
    first.right = forth

    second.left = fifth
    second.right = sixth

    forth.left = seventh
    forth.right = eight

    println(isSubtree(root, root))
    println(isSubtree(root, second))

    val alternativeWay = TreeNode(4)
    alternativeWay.left = seventh
    alternativeWay.right = fifth

    println(isSubtree(root, alternativeWay))
}

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    val deque = ArrayDeque<TreeNode?>()
    deque.addFirst(root)

    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()

        if ((node?.`val` == subRoot?.`val`) && check(node, subRoot)) {
            return true
        }

        if (node?.left != null) {
            deque.add(node.left)
        }
        if (node?.right != null) {
            deque.add(node.right)
        }
    }

    return false
}

fun check(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) {
        return true
    }
    if (root == null || subRoot == null) {
        return false
    }

    if (root.`val` == subRoot.`val`) {
        return check(root.left, subRoot.left) && check(root.right, subRoot.right)
    }

    return false
}