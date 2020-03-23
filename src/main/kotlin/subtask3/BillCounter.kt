package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var realSum = 0
        for (i in 0 until bill.count()) {
            realSum += (if (i == k) 0 else bill[i])
        }
        realSum /= 2
        return if (realSum == b) {
            "Bon Appetit"
        } else {
            (b - realSum).toString()
        }
    }
}
