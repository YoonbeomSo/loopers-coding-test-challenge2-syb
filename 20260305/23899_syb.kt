fun main() {

    // 5
    val N = readLine()!!.trim().toInt()

    val a = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
    val b = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()

    if (a.contentEquals(b)) {
        println(1)
        return
    }

    // 4 3 2 1
    for (i in (N - 1) downTo 1) {

        var max = a[i]
        var maxIndex = i

        //0
        //0 1
        //0 1 2
        //0 1 2 3
        for (j in 0 until i) {
            if (a[j] > max) {
                max = a[j]
                maxIndex = j
            }
        }

        if (i != maxIndex) {
            val tmp = a[i]
            a[i] = max
            a[maxIndex] = tmp
        }

        if (a.contentEquals(b)) {
            println(1)
            return
        }
    }
    println(0)
}