package practice_01

fun main(args: Array<String>) {
    val fruit = listOf<String>("apple","orange","pear")
    if("apple" in fruit){
        print("in")
    }else{
        print("not in")
    }
}