// write your code here 

fun main(args: Array<String>) {
    val x = listOf(8 ,6 ,7 ,9 ,2 ,0, 5 ,7 ,3, 0)
    val y = listOf(6, 2, 3, 7, 8, 7, 8 ,2, 5, 3)

    var count = 0

    for (i in x.indices) {
        for (j in y.indices) {
            if (x[i] == y[j]) {
                count++
                break
            }
            count++
        }
    }

    println(count)
}
