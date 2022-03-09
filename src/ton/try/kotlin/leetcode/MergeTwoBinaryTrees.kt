package ton.`try`.kotlin.leetcode

import ton.`try`.kotlin.leetcode.TreeNode

fun main() {
    val root2    = TreeNode(1)
    val first2 = TreeNode(3)
    val second2 = TreeNode(2)
    val third2 = TreeNode(5)
//    val forth2 = TreeNode(4)

    root2.left = first2
    root2.right = second2
    first2.left =third2
//    second2.right =forth2

    val root = TreeNode(2)
    val first = TreeNode(1)
    val second = TreeNode(3)
    val third = TreeNode(4)
    val forth = TreeNode(7)

    root.left = first
    root.right = second
    first.right = third
    second.right =forth

    println(mergeTrees(root2, root)?.`val`)

}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if(root2 == null) {
        return root1
    }
    if (root1 == null) {
        return root2
    }

    root1.`val` += root2.`val`

    val left = mergeTrees(root1.left, root2.left)
    val right = mergeTrees(root1.right, root2.right)
    root1.left = left
    root1.right = right

    return root1
}


