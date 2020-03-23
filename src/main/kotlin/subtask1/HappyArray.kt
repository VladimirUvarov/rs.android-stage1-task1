package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyList = mutableListOf<Int>()
        happyList.addAll(sadArray.asList())
        var i = 0
        while (i < happyList.count()) {
            if (i == 0 || i == happyList.count() - 1) {
                i += 1
            } else if (happyList[i] > (happyList[i - 1] + happyList[i + 1])) {
                happyList.removeAt(i)
                i -= 1
            } else {
                i += 1
            }
        }
        return happyList.toIntArray()
    }
}