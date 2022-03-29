package ton.kotlin.leetcode.medium

import java.lang.Math.pow


fun main() {
    val arrayOf = arrayOf(
        intArrayOf(0,1,2,0),
        intArrayOf(3,4,5,2),
        intArrayOf(1,3,1,5)
    )
    setZeroes(arrayOf)

    println("Hello")


}

fun setZeroes(matrix: Array<IntArray>): Unit {

    val rows = matrix.lastIndex
    val columns = matrix[0].lastIndex
    var zeroRowFound = false
    var zeroColumnFound = false

    for (v in matrix[0]) {
        if (v == 0) {
            zeroRowFound = true
            break
        }
    }

    for (i in 0..rows) {
        if (matrix[i][0] == 0) {
            zeroColumnFound = true
            break
        }
    }


    for (i in 1..rows) {
        for (j in 1..columns) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (i in 1..rows) {
        if (matrix[i][0] == 0) {
            for (j in 1..columns) {
                matrix[i][j] = 0
            }
        } else {
            for (j in 1..columns) {
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
    }

    if (zeroRowFound) {
        for (i in matrix[0].indices) {
            matrix[0][i] = 0
        }
    }
    if(zeroColumnFound) {
        for (i in matrix.indices) {
            matrix[i][0] = 0
        }
    }

}


//works only till 64-length arrays, for bigger one use setZeroes2
fun setZeroes3(matrix: Array<IntArray>): Unit {

    var columnSet: Long = 0
    var rowSet: Long = 0
    var rowTwo: Long = 1
    for (rowV in matrix) {
        var columnTwo: Long = 1
        for (columnV in rowV) {
            if (columnV == 0) {
                rowSet = rowSet or rowTwo
                columnSet = columnSet or columnTwo
            }
            columnTwo = columnTwo shl 1
        }
        rowTwo = rowTwo shl 1
    }

    rowTwo = 1
    for (v in matrix) {
        var columnTwo: Long = 1
        if (rowTwo and rowSet > 0) {
            for (j in v.indices) {
                v[j] = 0
            }
        } else {
            for (j in v.indices) {
                if (columnTwo and columnSet > 0) {
                    v[j] = 0
                }
                columnTwo = columnTwo shl 1
            }
        }
        rowTwo = rowTwo shl 1
    }
}


fun setZeroes2(matrix: Array<IntArray>): Unit {

    val columnSet = HashSet<Int>()
    val rowSet = HashSet<Int>()

    for ((i,rowV) in matrix.withIndex()) {
        for ((j, columnV) in rowV.withIndex()) {
            if (columnV == 0) {
                rowSet.add(i)
                columnSet.add(j)
            }
        }
    }

    for (ind in rowSet) {
        val column = matrix.get(ind)
        for (i in column.indices) {
            column[i] = 0
        }
    }

    for (ind in matrix.indices) {
        for (column in columnSet) {
            matrix[ind][column] = 0
        }
    }
}