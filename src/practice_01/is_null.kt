package practice_01

//空值与null检测  ==null

//？表示除了返回指定类型之外还可以返回空


//字符串转换成int
fun parseInt(str:String):Int? {
    val num:Int;
    try {
        num = str.toInt()
        return num
    }catch (e:Exception){
        return null
    }
}

//获取对象的长度
fun getLen(obj:Any):Int ? {
    if(obj is String) {
        return obj.length
    }
    return null
}


fun main(args: Array<String>) {
    var a:String = "1";
    var b:String  = "2aaa";
    println("string b length is ${getLen(b)}")

    //转换成int
    val a2int = parseInt(a)
    val b2int = parseInt(b)
    if(a2int == null || b2int == null){
        println("TYPE ERROR")
    }else{
        print("sum is ${a2int + b2int}")
    }
}