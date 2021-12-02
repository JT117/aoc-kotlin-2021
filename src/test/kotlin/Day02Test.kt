import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun testPart1() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput("Day02_test")
        val result = Day02().part1(testInput)
        Assertions.assertEquals(150, result)
    }

    @Test
    fun testPart2() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInput("Day02_test")
        val result = Day02().part2(testInput)
        Assertions.assertEquals(900, result)
    }
}