package subtask4

class StringParser {

    private fun addRange(rArr: MutableList<Pair<Int, Int>>, arr: MutableList<Int>, j: Int) {
        if (arr.count() > 0) {
            var start = arr.last()
            rArr.add(Pair(start, j - start))
            arr.removeAt(arr.lastIndex)
        }
    }

    fun getResult(inputString: String): Array<String> {
        val rangeArray = mutableListOf<Pair<Int, Int>>()
        var tArray = mutableListOf<Int>()
        var sArray = mutableListOf<Int>()
        var qArray = mutableListOf<Int>()
        for (i in inputString.indices) {
            var s = inputString[i]
            if (s == '<') {
                tArray.add(i + 1)
            } else if (s == '(') {
                sArray.add(i + 1)
            } else if (s == '[') {
                qArray.add(i + 1)
            } else if (s == '>') {
                addRange(rangeArray, tArray, i);
            } else if (s == ')') {
                addRange(rangeArray, sArray, i);
            } else if (s == ']') {
                addRange(rangeArray, qArray, i);
            }
        }
        var resultArray = mutableListOf<String>()
        for (range in rangeArray.sortedBy { it.first }) {
            resultArray.add(inputString.substring(range.first, range.first + range.second))
        }
        return resultArray.toTypedArray();
    }
}