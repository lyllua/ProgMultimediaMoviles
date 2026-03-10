fun sumDigits(number: Int): Int {
    var n = number
    var sum = 0
    while (n > 0) {
        sum = sum + (n % 10)
        n = n / 10
    }
    return sum
}

fun main() {
    println(sumDigits(12345))
}
