package ch2

// 클래스 선언
class Person(
    val name: String, // 읽기 전용 프로퍼티 - 비공개 필드와 getter를 만듬
    var isMarried : Boolean // 쓸 수 있는 프로퍼티 - 비공개 필드, getter, setter를 만듬
    )

// 커스텀 접근자(프로퍼티의 접근자를 직접 작성)
class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean // 정사각형 여부
        get(){
            return height == width // 프로퍼티 게터 선언
        }
}

fun main() {
    // new 키워드 없이 생성자 호출
    val person = Person("Bob", true)
    println(person.name) // 프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 getter를 호출해준다.
    person.isMarried = false

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}