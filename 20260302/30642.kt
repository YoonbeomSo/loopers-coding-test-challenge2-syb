/**
 * 문제: 백준 30642 - 아이그루스와 화장실
 *
 * 문제 내용:
 * N층짜리 건물에 마스코트가 살고 있다.
 * - annyong(용, 큰 동물)은 홀수 층 화장실을 사용한다.
 * - induck(오리, 작은 동물)은 짝수 층 화장실을 사용한다.
 * 마스코트가 현재 K층에 있을 때, 가장 가까운 적합한 화장실 층을 출력한다.
 * 거리가 같은 층이 여러 개면 아무거나 출력해도 된다. (스페셜 저지)
 *
 * 풀이 계획:
 * 1. N, 마스코트 이름, K를 입력받는다.
 * 2. 마스코트에 따라 적합한 층의 홀짝 조건을 결정한다.
 *    - annyong → 홀수 층 (층 % 2 == 1)
 *    - induck → 짝수 층 (층 % 2 == 0)
 * 3. K층에서 시작하여 위/아래로 1칸씩 확장하며 조건에 맞는 첫 번째 층을 찾는다.
 * 4. 1~N 범위 내에서만 탐색한다.
 *
 * 시간복잡도: O(N)
 * - 최악의 경우 K가 한쪽 끝에 있고, 적합한 층이 반대쪽 끝에만 있을 때
 *   모든 층을 탐색해야 한다.
 * - 하지만 실제로는 최대 2칸만 이동하면 되므로 사실상 O(1)이다.
 *   (홀짝이 번갈아가므로 현재 층이 안 맞아도 ±1 또는 ±2면 반드시 찾음)
 */
fun main() {
    // readLine()!!: 표준입력에서 한 줄을 읽어옴. !!는 null이 아님을 단언하는 연산자
    val n = readLine()!!.trim().toInt()          // 건물 층수
    val mascot = readLine()!!.trim()             // 마스코트 이름 (annyong 또는 induck)
    val k = readLine()!!.trim().toInt()          // 현재 위치한 층

    // 마스코트에 따라 적합한 층의 나머지 값을 결정
    // annyong(큰 동물) → 홀수 층 사용 (층 % 2 == 1)
    // induck(작은 동물) → 짝수 층 사용 (층 % 2 == 0)
    val targetRemainder = if (mascot == "annyong") 1 else 0

    /**
     * 알고리즘: 중심 확장 탐색 (Center Expansion Search)
     *
     * K층을 중심으로 거리(diff)를 0부터 1씩 늘려가며
     * K-diff와 K+diff 두 방향을 동시에 확인한다.
     * 조건에 맞는 층을 찾으면 즉시 출력하고 종료한다.
     *
     * 이 방식을 사용하면 가장 가까운 층을 자연스럽게 찾을 수 있다.
     * 거리가 같은 두 층이 모두 조건에 맞을 때는 아래층(k - diff)을 먼저 출력하지만,
     * 스페셜 저지이므로 어느 쪽이든 정답이다.
     */
    // 0..n 은 0부터 n까지의 IntRange를 생성하는 범위 연산자
    for (diff in 0..n) {
        val lower = k - diff   // 아래쪽 후보 층
        val upper = k + diff   // 위쪽 후보 층

        // in 1..n: 1 이상 n 이하 범위에 포함되는지 확인하는 범위 검사
        // lower % 2: 나머지 연산으로 홀짝 판별
        if (lower in 1..n && lower % 2 == targetRemainder) {
            println(lower)
            return  // main 함수를 종료하여 프로그램을 끝냄
        }
        if (upper in 1..n && upper % 2 == targetRemainder) {
            println(upper)
            return
        }
    }
}
