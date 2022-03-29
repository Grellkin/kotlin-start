package ton.kotlin.leetcode

import java.lang.Integer.max

fun main() {
    val root = TreeNode(3)
    val first = TreeNode(9)
    val second = TreeNode(20)
    val third = TreeNode(15)
    val forth = TreeNode(7)

    root.left = first
    root.right = second
    first.left = TreeNode(3)
    second.left =third
    second.right =forth

    println(diameterOfBinaryTree(root))
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val result = intArrayOf(0)
    recursive(root, result)
    return result[0]
}

fun recursive(root: TreeNode, max: IntArray): Int {
    val left = root.left
    val right = root.right
    var leftLength = 0
    var rightLength = 0
    if (left != null) {
        leftLength = recursive(left, max)
    }
    if (right != null) {
        rightLength = recursive(right, max)
    }

    if (max[0] < (leftLength + rightLength)) {
        max[0] = leftLength + rightLength
    }

    return max(leftLength, rightLength) + 1
}



fun diameterOfBinaryTree2(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val result = intArrayOf(0)
    recursive(root, result)
    return result[0]
}

fun recursive2(root: TreeNode, max: IntArray): Int {
    val left = root.left
    val right = root.right
    var leftLength = 0
    var rightLength = 0
    if (left != null) {
        leftLength = recursive(left, max)
    }
    if (right != null) {
        rightLength = recursive(right, max)
    }

    if (max[0] < (leftLength + rightLength)) {
        max[0] = leftLength + rightLength
    }

    return max(leftLength, rightLength) + 1
}