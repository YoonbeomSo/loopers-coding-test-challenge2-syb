fun main() {
    val input = readLine()!!.trim()
    val parts = input.split(" ", limit = 2)

    val N = parts[0].toInt()
    val str = parts[1]

    var word = mutableListOf<String>()
    if (N == 1) {
        word.add(str)
        word.add(buildToType2(str))
        word.add(buildToType3(str))
    } else if(N == 2) {
        word.add(buildToType1(str))
        word.add(str)
        word.add(buildToType3(str))
    } else {
        word.add(buildToType1(str))
        word.add(buildToType2(str))
        word.add(str)
    }

    for (w in word) {
        println(w)
    }
}

private fun buildToType1(str: String): String {
    val sb = StringBuilder()
    var isFirst = true
    var nextUpper = false
    for (s in str) {
        if (isFirst) {
            sb.append(s.lowercase())
            isFirst = false
            continue
        }

        if (s == '_') {
            nextUpper = true
            continue
        }

        if (nextUpper) {
            sb.append(s.uppercase())
            nextUpper = false
            continue
        }
        sb.append(s)
    }
    return sb.toString()
}

private fun buildToType2(str: String): String {
    val sb = StringBuilder()
    var isFirst = true

    for (s in str) {
        if(isFirst) {
            sb.append(s.lowercase())
            isFirst = false
            continue
        }

        if (s.isUpperCase()) {
            sb.append('_')
            sb.append(s.lowercase())
            continue
        }
        sb.append(s)
    }
    return sb.toString()
}

private fun buildToType3(str: String): String {
    val sb = StringBuilder()
    var isFirst = true
    var nextUpper = false
    for (s in str) {
        if (isFirst) {
            sb.append(s.uppercase())
            isFirst = false
            continue
        }

        if (s == '_') {
            nextUpper = true
            continue
        }

        if (nextUpper) {
            sb.append(s.uppercase())
            nextUpper = false
            continue
        }
        sb.append(s)
    }
    return sb.toString()
}