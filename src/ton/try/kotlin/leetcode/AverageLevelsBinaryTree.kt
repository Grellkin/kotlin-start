package ton.`try`.kotlin.leetcode


fun main() {
    val root = TreeNode(3)
    val first = TreeNode(9)
    val second = TreeNode(20)
    val third = TreeNode(15)
    val forth = TreeNode(7)

    root.left = first
    root.right = second
    second.left =third
    second.right =forth

    println(averageOfLevels(root).contentToString()) //[3.00000,14.50000,11.00000]

}

fun averageOfLevels(root: TreeNode?): DoubleArray {
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)

    val resList = mutableListOf<Double>()

    while (!queue.isEmpty()) {
        val size = queue.size
        var sum = 0
        for (i in 1..size) {
            val treeNode = queue.removeFirst()
            sum += treeNode?.`val`!!

            if (treeNode.left != null) {
                queue.add(treeNode.left)
            }
            if (treeNode.right !=null) {
                queue.add(treeNode.right)
            }
        }
        resList.add(sum.toDouble() / size)
    }

    return resList.toDoubleArray()
}


fun averageOfLevels2(root: TreeNode?): DoubleArray {
    val queue = ArrayDeque<Pair<TreeNode?, Int>>()
    queue.add(Pair(root, 0))

    var currentLevel = 0
    var currentSum: Long = 0
    var currentAmoutOfNodes: Int = 0

    val resList = mutableListOf<Double>()

    while (!queue.isEmpty()) {
        val (treeNode, i) = queue.removeFirst()
        if (treeNode?.left != null) {
            queue.add(Pair(treeNode.left, i+1))
        }
        if (treeNode?.right !=null) {
            queue.add(Pair(treeNode.right, i+1))
        }
        if (i > currentLevel) {
            resList.add(currentSum.toDouble() / currentAmoutOfNodes)
            currentLevel = i
            currentSum = (treeNode?.`val`!!).toLong()
            currentAmoutOfNodes = 1
        } else {
            currentSum += treeNode?.`val`!!
            currentAmoutOfNodes++
        }
    }
    resList.add(currentSum.toDouble() / currentAmoutOfNodes)
    return resList.toDoubleArray()

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
