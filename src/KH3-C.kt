import java.lang.Math.round
import kotlin.math.roundToLong

fun main() {
    val testCases = readLine()!!.toInt()
    repeat(testCases) {
        val developers = readLine()!!.toInt()
        val devs = readLine()!!.split(" ").map(String::toInt)
        val positives = devs.filter { it > 0 }
        val max = positives.sum()
        val minPos = positives.min() ?: 0
        val maxNeg = devs.filter { it < 0 }.max() ?: 0
        if (maxNeg == 0 || minPos < 0-maxNeg) {
                println (max-minPos)
                var b = false
                devs.forEach {
                    if (it == minPos && !b){
                        b = true
                        print(0)
                    } else if (it > 0) print(1)
                    else print(0)
                }
        } else {
            println (max+maxNeg)
            var b = false
            devs.forEach {
                if (it == maxNeg && !b){
                    b = true
                    print(1)
                } else if (it > 0) print(1)
                else print(0)
            }
        }
        println()
    }
}
