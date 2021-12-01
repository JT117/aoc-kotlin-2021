fun main() {
    /**
     * Day 01 - Part 1
     * Parse the list and count the number of time the n+1 number is greater than n
     */
    fun part1(input: List<Int>): Int {
        var numberOfIncrease = 0

        input.windowed(size = 2, step = 1) { (previous, number) ->
            if (number > previous) {
                numberOfIncrease++
            }
        }

        return numberOfIncrease
    }

    /**
     * Day 01 - Part 2
     * Sum 3 by 3 then search with the number of increase
     */
    fun part2(input: List<Int>): Int {
        val sums = mutableListOf<Int>()

        input.windowed(size = 3, step = 1) { (a, b, c) ->
            sums.add(a+b+c)
        }

        return part1(sums)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputToInt("Day01_test")
    check(part1(testInput) == 7)

    val input = readInputToInt("Day01")
    val part1Result = part1(input)
    val part2Result = part2(input)

    println(" #########################  ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}
