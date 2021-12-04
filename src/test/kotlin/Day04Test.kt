import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day04Test {

    private val filename = "Day04_test"
    private val day = Day04()

    @Test
    fun testPart1() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part1(testInput)
        Assertions.assertEquals(4512, result)
    }

    @Test
    fun testPart2() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part2(testInput)
        Assertions.assertEquals(1924, result)
    }
}