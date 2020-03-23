package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        var min = 0
        var max = 0
        var sorted = input.asList().sortedBy { it }
        var i = 0
        while (i < sorted.count()) {
            max += (if (i == 0) 0 else sorted[i])
            min += (if (i == sorted.count() - 1) 0 else sorted[i])
            i++
        }
        return arrayOf(min, max).toIntArray()
    }
}
