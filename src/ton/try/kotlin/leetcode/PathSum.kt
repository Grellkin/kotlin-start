package ton.`try`.kotlin.leetcode

fun main() {
    val root = TreeNode(1)
    val first = TreeNode(2)
    val second = TreeNode(3)
    val third = TreeNode(4)
    val forth = TreeNode(5)

    root.left = first
    root.right = second
    first.left =third
    first.right =forth

    println(hasPathSum(root, 8))//true
    println(hasPathSum(root, 4))//true
    println(hasPathSum(root, 12))//false
    println(hasPathSum(root, 3))//false
    println(hasPathSum(root, 5))//false
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    val curValue = targetSum - root.`val`
    val left = root.left
    val right = root.right
    if (left == null && right == null) return curValue == 0
    return hasPathSum(left, curValue) || hasPathSum(right, curValue)
}


fun hasPathSum3(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    val arrayDeque = ArrayDeque<PairTree>()
    arrayDeque.addFirst(PairTree(root, root.`val`))

    while (arrayDeque.isNotEmpty()) {
        val pair = arrayDeque.removeFirst()
        val counter = pair.counter
        val node = pair.node
        val leaf = node?.left == null && node?.right == null

        if (counter == targetSum && leaf) {
            return true
        } else if (!leaf) {
            var kid = node?.left
            if (kid != null) {
                arrayDeque.add(PairTree(kid, counter + kid.`val`))
            }
            kid = node?.right
            if (kid != null) {
                arrayDeque.add(PairTree(kid, counter + kid.`val`))
            }
        }
    }

    return false
}


fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    val arrayDeque = ArrayDeque<PairTree>()
    arrayDeque.addFirst(PairTree(root))
    var currentSum: Int = root.`val`

    while (arrayDeque.isNotEmpty()) {
        val pair = arrayDeque.first()
        val node = pair.node
        if (node?.left == null && node?.right == null){
            if (targetSum == currentSum) {
                return true
            } else {
                arrayDeque.removeFirst()
                currentSum -= node!!.`val`
            }
        } else if (pair.counter == 2) {
            arrayDeque.removeFirst()
            currentSum -= node.`val`
        } else if (pair.counter == 0 && node.left != null) {
            arrayDeque.addFirst(PairTree(node.left))
            currentSum = currentSum.plus(node.left!!.`val`)
            pair.counter = 1
        } else if (node.right != null) {
            arrayDeque.addFirst(PairTree(node.right))
            currentSum = currentSum.plus(node.right!!.`val`)
            pair.counter = 2
        } else {
            pair.counter = 2
        }

    }

    return false
}

class PairTree(var node: TreeNode?, var counter: Int = 0) {

}