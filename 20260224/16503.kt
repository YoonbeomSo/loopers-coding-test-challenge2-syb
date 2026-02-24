// BOJ 16503 - 괄호 없는 사칙연산
// 숫자 3개(K1, K2, K3)와 연산자 2개(O1, O2)가 주어진다.
// 모든 연산자의 우선순위가 동등할 때, 가능한 두 가지 계산 순서:
//   1) (K1 O1 K2) O2 K3  (왼쪽 먼저)
//   2) K1 O1 (K2 O2 K3)  (오른쪽 먼저)
// 서로 다른 결괏값을 오름차순으로 한 줄에 하나씩 출력한다.
// 나눗셈은 정수 나눗셈(0 방향 절삭), 0으로 나누는 경우는 없다.
// 제약: 1 <= Ki <= 1,000
//
// 풀이 계획:
// 1. 입력을 파싱하여 숫자 3개와 연산자 2개를 분리한다.
// 2. calc 함수로 두 수와 연산자를 받아 사칙연산을 수행한다.
// 3. 두 가지 괄호 순서로 각각 결과를 계산한다.
// 4. 중복을 제거하고 오름차순 정렬하여 출력한다.
//
// 시간복잡도: O(1)
// - 항상 고정된 2가지 경우만 계산하므로 입력 크기에 무관하게 상수 시간이다.
fun main() {
    // readLine()으로 한 줄 입력받고, split(" ")으로 공백 기준 분리
    val tokens = readLine()!!.split(" ")

    // 홀수 인덱스(0,2,4)는 숫자, 짝수 인덱스(1,3)는 연산자
    val k1 = tokens[0].toInt()  // toInt(): String → Int 변환
    val o1 = tokens[1]
    val k2 = tokens[2].toInt()
    val o2 = tokens[3]
    val k3 = tokens[4].toInt()

    // 사칙연산 수행 함수
    // when: 코틀린의 패턴 매칭 표현식 (Java의 switch 대응)
    // else → throw: 예상치 못한 연산자가 들어오면 예외 발생
    fun calc(a: Int, op: String, b: Int): Int = when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b  // 코틀린 Int 나눗셈은 0 방향 절삭 (truncation toward zero)
        else -> throw IllegalArgumentException("Unknown operator: $op")
    }

    // 경우 1: (K1 O1 K2) O2 K3 — 왼쪽 연산 먼저
    val result1 = calc(calc(k1, o1, k2), o2, k3)

    // 경우 2: K1 O1 (K2 O2 K3) — 오른쪽 연산 먼저
    val result2 = calc(k1, o1, calc(k2, o2, k3))

    // 알고리즘: 완전탐색 (2가지 괄호 배치를 모두 시도)
    // listOf: 두 결과를 리스트로 묶고, sorted()로 오름차순 정렬
    // 결과가 같더라도 항상 두 줄 출력해야 하므로 Set이 아닌 List 사용
    val results = listOf(result1, result2).sorted()

    // joinToString("\n"): 컬렉션 원소를 줄바꿈으로 연결하여 문자열로 변환
    print(results.joinToString("\n"))
}
