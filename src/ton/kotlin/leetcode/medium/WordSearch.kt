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

    var checkedLetter: Array<BooleanArray> = Array(1,  { i -> BooleanArray(1)})
    var xBound: Int = 0
    var yBound: Int = 0
    var fWord: String = ""

    fun exist(board: Array<CharArray>, word: String): Boolean {
        xBound = board.size
        yBound = board[0].size
        fWord = word
        checkedLetter = Array(xBound) { BooleanArray(yBound) }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val res = checkit(i, j, board, 0)
                if (res) return true
            }
        }

        return false
    }


    fun checkit(i: Int, j: Int, board: Array<CharArray>, currentChar: Int): Boolean {
        if (board[i][j] == fWord[currentChar]) {

            if (currentChar == fWord.lastIndex) return true
            checkedLetter[i][j] = true


            //check top
            if (i > 0 && !checkedLetter[i-1][j]) {
                val checkit = checkit(i - 1, j, board, currentChar + 1)
                if (checkit) return true
            }

            //check right
            if (j < yBound-1 && !checkedLetter[i][j+1]) {
                val checkit = checkit(i, j+1, board, currentChar + 1)
                if (checkit) return true
            }

            //check bottom
            if (i < xBound-1 && !checkedLetter[i+1][j]) {
                val checkit = checkit(i+1, j, board, currentChar + 1)
                if (checkit) return true
            }

            //check left
            if (j > 0 && !checkedLetter[i][j-1]) {
                val checkit = checkit(i, j-1, board, currentChar + 1)
                if (checkit) return true
            }

            checkedLetter[i][j] = false
        }
        return false
    }
}
