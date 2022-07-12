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
            "1" -> findAPerson(listNames)
            "2" -> printAllPeople(listNames)
            else -> println("Incorrect option! Try again.")
        }
    }

}

fun findAPerson(listNames: MutableList<String>) {
    println("Enter a name or email to search all suitable people.")
    val nameOrEmail = readln()
    searchNames(listNames, nameOrEmail)
}

fun printAllPeople(listNames: MutableList<String>) {
    println("=== List of people ===")
    for (i in listNames) {
        println(i)
    }
    println("")
}

private fun searchNames(listNames: List<String>, search: String) {
    for (i in listNames.indices) {
        if ("[a-zA-Z]*\\s*$search\\w*\\s*[a-zA-Z]*".toRegex().find(listNames[i].lowercase())?.value != null) {
            println(listNames[i])
        }
    }
    println("")
}
