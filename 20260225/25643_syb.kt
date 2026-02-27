fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val strings = List(n) { br.readLine() }

    for (i in 0 until n - 1) {
        val a = strings[i]  // 아래쪽 문자열 (이미 쌓여 있는 꼭대기)
        val b = strings[i + 1]  //위에 새로 쌓을 문자열

        var found = false;

        for (d in -(m - 1)..(m - 1)) {

            val start = maxOf(0, d)
            val end = minOf(m - 1, d + m - 1)

            val match = (start..end).all { c ->
                a[c] == b[c - d]
            }

            if (match) {
                found = true
                break // 내부 for문 탈출
            }
        }

        if (!found) {
            println(0)
            return //main 함수 종료
        }
    }

    println(1)


}