package ch3

// 가변 인자 함수
// 가변 인자를 사용하면 함수를 호출할 때 인자 개수를 유동적으로 지정할 수 있다.
// 인자 앞에 vararg를 붙이면 된다.
fun test(vararg  values: String){
    for(s in values) println(s)
}

// vararg 파라미터가 제네릭 타입일 경우 *을 생략해도 Array<out T> 타입은 인자로 받아들일 수 있다.
fun <T> asList(vararg values: T) : List<T>{
    val result = ArrayList<T>()
    for (value in values)
        result.add(value)
    return result
}

infix fun Any.to(other: Any) = Pair(this, other)

fun main(){
    test("1", "2", "3")
    // 1
    // 2
    // 3

    // 이미 존재하는 배열을 함수의 vararg 인자로 넘겨야할 때
    // 배열 앞에 *연산자를 붙여주면 된다.
    // *연산자 : 스프레드 연산자자
   val list = arrayOf("A", "B", "C")
    test(*list)
    // A
    // B
    // C

    val list1 = asList(-1, 0, list, 4) // OK

    // 중위 호출
    // to 는 코틀린의 키워드가 아니다.
    // 수신 객체와 유일한 메서드 인자 사이에 메서드 이름을 넣으면 된다.
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(1.to("one")) // 일반적인 방식의 메서드 호출
    println(1 to "one") // 중위 호출 방식으로 메서드 호출

    // 구조 분해 선언
    val (number, name) = 1 to "one"
    println(number)
    println(name)
}