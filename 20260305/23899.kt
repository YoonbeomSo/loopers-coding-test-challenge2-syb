/*
 * 문제: 알고리즘 수업 - 선택 정렬 5 (백준 23899)
 *
 * N개의 서로 다른 양의 정수가 저장된 배열 A를 선택 정렬(오름차순)하는 과정에서
 * 배열 A가 배열 B와 같아지는 순간이 있는지 확인하는 문제.
 * 초기 상태도 포함하며, 교환이 발생할 때마다(그리고 교환이 발생하지 않더라도 각 반복 후)
 * 배열 B와 비교한다.
 *
 * 선택 정렬 의사 코드:
 *   for last <- N downto 2:
 *       A[1..last] 중 가장 큰 수 A[i]를 찾는다
 *       if (last != i) then A[last] <-> A[i]
 *
 * 계획:
 *   1. 배열 A와 B를 입력받는다.
 *   2. 초기 상태에서 A == B인지 확인한다.
 *   3. 의사 코드대로 선택 정렬을 수행하면서, 각 교환 후 A == B인지 확인한다.
 *      - 교환이 발생하지 않는 경우(last == i)에도 한 반복이 끝난 것이므로
 *        그 상태를 체크해야 한다. (초기 상태에서 이미 체크했으므로 변화가 없으면 중복 체크)
 *      - 문제의 핵심: "정렬 과정에서 배열 A가 배열 B와 같은 경우가 발생하는지"
 *        초기 상태 + 매 교환 직후의 상태를 확인하면 된다.
 *   4. 일치하면 1, 끝까지 일치하지 않으면 0을 출력한다.
 *
 * 시간복잡도: O(N^2)
 *   - 선택 정렬 자체가 O(N^2)이다 (외부 루프 N번 × 내부 최대값 탐색 N번).
 *   - 매 교환 후 배열 비교가 O(N)이지만, 교환 횟수는 최대 N-1번이므로
 *     비교 총 비용은 O(N^2). 전체적으로 O(N^2).
 *   - N ≤ 10,000이므로 최대 약 1억 연산 → 1초 내 충분히 가능.
 */

fun main() {
    // readLine()!!: 표준 입력에서 한 줄을 읽음. !!는 null이 아님을 단언 (String? -> String)
    val n = readLine()!!.trim().toInt()

    // split(" "): 공백 기준으로 문자열 분리 -> List<String>
    // map { it.toInt() }: 각 문자열을 Int로 변환 -> List<Int>
    // toIntArray(): List<Int>를 IntArray로 변환
    val a = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
    val b = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()

    // contentEquals: 두 배열의 내용(원소 값)이 같은지 비교 (== 는 참조 비교이므로 사용 불가)
    // 초기 상태 체크
    if (a.contentEquals(b)) {
        println(1)
        return
    }

    /*
     * [알고리즘: 선택 정렬 (Selection Sort)]
     * - 배열의 뒤쪽부터 정렬해 나가는 방식.
     * - 매 반복마다 A[0..last] 구간에서 최댓값을 찾아 A[last]와 교환한다.
     * - last를 n-1부터 1까지 줄여가며 반복하면 오름차순 정렬 완성.
     *
     * 의사 코드는 1-indexed이지만, 코틀린 배열은 0-indexed이므로
     * last를 n-1부터 1까지 순회한다.
     */
    // downTo: 감소하는 범위를 생성하는 중위 함수 (n-1, n-2, ..., 1)
    for (last in n - 1 downTo 1) {
        // A[0..last] 구간에서 최댓값의 인덱스를 찾는다
        var maxIdx = 0
        for (j in 1..last) {
            // 최댓값 갱신: 같은 값은 없으므로 > 비교만으로 충분
            if (a[j] > a[maxIdx]) {
                maxIdx = j
            }
        }

        // last와 maxIdx가 다를 때만 교환 수행
        if (last != maxIdx) {
            // also: 객체를 반환하면서 부수 효과를 수행하는 스코프 함수
            // 여기서는 swap을 간결하게 구현
            val temp = a[last]
            a[last] = a[maxIdx]
            a[maxIdx] = temp

            // 교환 직후 배열 A와 B가 같은지 확인
            if (a.contentEquals(b)) {
                println(1)
                return
            }
        }
    }

    // 정렬 과정 전체에서 한 번도 일치하지 않았으면 0 출력
    println(0)
}
