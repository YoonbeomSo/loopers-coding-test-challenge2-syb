fun main() {
    val maxFloor = readLine()!!.trim().toInt()
    val name = readLine()!!.trim()
    val currentFloor = readLine()!!.trim().toInt()

    if(name == "induck") {
        if (currentFloor % 2 == 0) {
            println(currentFloor)
        } else {
            if (currentFloor < maxFloor) {
                println(currentFloor + 1)
            } else {
                println(currentFloor -1)
            }
        }
    } else {
        if (currentFloor % 2 != 0) {
            println(currentFloor)
        } else {
            if (currentFloor < maxFloor) {
                println(currentFloor + 1)
            } else {
                println(currentFloor - 1)
            }
        }
    }

}