package ch2

//변수
fun main() {
    // 타입을 생략
    val question = "지금은 몇 시 인가?"
    // 타입을 명시
    val answer : String = "20시 52분"
    // 초기화 식을 사용하지 않고 변수를 선언하려면 변수 타입을 반드시 명시
    val a : Int
    // 변수 선언 시 사용하는 키워드
    // val : 변경 불가능한 참조를 저장하는 변수
    // var : 변경 가능한 참조를 저장하는 변수, 변수의 타입은 고정
    // val 참조 자체는 불변일지라도 그 참조가 가리키는 객체 내부 값은 변경될 수 있다.
    val languages = arrayListOf("java")
    languages.add("kotlin")

    var name = "홍길동"
    // 컴파일 오류
    // name = 14
}