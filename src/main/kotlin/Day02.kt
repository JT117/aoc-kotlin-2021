fun main() {

    val input = readInput("Day02")
    val day02 = Day02()
    val part1Result = day02.part1(input)
    val part2Result = day02.part2(input)

    println("############################ ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}


class Day02 {

    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0

        input.forEach { command ->
            val (keyword: String, value: String) = command.split(" ")

            when (keyword){
                "forward" ->  x += value.toInt()
                "down" -> y += value.toInt()
                "up" -> y-= value.toInt()
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0

        input.forEach { command ->
            val (keyword: String, value: String) = command.split(" ")

            when (keyword){
                "forward" ->  {
                    y += aim * value.toInt()
                    x += value.toInt()
                }
                "down" -> aim += value.toInt()
                "up" -> aim-= value.toInt()
            }
        }

        return x * y
    }
}

