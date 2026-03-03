/*
 * 문제: 변수명 (백준 16205)
 *
 * 변수명을 정하는 세 가지 표기법이 있다.
 * 1. 카멜 표기법 (Camel Case): 각 단어의 첫 글자를 대문자로, 단 맨 첫 글자는 소문자.
 *    예: camelCase, variableN
 * 2. 스네이크 표기법 (Snake Case): 소문자만 사용하고, 단어 사이에 언더바(_)를 넣는다.
 *    예: snake_case, variable_n
 * 3. 파스칼 표기법 (Pascal Case): 카멜과 같지만 맨 첫 글자도 대문자.
 *    예: PascalCase, VariableN
 *
 * 한 표기법으로 작성된 변수명이 주어질 때, 세 가지 표기법 모두로 변환하여 출력한다.
 *
 * ── 풀이 계획 ──
 * 1. 입력으로 표기법 번호(1/2/3)와 변수명을 받는다.
 * 2. 어떤 표기법이든 먼저 단어 리스트로 분리한다.
 *    - 카멜/파스칼: 대문자가 나오는 지점에서 분리하고, 각 단어를 소문자로 변환.
 *    - 스네이크: 언더바(_) 기준으로 split.
 * 3. 단어 리스트로부터 세 표기법을 각각 조립한다.
 *    - 카멜: 첫 단어는 소문자, 나머지 단어는 첫 글자 대문자.
 *    - 스네이크: 모든 단어를 소문자로 언더바로 연결.
 *    - 파스칼: 모든 단어의 첫 글자를 대문자.
 *
 * ── 시간복잡도 ──
 * O(N) : 변수명 길이 N에 대해 한 번 순회하여 단어를 분리하고,
 *        단어 리스트를 순회하며 각 표기법으로 조립하므로 선형 시간.
 *        N ≤ 100이므로 매우 여유롭다.
 *
 * ── 사용 알고리즘 ──
 * 문자열 파싱: 대문자 위치를 기준으로 단어를 분리하는 간단한 문자열 처리.
 */

fun main() {
    // readLine()!! : 표준 입력에서 한 줄을 읽음. null이 아님을 보장(!!)
    val input = readLine()!!.trim()

    // split(" ", limit = 2) : 공백 기준으로 최대 2개로 분리
    // (표기법 번호와 변수명)
    val parts = input.split(" ", limit = 2)

    // toInt() : 문자열을 Int로 변환
    val type = parts[0].toInt()
    val name = parts[1]

    // 단어 리스트 추출: 어떤 표기법이든 소문자 단어 리스트로 변환
    // MutableList<String> : 가변 리스트 선언
    val words: List<String> = when (type) {
        // 카멜 표기법 또는 파스칼 표기법: 대문자 앞에서 단어를 분리
        1, 3 -> {
            // buildList : 리스트를 빌더 패턴으로 생성하는 코틀린 표준 함수
            buildList {
                // StringBuilder : 문자열을 효율적으로 연결하기 위한 클래스
                val sb = StringBuilder()
                for (ch in name) {
                    // isUpperCase() : 해당 문자가 대문자인지 확인
                    if (ch.isUpperCase() && sb.isNotEmpty()) {
                        // toString() : StringBuilder 내용을 String으로 변환
                        add(sb.toString())
                        // clear() : StringBuilder 내용 초기화
                        sb.clear()
                    }
                    // lowercase() : 문자를 소문자로 변환
                    sb.append(ch.lowercase())
                }
                // 마지막 남은 단어 추가
                if (sb.isNotEmpty()) add(sb.toString())
            }
        }
        // 스네이크 표기법: 언더바(_) 기준으로 분리
        // split("_") : 문자열을 "_" 기준으로 분리하여 리스트 반환
        2 -> name.split("_")
        else -> emptyList()
    }

    // 카멜 표기법 조립
    // mapIndexed : 인덱스와 함께 각 요소를 변환
    // replaceFirstChar { it.uppercaseChar() } : 첫 글자만 대문자로 변환
    // joinToString("") : 리스트 요소를 구분자 없이 하나의 문자열로 합침
    val camel = words.mapIndexed { index, word ->
        if (index == 0) word  // 첫 단어는 소문자 그대로
        else word.replaceFirstChar { it.uppercaseChar() }
    }.joinToString("")

    // 스네이크 표기법 조립
    // joinToString("_") : 리스트 요소를 "_"로 연결
    val snake = words.joinToString("_")

    // 파스칼 표기법 조립
    // map : 각 요소를 변환하는 고차 함수
    val pascal = words.map { word ->
        word.replaceFirstChar { it.uppercaseChar() }
    }.joinToString("")

    // println : 표준 출력에 한 줄 출력
    println(camel)
    println(snake)
    println(pascal)
}
