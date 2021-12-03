import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day03Test {

    private val filename = "Day03_test"
    private val day = Day03()

    @Test
    fun testPart1() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part1(testInput)
        Assertions.assertEquals(198, result)
    }

    @Test
    fun testPart2() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput(filename)
        val result = day.part2(testInput)
        Assertions.assertEquals(230, result)
    }
}