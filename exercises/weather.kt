fun weatherToday(option: Int): String {
    return when (option) {
        1 -> "Sunny"
        2 -> "Cloudy"
        3 -> "Rainy"
        4 -> "Stormy"
        5 -> "Snowy"
        else -> "Undefined"
    }
}

fun main() {
    val option = 3
    println(weatherToday(option))
}
