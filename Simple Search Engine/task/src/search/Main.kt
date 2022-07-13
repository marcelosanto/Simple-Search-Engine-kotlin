package search

import java.io.File

fun main(args: Array<String>) {
    val listNames = mutableListOf<String>()

    val fileName = args[1]
    val file = File(fileName)

    while (true) {
//        if (listNames.isEmpty()) {
//            println("Enter the number of people:")
//            val numberOfPeoples = readln().toInt()
//
//            println("Enter all people:")
//            repeat(numberOfPeoples) {
//                listNames.add(readln())
//            }
//        }

        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")

        val menuOpt = readln()

        when (menuOpt) {
            "0" -> {
                println("Bye!")
                break
            }
            "1" -> findAPerson(file)
            "2" -> printAllPeople(file)
            else -> println("Incorrect option! Try again.")
        }
    }

}

fun findAPerson(listNames: File) {
    println("")
    println("Enter a name or email to search all matching people.")
    val nameOrEmail = readln().lowercase()
    searchNames(listNames, nameOrEmail)
}

fun printAllPeople(listNames: File) {
    println("=== List of people ===")
    val lines = listNames.readLines()
    for (line in lines) {
        println(line)
    }
    println("")
}

private fun searchNames(listNames: File, search: String) {
    val names = mutableListOf<String>()

    if (listNames.exists()) { // checks if file exists
        val lines = listNames.readLines()
        for (i in lines) {
            if ("\\s*$search\\s*".toRegex().find(i.lowercase())?.value != null && "[a-zA-Z]{3,}".toRegex()
                    .find(search)?.value != null
            ) {
                names.add(i)
            }
        }
    }

    if (names.isEmpty()) {
        println("No matching people found.")
    } else {
        if (names.size == 1) {
            println("1 person found:")
            println(names[0])
        } else {
            println("${names.size} persons found:")
            for (i in names) {
                println(i)
            }
        }
    }

    println("")
}
