package practice_03

fun main(args: Array<String>) {
    //means  1<=i<=4
    for (i in 1..4) {
        println(i)
    }
    for (i in 1..4 step 2) {
        println(i)
    }
    for (i in 4 downTo 1) {
        println(i)
    }
}