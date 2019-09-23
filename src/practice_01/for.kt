package practice_01
//for and while  循环

fun main(args: Array<String>) {
    val fruit = listOf<String>("apple","orange","pear")
    for (tmp in fruit){
        println(tmp)
    }
    var index = 0;
    while (index < fruit.size) {
        index++
        println(fruit[index])
    }
}