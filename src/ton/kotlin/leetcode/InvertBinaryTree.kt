package ton.kotlin.leetcode

fun main() {

}


fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    root.left = invertTree(root.right).also { root.right = invertTree(root.left) }
    return root
}

fun invertTree3(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    root.left = root.right.also { root.right = root.left }
    invertTree3(root.left)
    invertTree3(root.right)
    return root
}

fun invertTree2(root: TreeNode?): TreeNode? {
    if (root == null) {
        return root
    }

    val queue = ArrayDeque<TreeNode?>()
    queue.addFirst(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()

        node?.left = node?.right.also { node?.right = node?.left }

        if (node?.left != null) {
            queue.add(node.left)
        }
        if (node?.right != null) {
            queue.add(node.right)
        }
    }

    return root
}