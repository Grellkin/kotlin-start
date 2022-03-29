package ton.kotlin.leetcode


fun main() {
    val root = TreeNode(1)
    val first = TreeNode(2)
    val second = TreeNode(3)
    val third = TreeNode(4)
    val forth = TreeNode(5)

    root.left = first
    root.right = second
    second.left =third
    second.right =forth

    println(minDepth(root)) //2
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val queue = ArrayDeque<TreeNode?>()
    queue.addFirst(root)
    var currentDepth = 0

    while (queue.isNotEmpty()) {
        val size = queue.size

        currentDepth++
        for (i in 1..size) {
            val treeNode = queue.removeFirst()
            val left = treeNode?.left
            val right = treeNode?.right
            if (left == null && right == null) {
                return currentDepth
            }
            if (left != null) {
                queue.add(left)
            }
            if (treeNode.right != null) {
                queue.add(right)
            }
        }
    }

    return currentDepth
}


fun minDepth2(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val queue = ArrayDeque<Pair<TreeNode?, Int >>()
    queue.addFirst(Pair(root, 1))

    while (queue.isNotEmpty()) {
        val (treeNode, i) = queue.removeFirst()
        val left = treeNode?.left
        val right = treeNode?.right
        if (left == null && right == null) {
            return i
        }
        if (left != null) {
            queue.add(Pair(left, i + 1))
        }
        if (treeNode.right != null) {
            queue.add(Pair(right, i + 1))
        }
    }

    return -1
}