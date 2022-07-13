package search

import java.io.File

fun main(args: Array<String>) {
    val listNames = mutableListOf<String>()

    val fileName = args[1]
    val file = File(fileName)

    while (true) {
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

    println("Select a matching strategy: ALL, ANY, NONE")
    val strategy = readln()

    println("")
    println("Enter a name or email to search all matching people.")
    val nameOrEmail = readln().lowercase()
    searchNames(listNames, nameOrEmail, strategy)
}

fun printAllPeople(listNames: File) {
    println("=== List of people ===")
    val lines = listNames.readLines()
    for (line in lines) {
        println(line)
    }
    println("")
}

private fun searchNames(listNames: File, _search: String, _strategy: String) {
    val lista = mutableListOf<String>()
    val listFilter = mutableListOf<String>()

    if (listNames.exists()) {
        val lines = listNames.readLines()
        for (i in lines) {
            lista.add(i)
        }
    }

    val achados = mutableSetOf<String>()
    val search = _search.lowercase().split(" ").toMutableList()
    val strategy = _strategy.lowercase()
    if (search.size <= 3) {
        // All strategy
        if (strategy == "all") {
            for (x in search) {
                for (i in lista) {
                    if (x.toRegex().find(i.lowercase())?.value != null) {
                        achados.add(i)
                    }
                }
            }

            for (x in search) {
                for (i in achados) {
                    if (x.toRegex().find(i.lowercase())?.value == null) {
                        achados.remove(i)
                    }
                }
            }


            listFilter.addAll(achados)

        } else if (strategy == "any") {
            for (x in search) {
                for (i in lista) {
                    if (x.toRegex().find(i.lowercase())?.value != null) {
                        achados.add(i)
                    }
                }
            }

            listFilter.addAll(achados)
        } else if (strategy == "none") {
            val teste = mutableSetOf<String>()
            for (x in search) {
                for (i in lista) {
                    if (x.toRegex().find(i.lowercase())?.value == null) {
                        teste.add(i)
                    } else achados.add(i)
                }
            }

            teste.removeAll(achados)

            listFilter.addAll(teste)
        }

    }
    if (listFilter.isEmpty()) {
        println("No matching people found.")
    } else {
        if (listFilter.size == 1) {
            println("1 person found:")
            println(listFilter[0])
        } else {
            println("${listFilter.size} persons found:")
            for (i in listFilter) {
                println(i)
            }
        }
    }

    println("")
}
