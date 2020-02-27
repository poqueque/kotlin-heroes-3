import java.lang.Math.round
import kotlin.math.roundToLong

fun main() {
    val testCases = readLine()!!.toInt()
    repeat(testCases) {
        val cartoons = readLine()!!.toInt()
        val validRanges = mutableListOf<Interval>()
        repeat(cartoons) {
            var (a, b) = readLine()!!.split(" ").map(String::toLong)
            validRanges.forEach {
                if (it.b in (a..b)) {
                    val t = a-1
                    a = it.b+1
                    it.b = t
                } else if (it.a > a && it.b < b) {
                    val t = it.b+1
                    it.b = it.a-1
                    it.a = a
                    a = t
                } else if (a > it.a && b < it.b) {
                    val t = b+1
                    b = a-1
                    a = it.a
                    it.a = t
                } else if (b in (it.a..it.b)) {
                    val t = b+1
                    b = it.a-1
                    it.a = t
                }
            }
            if (a<=b) {
                validRanges.add(Interval(a,b))
            }
        }
        val s = validRanges.filter { it.a <= it.b }
        if (s.isEmpty())
            println(-1)
        else
            println(s.first().a)
    }
}

data class Interval(var a: Long, var b: Long)
