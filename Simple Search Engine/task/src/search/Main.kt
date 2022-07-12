package search

fun main() {
    val text = readln().split(" ").toMutableList()
    val find = readln()

    val search = text.indexOf(find)

    if (search >= 0) println(search+1) else println("Not found")
}
