fun main() {
    val input: List<String> = readInput("Day04")
    val day = Day04()

    val part1Result = day.part1(input)
    val part2Result = day.part2(input)

    println("############################ ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}

private fun parseInput(input: List<String>): Pair<List<Int>, List<Grid>> {
    val numbersToMark: List<Int> = input.first().split(",").map { it.toInt() }
    val grids: List<Grid> = input.subList(2, input.size)
        .filter { it.isNotEmpty() }
        .chunked(5) { rows ->
            Grid(rows.map { fromRowAsStringToMutableListInt(it) })
        }

    return Pair(numbersToMark, grids)
}

private fun fromRowAsStringToMutableListInt(row: String) = row
    .split(" ")
    .filter { it.isNotEmpty() }
    .map { it.toInt() }
    .toMutableList()

class Day04 {
    fun part1(input: List<String>): Int {
        val (numbersToMark, grids) = parseInput(input)

        for (number in numbersToMark) {
            grids.forEach { grid -> grid.markNumber(number) }

            val winner = grids.firstOrNull { grid -> grid.hasWon() }

            if (winner != null) {
                return winner.totalValue * number
            }
        }

        return 0
    }

    fun part2(input: List<String>): Int {
        val (numbersToMark, originalGrids) = parseInput(input)

        val grids: MutableList<Grid> = originalGrids.toMutableList()

        var lastWinnerScore = 0

        for (number in numbersToMark) {
            grids.forEach { grid -> grid.markNumber(number) }

            grids.filter { grid -> grid.hasWon() }
                .forEach { winner ->
                    grids.remove(winner)
                    lastWinnerScore = winner.totalValue * number
                }
        }

        return lastWinnerScore
    }

}

data class Grid(val rows: List<MutableList<Int>>) {
    val totalValue: Int by lazy { rows.sumOf { row -> row.sum() } }

    private fun getColumns(): List<MutableList<Int>> = rows.indices.map { i -> columnAt(i) }

    private fun columnAt(i: Int): MutableList<Int> = rows.map { row -> row[i] }.toMutableList()

    fun hasWon(): Boolean = rows.any { row -> row.sum() == 0 } || getColumns().any { column -> column.sum() == 0 }

    fun markNumber(number: Int) = rows.forEach { row -> row.replaceAll { value -> if (value == number) 0 else value } }

    override fun toString(): String {
        val builder = StringBuilder()
        rows.forEach { builder.append(it.joinToString()).append("\n") }
        return builder.toString()
    }


}