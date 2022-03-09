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


    println(lowestCommonAncestor(root, eight, third).`val`)
}


fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode {

    var currentNode = root
    val firstVal: Int = p?.`val`!!
    val secondVal: Int = q?.`val`!!

    while (true) {
        val currentVal: Int = currentNode?.`val`!!

        if (currentVal > firstVal && currentVal > secondVal) {
            currentNode = currentNode.left
        } else if (currentVal < firstVal && currentVal < secondVal) {
            currentNode = currentNode.right
        } else {
            return currentNode
        }
    }

}

