import java.lang.Math.round
import kotlin.math.roundToLong

fun main() {
    val testCases = readLine()!!.toInt()
    repeat(testCases) {
        val cartoons = readLine()!!.toInt()
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        var validRange = (a..b).toList().asSequence()
        repeat(cartoons-1) {
            val (a, b) = readLine()!!.split(" ").map(String::toLong)
            validRange -= (a..b).toList().asSequence()
        }
        println(validRange.firstOrNull() ?: -1)
    }
}
