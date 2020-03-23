package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var tArray = mutableListOf<Char>()
        var allOps = k;
        var needOps = 0;
        for (element in digitString) {
            tArray.add(element)
        }
        for (i in 0 until (tArray.count() / 2)) {
            if (tArray[i] != tArray[tArray.count() - 1 - i]) {
                needOps++;
            }
        }
        if (needOps > allOps) {
            return "-1";
        }
        for (i in 0 until (tArray.count() / 2)) {
            var inEqual = (tArray[i] != tArray[tArray.count() - 1 - i])
            if ((allOps > needOps + 1 || (inEqual && allOps > needOps)) && tArray[i] != '9') {
                tArray[i] = '9'
                allOps--
                tArray[tArray.count() - 1 - i] = '9'
                allOps--
                if (inEqual) {
                    needOps--
                }
            } else if (tArray[i] > tArray[tArray.count() - 1 - i]) {
                tArray[tArray.count() - 1 - i] = tArray[i]
                allOps--
                needOps--
            } else if (tArray[i] < tArray[tArray.count() - 1 - i]) {
                tArray[i] = tArray[tArray.count() - 1 - i]
                allOps--
                needOps--
            }
        }
        if (tArray.count() % 2 > 0 && allOps > 0) {
            tArray[(tArray.count() / 2)] = '9'
        }
        var res = "";
        for (i in 0 until tArray.count()) {
            res += tArray[i]
        }
        return res;
    }
}
