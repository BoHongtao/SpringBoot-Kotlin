package practice_01
//条件表达式
fun max(a:Int,b:Int):Int {
    val max:Int;
    if(a>b){
        max = a;
    }else{
        max = b;
    }
    return max
}

//可以简写
fun min(a:Int,b:Int) = if(a>b) b else b


fun main(args: Array<String>) {
    val a = 1;
    val b = 2;
    println("max num is ${max(a,b)}")
    println("min num is ${min(a,b)}")
}