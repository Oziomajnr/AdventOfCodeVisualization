package day10

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


val screen = List(6) {
    MutableList(40) {
        '.'
    }
}

fun solvePart2(): Flow<ScreenState> {
    return flow {
        var numberOfCycles = 0

        var spritePosition = 1
        parseInput(lines).forEach {
            repeat(it.cycles) {
                numberOfCycles++
                val crtIndex = (numberOfCycles - 1) % 40
                screen[(numberOfCycles - 1) / 40][crtIndex] = if (crtIndex in spritePosition - 1..spritePosition + 1) {
                    '#'
                } else {
                    '.'
                }
            }
            spritePosition += it.value
            emit(ScreenState(screen, spritePosition))
        }
    }
}

fun parseInput(lines: List<String>): List<Command> {
    return lines.map { line ->
        line.split(" ").run {
            when (this[0]) {
                "addx" -> {
                    Command(this[1].toInt(), 2)
                }

                else -> {
                    Command(0, 1)
                }
            }
        }
    }
}

data class Command(val value: Int, val cycles: Int)
data class ScreenState(val screen: List<List<Char>>, val spritePosition: Int)


val lines =
    ("noop\n" + "addx 5\n" + "addx -2\n" + "noop\n" + "noop\n" + "addx 7\n" + "addx 15\n" + "addx -14\n" + "addx 2\n" + "addx 7\n" + "noop\n" + "addx -2\n" + "noop\n" + "addx 3\n" + "addx 4\n" + "noop\n" + "noop\n" + "addx 5\n" + "noop\n" + "noop\n" + "addx 1\n" + "addx 2\n" + "addx 5\n" + "addx -40\n" + "noop\n" + "addx 5\n" + "addx 2\n" + "addx 15\n" + "noop\n" + "addx -10\n" + "addx 3\n" + "noop\n" + "addx 2\n" + "addx -15\n" + "addx 20\n" + "addx -2\n" + "addx 2\n" + "addx 5\n" + "addx 3\n" + "addx -2\n" + "noop\n" + "noop\n" + "noop\n" + "addx 5\n" + "addx 2\n" + "addx 5\n" + "addx -38\n" + "addx 3\n" + "noop\n" + "addx 2\n" + "addx 5\n" + "noop\n" + "noop\n" + "addx -2\n" + "addx 5\n" + "addx 2\n" + "addx -2\n" + "noop\n" + "addx 7\n" + "noop\n" + "addx 10\n" + "addx -5\n" + "noop\n" + "noop\n" + "noop\n" + "addx -15\n" + "addx 22\n" + "addx 3\n" + "noop\n" + "noop\n" + "addx 2\n" + "addx -37\n" + "noop\n" + "noop\n" + "addx 13\n" + "addx -10\n" + "noop\n" + "addx -5\n" + "addx 10\n" + "addx 5\n" + "addx 2\n" + "addx -6\n" + "addx 11\n" + "addx -2\n" + "addx 2\n" + "addx 5\n" + "addx 3\n" + "noop\n" + "addx 3\n" + "addx -2\n" + "noop\n" + "addx 6\n" + "addx -22\n" + "addx 23\n" + "addx -38\n" + "noop\n" + "addx 7\n" + "noop\n" + "addx 5\n" + "noop\n" + "noop\n" + "noop\n" + "addx 9\n" + "addx -8\n" + "addx 2\n" + "addx 7\n" + "noop\n" + "noop\n" + "addx 2\n" + "addx -4\n" + "addx 5\n" + "addx 5\n" + "addx 2\n" + "addx -26\n" + "addx 31\n" + "noop\n" + "addx 3\n" + "noop\n" + "addx -40\n" + "addx 7\n" + "noop\n" + "noop\n" + "noop\n" + "noop\n" + "addx 2\n" + "addx 4\n" + "noop\n" + "addx -1\n" + "addx 5\n" + "noop\n" + "addx 1\n" + "noop\n" + "addx 2\n" + "addx 5\n" + "addx 2\n" + "noop\n" + "noop\n" + "noop\n" + "addx 5\n" + "addx 1\n" + "noop\n" + "addx 4\n" + "addx 3\n" + "noop\n" + "addx -24\n" + "noop").split(
        "\n"
    )