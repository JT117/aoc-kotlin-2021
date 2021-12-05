import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day05Test {

    private val filename = "Day05_test"
    private val day = Day05()

    @Test
    fun testPart1() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part1(testInput)
        Assertions.assertEquals(5, result)
    }

    @Test
    fun testPart2() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part2(testInput)
        Assertions.assertEquals(12, result)
    }
}