fun main() {
    fun part1(input: List<String>): Int {
        var allLinesSum = 0
        for (line in input) {
//            line.println()
            var lineSum = ""
            val chars = line.chars().toArray()

            for (i in 0 until chars.size) {
                if (chars[i] >= 48 && chars[i] <= 57) {
//                    (chars[i]-48).println()
                    lineSum += chars[i].toChar()
                    break
                }
            }

            for (i in chars.size - 1 downTo 0) {
                if (chars[i] >= 48 && chars[i] <= 57) {
//                    (chars[i]-48).println()
                    lineSum += chars[i].toChar()
                    break
                }
            }
//            lineSum.println()
//            lineSum.toInt().println()
            allLinesSum += lineSum.toInt()
//            println()
        }
//        allLinesSum.println()
        return allLinesSum
    }

    fun getFirstDigit(lineForFirstDigit: String): Int {
        var line = lineForFirstDigit
        while (line.length > 0) {
            if (line[0].isDigit()) {
                return line[0].digitToInt()
            }
            when {
                line.startsWith("one") -> return 1
                line.startsWith("two") -> return 2
                line.startsWith("three") -> return 3
                line.startsWith("four") -> return 4
                line.startsWith("five") -> return 5
                line.startsWith("six") -> return 6
                line.startsWith("seven") -> return 7
                line.startsWith("eight") -> return 8
                line.startsWith("nine") -> return 9
            }
            line = line.drop(1)
//            line.println()
        }
        return -1
    }

    fun getLastDigit(lineForLastDigit: String): Int {
        var line = lineForLastDigit
        while (line.length > 0) {
            val i = line.length - 1
            if (line[i].isDigit()) {
                return line[i].digitToInt()
            }
            when {
                line.endsWith("one") -> return 1
                line.endsWith("two") -> return 2
                line.endsWith("three") -> return 3
                line.endsWith("four") -> return 4
                line.endsWith("five") -> return 5
                line.endsWith("six") -> return 6
                line.endsWith("seven") -> return 7
                line.endsWith("eight") -> return 8
                line.endsWith("nine") -> return 9
            }
            line = line.dropLast(1)
//            line.println()
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        var allLinesSum = 0

        for (line in input) {
            // if starts/ends with digit
            // return digit
            // check if starts/ends with one of "one", two", ..., "nine"
            // transform to digit and return
            // remove first/last char
            // repeat while line.length > 0

            line.println()

            val firstDigit = getFirstDigit(line)
//            firstDigit.println()

            val lastDigit = getLastDigit(line)
//            lastDigit.println()

            val lineSum = firstDigit * 10 + lastDigit
            lineSum.println()

            allLinesSum += lineSum
        }

        allLinesSum.println()
        return allLinesSum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test_part1")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01_test_part2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    //part1(input).println()
    part2(input).println()
}
