/*
   函数参数及返回值形式
 */
package practice_01

fun sum(a:Int,b:Int) :Int {
    return a + b;
}
// 表达式作为函数体
fun sum_01(a:Int,b:Int) = a + b;

//无意义返回值直接省略或者返回类型为Unit

fun sum_02(a:Int,b:Int) {
    println("sum_02 is ${a+b}")
}


//可变变量
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}

fun main(args: Array<String>) {
    val sum = sum(1,2)
    println("sum is $sum");
    val sum_01 = sum_01(1,2)
    println("sum_01 is $sum_01")
    sum_02(1,2)

    val list = asList(1,2,3)
    println(list)
}