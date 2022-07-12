package search

fun main() {
    val listNames = mutableListOf<String>()

    while (true) {
        if (listNames.isEmpty()) {
            println("Enter the number of people:")
            val numberOfPeoples = readln().toInt()

            println("Enter all people:")
            repeat(numberOfPeoples) {
                listNames.add(readln())
            }
        }

        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")

        val menuOpt = readln()

        when (menuOpt) {
            "0" -> break
            "1" -> println("find person.")//findAPerson()
            "2" -> printAllPeople(listNames)
            else -> println("Incorrect option! Try again.")
        }


//        repeat(numberOfSearchs) {
//            println("Enter data to search people:")
//            val search = readln().lowercase()
//            searchNames(listNames, search)
//        }
//        break
    }

}

fun printAllPeople(listNames: MutableList<String>) {
    println("=== List of people ===")
    for (i in listNames) {
        println(i)
    }
    println("")
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
