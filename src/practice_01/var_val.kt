package practice_01
//val局部只读变量，只能赋值一次
//var 可以重复赋值
fun main(args: Array<String>) {
    var a = 1;
    a = 2;
    println("a is $a")
    val b = 1;
    println("b is $b")
}