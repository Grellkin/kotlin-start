package ton.kotlin.leetcode

import kotlin.math.max

fun main() {
    val root = TreeNode(2)
    val first = TreeNode(1)
    val second = TreeNode(3)
    val third = TreeNode(4)
    val forth = TreeNode(7)

    root.left = first
    root.right = second
    first.right = third
    second.right =forth

    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}