package ch2

import java.util.TreeMap

// in 연산자는 어떤 값이 범위에 속하는지 검사할 수 있다.
// !in을 사용하면 어떤 값이 범위에 속하지 않는지 검사할 수 있다.
fun isLetter(c: Char) = c in 'a'..'z'|| c in 'A'..'Z'

// when 식에서 사용해도 된다.
fun recognize(c: Char) = when(c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}

// 반복문
// while의 경우 자바와 동일
// for 루프
// 자바 : 초깃값, 증가값, 최종값을 사용
// 코틀린 : 범위(range)를 이용
fun main() {
    for (i in 1..10){
        println(i)
    }
    // 2씩 증가하는 for문 : 범위 뒤에 step을 통해서 표현
    // 1 3 5 7 9
    for(i in 1..10 step 2){
        println(i)
    }

    // 감소하는 for문 : downTo 사용
    // 시작값 downTo 종료값
    for(i in 10 downTo 1){
        println(i)
    }

    val binaryReps = TreeMap<Char, String>()

    // 자바에서 맵의 값을 가져올 때 get, put을 사용
    // 코틀린에서는 map[key], map[key] = value를 사용용
   for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    // 컬렉션의 원소를 푸는 방법
    // letter : key , binary : value
    for ((letter, binary) in binaryReps){
        println("$letter = $binary")
    }

    // 맵이 아닌 컬렉션에서도 사용가능
    val list = arrayListOf("10", "11", "1011")
    for ((index, element) in list.withIndex()){
        println("$index : $element");
    }

    println(isLetter('k')) // true
    println(isLetter('0')) // false

    println(recognize('0'))

    // 범위는 문자에만 국한되지 않음
    // 비교가 가능한 클래스라면 그 클래스의 인스턴스 객체를 사용해 범위를 만들 수 있다.
    // Comparable을 사용하는 범위의 경우 그 범위 내의 모든 객체를 항상 이터레이션하지 못한다.
    // 하지만 값이 범위 안에 속하는지는 결정할 수 있다.
    println("Kotlin" in "Java".."Scala") //true

    // 컬렉션도 in 연산자를 사용할 수 있다.
    // 컬렉션에 들어가있는지 확인한다.
    println("Kotlin" in setOf("Java", "Scala")) // false
}