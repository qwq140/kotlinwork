package ch1

// 데이터 클래스
data class Person(
    val name : String,
    val age : Int? = null // 널이 될 수 있는 타입(Int?)과 파라미터 디폴트 값
)

fun main(){
    val persons = listOf(Person("영희"), Person("철수", age = 29))
    val oldest = persons.maxByOrNull{it.age ?: 0} // 람다 식과 엘비스 연산자
    println("나이가 가장 많은 사람 : $oldest") // 문자열 템플릿
}