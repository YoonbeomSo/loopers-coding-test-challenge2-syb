fun main() {
    val numbers = readLine()!!.split(" ").map { it.toLong() }
    val first = numbers[0]
    val second = numbers[1]
    val third = numbers[2]

    val answer1 = first * second / third
    val answer2 = (first.toDouble() / second * third).toLong()

    println(maxOf(answer1, answer2))
}