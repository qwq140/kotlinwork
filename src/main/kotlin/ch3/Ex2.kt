package ch3

// 디폴트 값 지정
// 코틀린에서는 함수 선언 시점에 특정 인자에 대한 디폴트 값을 지정할 수 있다.
// 디폴트 값을 가지는 인자 때문에 함수를 오버로딩하는 경우를 방지 할 수 있다.
//fun<T> joinToString(
//    collection: Collection<T>,
//    separator: String = "",
//    prefix: String = "",
//    postfix: String = ""
//) : String{
//    val result = StringBuilder(prefix)
//    for((index, element) in collection.withIndex()){
//        if(index > 0) result.append(separator)
//        result.append(element)
//    }
//    result.append(postfix)
//    return result.toString()
//}

// joinToString()을 확장 함수로 정의
fun<T> Collection<T>.joinToString(
    separator: String = "",
    prefix: String = "",
    postfix: String = ""
) : String{
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(){
    val list = listOf(1,2,3,4)
//    println(joinToString(list,":", "(", ")"))
//    // (1:2:3:4)
//
//    // 이름 붙인 인자
//    // 함수를 호출 할 때 어떤 것이 separator이고, 무엇이 prefix인지, 무엇이 postfix인지 혼동올 수 있다.
//    // 이를 해결하기 위해 함수 호출시에 인자의 이름을 명시하는 것이다.
//    // (1:2:3:4)
//    println(joinToString(collection = list, separator = ":", prefix = "(", postfix = ")"))
//    // 1:2:3:4
//    println(joinToString(collection = list, separator = ":"))
//    // 1234
//    println(joinToString(collection = list))

    // (1:2:3:4)
    println(list.joinToString(separator = ":", prefix = "(", postfix = ")"))
    // 1:2:3:4
    println(list.joinToString(separator = ":"))
    // 1 2 3 4
    println(list.joinToString(" "))
}