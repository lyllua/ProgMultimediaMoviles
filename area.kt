import kotlin.math.PI

fun circleArea(radio: Int): Double {
    return PI * radio * radio
}
	
fun main() {
    println(circleArea(2))
}