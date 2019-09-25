package practice_03

// 泛型
// 类型的参数化，就是可以把类型像方法的参数那样传递。这一点意义非凡。
// 泛型使编译器可以在编译期间对类型进行检查以提高类型安全，减少运行时由于对象类型不匹配引发的异常。
// 泛型方法，算法的复用
// 程序里会有很多各种类型的对象，对象多了肯定需要有某种类型的容器来装。所以就有了一些容器类型，比如数组、ArrayList、HashMap、TreeSet等
// 对于集合类型容器如ArrayList、HashMap、TreeSet等，它们不但是容器，还提供了一些方法对容器内对象的操作方法，如get，set，sort。这个时候就需要知道容器内放的是什么类型的对象，才能return或set

class Box<T> (t:T) {
    val value = t
}
val box:Box<Int> = Box<Int>(1)
// 或者可以简写，因为类型可以被推断出来
// val box = Box(1)

