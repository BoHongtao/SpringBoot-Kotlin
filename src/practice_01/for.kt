package practice_01
//for and while  循环

fun main(args: Array<String>) {
    val fruit = listOf<String>("apple","orange","pear")


    //for
    for (tmp in fruit){
        println(tmp)
    }

    //while
    var index = 0;
    while (index < fruit.size) {
        index++
        println(fruit[index])
    }
}