package ton.kotlin.leetcode.diameterbinary

import ton.kotlin.leetcode.TreeNode
import kotlin.math.max

class Solution {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var result = 0

        fun recursive(root: TreeNode): Int {
            val left = root.left
            val right = root.right
            var leftLength = 0
            var rightLength = 0
            if (left != null) {
                leftLength = recursive(left)
            }
            if (right != null) {
                rightLength = recursive(right)
            }
            result = max(result, leftLength + rightLength)
            return Integer.max(leftLength, rightLength) + 1
        }

        recursive(root)
        return result
    }
}


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

    println(Solution().diameterOfBinaryTree(root))
}