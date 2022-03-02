package ch3

// 확장 함수는 어떤 클래스의 멤버 메서드인 것처럼 호출할 수 있지만
// 그 클래스의 밖에 선언된 함수이다.
// 일반 메서드에서와 같이 this를 생략할 수 있다.
// 확장 함수에서는 클래스 내부에서만 사용할 수 있는 private, protected 멤버를 사용할 수 없다.
// 확장 함수가 기존 클래스의 캡슐화는 깨지지 않는다.
// fun String.lastChar() : Char = this.get(this.length-1)
fun String.lastChar() : Char = get(length-1)

fun main() {
    // String : 수신 객체 타입 , "Kotlin" : 수신 객체
    println("Kotlin".lastChar()) // n
}