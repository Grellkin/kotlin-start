package ton.kotlin.leetcode.medium


fun main() {
    println(Solution().exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        ),
        "ABCC"
    ));
}

class Solution {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val xSize = board.size
        val ySize = board[0].size
        val checkedLetters = Array(xSize) { BooleanArray(ySize) }

        //this is fun in fun declaration for later use
        fun checkCross(i: Int, j: Int, board: Array<CharArray>, currentChar: Int): Boolean {
            if (board[i][j] == word[currentChar]) {

                if (currentChar == word.lastIndex) return true
                checkedLetters[i][j] = true

                //check top
                if (i > 0 && !checkedLetters[i-1][j]) {
                    val found = checkCross(i - 1, j, board, currentChar + 1)
                    if (found) return true
                }

                //check right
                if (j < ySize-1 && !checkedLetters[i][j+1]) {
                    val found = checkCross(i, j+1, board, currentChar + 1)
                    if (found) return true
                }

                //check bottom
                if (i < xSize-1 && !checkedLetters[i+1][j]) {
                    val found = checkCross(i+1, j, board, currentChar + 1)
                    if (found) return true
                }

                //check left
                if (j > 0 && !checkedLetters[i][j-1]) {
                    val found = checkCross(i, j-1, board, currentChar + 1)
                    if (found) return true
                }

                checkedLetters[i][j] = false
            }
            return false
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val res = checkCross(i, j, board, 0)
                if (res) return true
            }
        }

        return false
    }

}
