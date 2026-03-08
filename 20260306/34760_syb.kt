fun main() {
    val elephants = readLine()!!.split(" ").map{ it.toInt() }

    var carrotLenght = 0;
    var sameMaxCount = 0;
    var lastElephant = elephants[elephants.lastIndex]

    for (elephant in elephants) {
        if (carrotLenght < elephant) {
            carrotLenght = elephant + 1
        }
        if (lastElephant == elephant) {
            sameMaxCount++
        }
    }

    if (sameMaxCount == 1 && carrotLenght == lastElephant + 1) {
        carrotLenght--
    }

    println(carrotLenght)
}