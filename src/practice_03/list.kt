package practice_03

// List 是一个有序集合，可通过索引（反映元素位置的整数）访问元素。元素可以在 list 中出现多次。列表的一个示例是一句话：有一组字、这些字的顺序很重要并且字可以重复。
// Set 是唯一元素的集合。它反映了集合（set）的数学抽象：一组无重复的对象。一般来说 set 中元素的顺序并不重要。例如，字母表是字母的集合（set）。
// Map（或者字典）是一组键值对。键是唯一的，每个键都刚好映射到一个值。值可以重复。map 对于存储对象之间的逻辑连接非常有用，例如，员工的 ID 与员工的位置。

class Person constructor(name:String,age:Int){
    var name:String
    var age:Int
    init {
        this.name = name
        this.age = age
    }
}

fun main(args: Array<String>) {

    /*
      list
     */
    val bob = Person("Bob", 31)
    //索引从0开始的list 0~people.zice-1   这个和python中的list很像，无预定长度
    val people = listOf<Person>(Person("Adam", 20), bob, bob)
    println(people)

    //MutableList 是可以进行写操作的 List，例如用于在特定位置添加或删除元素。
    val people_mutable = mutableListOf(1,2,3)
    //增加
    people_mutable.add(4)
    println(people_mutable)
    //删除某个下标的值
    people_mutable.removeAt(0)
    println(people_mutable)
    //打乱
    people_mutable.shuffle()
    println(people_mutable)


    /*
     set
     */
    var nums = setOf<Int>(1,2,3,3)

    println(nums)

    if(nums.contains(1)) println("包含")


    /*
    Map 键值对
     */
    val numsMap = mapOf("key1" to  1,"key2" to 2)
    println(numsMap)

    //可变
    val mutalbe_num_map = mutableMapOf("one" to 1,"two" to 2)
    //增加
    mutalbe_num_map.put("three",3)
    mutalbe_num_map["four"]=4
    println(mutalbe_num_map)




}