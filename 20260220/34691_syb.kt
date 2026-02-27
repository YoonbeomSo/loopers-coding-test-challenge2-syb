// BOJ 34691 - 대전과학고등학교를 사랑하십니까?
// 학교 상징(동물/나무/꽃)에 대한 질문이 주어지면 해당 학명을 출력하는 문제
//
// 풀이: Map을 이용한 단순 매핑
// - animal → Panthera tigris (호랑이)
// - tree → Pinus densiflora (소나무)
// - flower → Forsythia koreana (개나리)
// - "end" 입력 시 종료
fun main() {
    val map = mapOf(
        "animal" to "Panthera tigris",
        "tree" to "Pinus densiflora",
        "flower" to "Forsyhtia koreana"
    )

    val sb = StringBuilder();
    while(true) {
        val line = readLine() ?: break
        if(line == "end") break
        sb.appendLine(map[line])
    }
    print(sb.toString().trimEnd())
}