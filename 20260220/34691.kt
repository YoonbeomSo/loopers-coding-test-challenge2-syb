fun main() {
    val map = mapOf(
        "animal" to "Panthera tigris",
        "tree" to "Pinus densiflora",
        "flower" to "Forsythia koreana"
    )
    val sb = StringBuilder()
    while (true) {
        val line = readLine() ?: break
        if (line == "end") break
        sb.appendLine(map[line])
    }
    print(sb.toString().trimEnd())
}
