import java.util.Scanner

// BOJ 32401 - ANAN
// 문자열에서 "A...N...A" 패턴(ANA, ABNA, ANNA 등)의 개수를 구하는 문제
// 조건: 두 A 사이에 A는 없어야 하고, N은 정확히 1개만 있어야 함
//
// 풀이: 이중 루프 브루트포스 O(N^2)
// - 바깥 루프(i): 첫 번째 A의 위치를 찾음
// - 안쪽 루프(j): 두 번째 A의 위치를 찾음 (i+2부터, 최소 사이에 1글자 필요)
// - 두 A 사이 부분문자열에서 A가 없고 N이 정확히 1개인 경우만 카운트
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val s = sc.next()

    var count = 0

    for (i in 0 until n) {
        if (s[i] != 'A') continue // 첫 번째 A 찾기
        for (j in i + 2 until n) {
            if (s[j] != 'A') continue // 두 번째 A 찾기
            val mid = s.substring(i + 1, j) // 두 A 사이의 부분문자열
            if (!mid.contains('A') && mid.count { it == 'N' } == 1) {
                count++ // A가 없고 N이 정확히 1개면 유효한 패턴
            }
        }
    }

    println(count)
}
