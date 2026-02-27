fun main() {

    val d2 = "d2"
    val D2 = "D2"
    val unrated = "unrated"

    val line = readLine() ?: ""

    if(line.contains(d2) || line.contains(D2)) {
        println(D2)
    } else {
        println(unrated)
    }

}