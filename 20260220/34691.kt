// BOJ 34691 - 대전과학고등학교를 사랑하십니까?
// 학교 상징(동물/나무/꽃)에 대한 질문이 주어지면 해당 학명을 출력하는 문제
//
// 풀이: Map을 이용한 단순 매핑
// - animal → Panthera tigris (호랑이)
// - tree → Pinus densiflora (소나무)
// - flower → Forsythia koreana (개나리)
// - "end" 입력 시 종료
fun main() {
    // 질문 키워드 → 학명 매핑 테이블
    val map = mapOf(
        "animal" to "Panthera tigris",   // 호랑이
        "tree" to "Pinus densiflora",    // 소나무
        "flower" to "Forsythia koreana"  // 개나리
    )

    // 출력을 모아서 한 번에 처리 (I/O 최적화)
    val sb = StringBuilder()

    while (true) {
        val line = readLine() ?: break   // EOF 처리
        if (line == "end") break         // "end" 입력 시 종료
        sb.appendLine(map[line])         // 매핑된 학명을 버퍼에 추가
    }

    // 마지막 줄바꿈 제거 후 출력
    print(sb.toString().trimEnd())
}
