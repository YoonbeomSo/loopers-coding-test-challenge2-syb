import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val s = sc.next()

    var count = 0

    for (i in 0 until n) {
        if (s[i] != 'A') continue
        for (j in i + 2 until n) {
            if (s[j] != 'A') continue
            val mid = s.substring(i + 1, j)
            if (!mid.contains('A') && mid.count { it == 'N' } == 1) {
                count++
            }
        }
    }

    println(count)
}
