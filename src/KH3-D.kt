import java.lang.Math.round
import kotlin.math.roundToLong

fun main() {
    val testCases = readLine()!!.toInt()
    repeat(testCases) {
        var (employees, totalBonus) = readLine()!!.split(" ").map(String::toLong)
        val sals = readLine()!!.split(" ").map(String::toLong).toMutableList()
        val orderedSals = sals.sorted().toMutableList()
        val bonus = MutableList(sals.size) { 0L }
        var pointer = 0
        while (totalBonus > 0) {
            if (pointer == orderedSals.size-1) {
                val pos = sals.indexOfFirst { it == orderedSals[pointer] }
                orderedSals[pointer] += totalBonus
                bonus[pos] = totalBonus
                totalBonus = 0
            } else {
                var dif = orderedSals[pointer + 1] - orderedSals[pointer]
                if (dif > totalBonus) dif = totalBonus
                if (dif > 1) {
                    val pos = sals.indexOfFirst { it == orderedSals[pointer] }
                    orderedSals[pointer] += dif
                    bonus[pos] = dif
                    totalBonus -= dif
                }
            }
            pointer++
        }
        bonus.forEach{
            print("$it ")
        }
        println()
    }
}
