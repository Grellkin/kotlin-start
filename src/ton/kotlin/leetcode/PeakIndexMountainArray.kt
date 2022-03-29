package ton.kotlin.leetcode

fun main() {
    println(peakIndexInMountainArray(intArrayOf(0, 1, 0))) //1
    println(peakIndexInMountainArray(intArrayOf(0,2, 1, 0))) //1
    println(peakIndexInMountainArray(intArrayOf(0,10, 5, 2))) //1
    println(peakIndexInMountainArray(intArrayOf(0, 1, 50, 43, 15, 8, 7, 3, 1))) //2
    println(peakIndexInMountainArray(intArrayOf(3,5,3,2,0))) //1
    println(peakIndexInMountainArray(intArrayOf(1,2,3))) //2

}


fun peakIndexInMountainArray(arr: IntArray): Int {
    var start = 0
    var end = arr.lastIndex

    while (start <= end) {
        val offset = start + (end - start) / 2
        val middleVal = arr[offset]

        if (middleVal < arr[offset+1]) {
            start = offset + 1
        } else {
            end = offset - 1
        }
    }

    return start
}


fun peakIndexInMountainArray2(arr: IntArray): Int {
    var start = 0
    var end = arr.lastIndex

    while (start < end) {
        val offset = start + (end - start) / 2
        val middleVal = arr[offset]

        val isRightBoarder = offset == arr.lastIndex
        val isLeftBoarder = offset == 0

        if ((isRightBoarder || middleVal > arr[offset + 1]) && (isLeftBoarder || arr[offset - 1] > middleVal) ) {
            end = offset -1
        } else if ((isLeftBoarder || arr[offset - 1] < middleVal) && (isRightBoarder || arr[offset + 1] > middleVal) ) {
            start = offset + 1
        } else {
            return offset
        }
    }

    return start
}