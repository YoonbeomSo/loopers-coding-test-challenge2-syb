fun main() {

    val tokens = readLine()!!.split(" ")

    val k1 = tokens[0].toInt()
    val a1 = tokens[1]
    val k2 = tokens[2].toInt()
    val a2 = tokens[3]
    val k3 = tokens[4].toInt()

    fun calculate(a: Int, op: String, b: Int) = when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> throw IllegalArgumentException("Unknown operator: $op")
    }

    val result1 = calculate(k1, a1, calculate(k2, a2, k3))
    val result2 = calculate(calculate(k1, a1, k2), a2, k3)

    val results = listOf(result1, result2).sorted()

    print(results.joinToString("\n"))

}