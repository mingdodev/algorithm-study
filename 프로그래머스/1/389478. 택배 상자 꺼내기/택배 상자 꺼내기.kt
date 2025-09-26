class Solution {
    fun getStackNumber(n: Int, w: Int, num: Int): Int {
        val index = num % w
        val division = num / w
        if (index != 0) {
            if (division % 2 == 0) return index
            else return w + 1 - index
        }
        else {
            if (division % 2 == 0) return 1
            else return w
        }
    }
    fun solution(n: Int, w: Int, num: Int): Int {
        val targetStackNumber = getStackNumber(n, w, num)
        return (num..n).count { i ->
            getStackNumber(n, w, i) == targetStackNumber
        }
    }
}