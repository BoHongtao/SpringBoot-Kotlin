package practice_02

/*
总结一些常用的写法
 */


//默认值
fun foo(a:Int = 1) {
    println("param is ${a}")
}


//过滤list
fun filter() {
    var num = listOf<String>("1","2","3")
    print("过滤大于1的：")
    num = num.filter { x->x > "1" }
    for (item in num) {
        print(item+",")
    }
    print("\n更短的写法：")
    num = num.filter { it > "1" }
    for (item in num) {
        print(item+",")
    }
}

//检测元素是否在集合中
fun is_exist() {
    var num = listOf<String>("1","2","3")
    if("1" in num) {
        println("in")
    }else{
        println("not in")
    }
}

//类型判断when用法
fun type(x:Any):String =
    when (x){
        is Int -> "int"
        is Long -> "Long"
        is String -> "String"
        else -> "unknown"
    }

//try catch
fun try_catch():Int ? {
    val a:String = "23s"
    try {
        val b:Int = a.toInt()
//        println(b)
        return b
    }catch (e:Exception){
        println("发生异常")
        return null
    }finally {
        println("这里会走到")
    }
}

fun main(args: Array<String>) {
    foo(2)
    foo()
    filter()
    println("\n检测类型为："+type(12212))
    println("检测类型为："+type(777777777777777777))
    println("检测类型为："+type("hello"))
    println("检测类型为："+type(2.3))
    val b1 = try_catch()
    print(b1)

    //交换两个变量
    var a = 1
    var b = 2
    a = b.also { b = a }
}