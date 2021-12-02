import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun testPart1() {
        // test if implementation meets criteria from the description, like:
        val testInput = readInputToInt("Day01_test")
        val result = Day01().part1(testInput)
        Assertions.assertEquals(7, result)
    }
}