package ton.kotlin.leetcode.medium


fun main() {
    val spiralOrder = spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf( 5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
    )
    val spiralOrder2 = spiralOrder(
        arrayOf(
            intArrayOf(7),
            intArrayOf(9),
            intArrayOf(6)
        )
    )


    println(spiralOrder)
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var verticalSize = matrix.size -1
    var horizontalSize = matrix[0].size

    if (verticalSize == 0) {
        return matrix[0].asList()
    }

    var verticalPointer = 0
    var horizontalPointer = 0
    val resList = mutableListOf<Int>()

    var previousVerticalMove = true
    var previousHorizontalMove = true

    while(true) {

        previousHorizontalMove = 1 in 1 until horizontalSize
        resList.add(matrix[verticalPointer][horizontalPointer])

        for (i in 1 until horizontalSize) {
            horizontalPointer++
            resList.add(matrix[verticalPointer][horizontalPointer])
        }

        if (previousVerticalMove) {
            horizontalSize--
            verticalPointer++
        } else {
            break
        }

        previousVerticalMove = 1 in 1 until verticalSize
        resList.add(matrix[verticalPointer][horizontalPointer])

        for (j in 1 until verticalSize) {
            verticalPointer++
            resList.add(matrix[verticalPointer][horizontalPointer])
        }

        if (previousHorizontalMove) {
            verticalSize--
            horizontalPointer--
        } else {
            break
        }

        previousHorizontalMove = 1 in 1 until horizontalSize
        resList.add(matrix[verticalPointer][horizontalPointer])


        for (i in 1 until horizontalSize) {
            horizontalPointer--
            resList.add(matrix[verticalPointer][horizontalPointer])
        }

        if (previousVerticalMove) {
            horizontalSize--
            verticalPointer--
        } else {
            break
        }

        previousVerticalMove = 1 in 1 until verticalSize
        resList.add(matrix[verticalPointer][horizontalPointer])

        for (j in 1 until verticalSize) {
            verticalPointer--
            resList.add(matrix[verticalPointer][horizontalPointer])
        }

        if (previousHorizontalMove) {
            verticalSize--
            horizontalPointer++
        } else {
            break
        }
    }

    return resList
}
