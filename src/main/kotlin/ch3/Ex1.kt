package ch3

fun main(){
    // class java.util.HashSet
    val set = hashSetOf(1, 7, 53)
    println(set.javaClass)

    // class java.util.ArrayList
    val list = arrayListOf(1, 7, 53)
    println(list.javaClass)

    // class java.util.HashMap
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map.javaClass)
}