import java.lang.Math.round
import kotlin.math.roundToLong

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        val u = readLine()!!.toLong()
        format(u)
    }
}

fun format(u: Long) {
    when (u){
        in (0..999) -> println(u)
        in (1000..999499) -> {
            val k = (u+500) / 1000
            println ("${k}K")
        }
        else -> {
            val m = (u+500000) / 1000000
            println ("${m}M")
        }
    }
}
