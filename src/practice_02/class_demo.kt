package practice_02

// 使用构造函数初始化类属性
// 在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。
// 如果没有显式指定修饰符的话，默认可见性是 public
// 如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；
// 如果你声明为 private，它只会在声明它的文件内可见；
// 如果你声明为 internal，它会在相同模块内随处可见；
// protected 不适用于顶层声明。

// 模块定义
// 一个模块是编译在一起的一套 Kotlin 文件：
// 一个 IntelliJ IDEA 模块；
// 一个 Maven 项目；
// 一个 Gradle 源集（例外是 test 源集可以访问 main 的 internal 声明）；
// 一次 <kotlinc> Ant 任务执行所编译的一套文件。

class Person constructor(name:String,age:Int){
    var name:String
    private var age:Int
    init {
        this.name = name
        this.age = age
    }
}

//抽象类
open class Human() {
    open fun eat(){

    }
}
abstract class man : Human() {
    override fun eat() {
        super.eat()
    }
}


//接口
interface Fruit {
    var taste:String
    fun canEat()
}

//实现接口
class Apple constructor(taste:String) : Fruit {
    override var taste:String = taste
    override fun canEat() {
        println("i am apple ,i can eat")
    }
}

fun main(args: Array<String>) {
    val person = Person("clever_coder",24)
    println(person.name)
//    println(person.age)  //无法调用

    val apple = Apple("吃起来很甜")
    apple.canEat()
    println(apple.taste)

}