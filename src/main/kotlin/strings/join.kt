@file:JvmName("StringFunctions") // 클래스 이름을 지정하는 어노테이션
package strings //@file:JvmName 뒤에 패키지 문이 와야한다.

fun<T> joinToString(
    collection: Collection<T>,
    separator: String = "",
    prefix: String = "",
    postfix: String = ""
) : String{
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}