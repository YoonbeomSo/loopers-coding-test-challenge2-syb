fun main() {
    val t = readLine()!!.trim().toInt()
    repeat(t) {
        val price = readLine()!!.trim().toDouble()
        val discounted = price * 0.8
        println("${"$"}${"%.2f".format(discounted)}")
    }
}