fun main() {
    val input: List<String> = readInput("Day05")
    val day = Day05()

    val part1Result = day.part1(input)
    val part2Result = day.part2(input)

    println("############################ ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}

private fun parseInput(input: List<String>): List<Segment> =
    input.map { line -> line.split("->") }
        .map { values ->
            val (startX, startY) = values[0].split(",").map { it.trim().toInt() }
            val (endX, endY) = values[1].split(",").map { it.trim().toInt() }
            Segment(Pair(startX, startY), Pair(endX, endY))
        }


class Day05 {
    fun part1(input: List<String>): Int {
        val segments = parseInput(input)
        val pairToTotal: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

        segments.filter { segment -> segment.isStraightLine }
            .forEach { it.getAllPoints()
                .forEach{ point -> pairToTotal.merge(point, 1, Int::plus) }
            }

        return pairToTotal.filterValues { it > 1 }.count()
    }

    fun part2(input: List<String>): Int {
        val segments = parseInput(input)
        val pairToTotal: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

        segments
            .forEach { it.getAllPoints()
                .forEach{ point -> pairToTotal.merge(point, 1, Int::plus) }
            }

        return pairToTotal.filterValues { it > 1 }.count()
    }

}

data class Segment(val start: Pair<Int, Int>, val end: Pair<Int, Int>){
    val isStraightLine = start.first == end.first || start.second == end.second

    fun getAllPoints(): List<Pair<Int, Int>>{
        val points = mutableListOf<Pair<Int,Int>>()
        val startAndEndSorted = listOf(start, end)
            .sortedBy { it.first }
            .sortedBy { it.second }

        if (isStraightLine) {
            if (startAndEndSorted[0].first != startAndEndSorted[1].first) {
                (startAndEndSorted[0].first..startAndEndSorted[1].first).forEach {
                    points.add(Pair(it, startAndEndSorted[0].second))
                }
            }

            if (startAndEndSorted[0].second != startAndEndSorted[1].second) {
                (startAndEndSorted[0].second..startAndEndSorted[1].second).forEach {
                    points.add(Pair(startAndEndSorted[0].first, it))
                }
            }
        }else{
            points.add(start)
            points.add(end)

            var offset = 1
            val xDir = if(startAndEndSorted[1].first - startAndEndSorted[0].first > 0) 1 else -1
            val yDir = if(startAndEndSorted[1].second - startAndEndSorted[0].second > 0) 1 else -1

            while(startAndEndSorted[0].first + (offset * xDir) != startAndEndSorted[1].first && startAndEndSorted[0].second + (offset * yDir) != startAndEndSorted[1].second) {
                val element = Pair(startAndEndSorted[0].first + (offset * xDir), startAndEndSorted[0].second + (offset * yDir))
                points.add(element)
                offset++
            }
        }

        return points
    }
}