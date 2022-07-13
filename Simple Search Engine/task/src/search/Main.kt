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
            "0" -> break
            "1" -> findAPerson(file)
            "2" -> printAllPeople(file)
            else -> println("Incorrect option! Try again.")
        }
    }

}

fun findAPerson(listNames: File) {
    println("Enter a name or email to search all suitable people.")
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
    if (listNames.exists()) { // checks if file exists
        val lines = listNames.readLines()
        for (i in lines) {
            if ("[a-zA-Z]*\\s*@?$search@?\\w*\\s*[a-zA-Z]*".toRegex().find(i.lowercase())?.value != null) {
                println(i)
            }
        }
    }

    println("")
}
