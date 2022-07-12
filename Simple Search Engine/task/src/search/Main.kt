package search

fun main() {
    val listNames = mutableListOf<String>()

    while (true) {
        println("Enter the number of people:")
        val numberOfPeoples = readln().toInt()

        println("Enter all people:")
        repeat(numberOfPeoples) {
            listNames.add(readln())
        }

        println("Enter the number of search queries:")
        val numberOfSearchs = readln().toInt()


        repeat(numberOfSearchs) {
            println("Enter data to search people:")
            val search = readln().lowercase()
            searchNames(listNames, search)
        }
        break
    }

}

private fun searchNames(listNames: List<String>, search: String) {
    var count = 0
    for (i in listNames.indices) {
        if ("[a-zA-Z]*\\s*$search\\w*\\s*[a-zA-Z]*".toRegex().find(listNames[i].lowercase())?.value != null) {
            if (count == 0) {
                println("People found:")
                println(listNames[i])
                count++
            } else println(listNames[i])
        }
    }

    if (count == 0) println("No matching people found.")
}
