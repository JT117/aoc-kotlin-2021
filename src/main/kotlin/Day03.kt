import kotlin.math.roundToInt

fun main() {
    val input = readInput("Day03")
    val day = Day03()

    val part1Result = day.part1(input)
    val part2Result = day.part2(input)

    println("############################ ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}

class Day03 {
    fun part1(input: List<String>): Int {
        val numberOfColumn = input[0].length

        val gamma = (0 until numberOfColumn)
            .map { i -> mostCommonBitAt(input, i) }
            .joinToString(separator = "")
            .toInt(2)

        val epsilon = (0 until numberOfColumn)
            .map { i -> leastCommonBitAt(input, i) }
            .joinToString(separator = "")
            .toInt(2)

        println("gamme: $gamma, epsilon: $epsilon")

        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        val oxygenData = filterDataByBitCriteriaUntilLast(input, this::mostCommonBitAt)
        val oxygenRating = oxygenData.first().toInt(2)

        val co2ScrubberData = filterDataByBitCriteriaUntilLast(input, this::leastCommonBitAt)
        val co2ScrubberRating = co2ScrubberData.first().toInt(2)

        println("oxygen rating: $oxygenRating, co2 scrubber rating: $co2ScrubberRating")

        return oxygenRating * co2ScrubberRating
    }

    private fun filterDataByBitCriteriaUntilLast(
        input: List<String>,
        bitCriteriaSelector: (List<String>, i: Int) -> Int
    ): List<String> {
        var data = input
        var position = 0
        while (data.size > 1) {
            val bitCriteria = bitCriteriaSelector.invoke(data, position)
            data = data.filter { row -> row[position].digitToInt() == bitCriteria }
            position++
        }
        return data
    }

    private fun numberOfOneAt(data: List<String>, i: Int): Int = data.sumOf { row -> row[i].digitToInt() }
    private fun mostCommonBitAt(data: List<String>, i: Int): Int = if (numberOfOneAt(data, i) >= (data.size.toFloat() / 2f).roundToInt()) 1 else 0
    private fun leastCommonBitAt(data: List<String>, i: Int): Int = if (numberOfOneAt(data, i) >= (data.size.toFloat() / 2f).roundToInt()) 0 else 1
}