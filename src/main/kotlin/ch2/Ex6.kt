package ch2

import ch2.Color.*
// 자바 : enum
// 코틀린 : enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// 프로퍼티나 메서드를 정의할 수 있다.
enum class Color1(val r : Int, val g : Int, val b : Int){ // 상수의 프로퍼티를 정의
    RED(255, 0, 0), // 각 상수를 생성할 때 그에 대한 프로퍼티 값을 지정
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // 메서드를 정의하는 경우 세미콜론 사용

    fun rgb() = (r*256 +g)*256 +b // 메서드 정의
}

// when
// 자바의 switch문에 대응한다.
// 자바의 switch문과 달리 각 분기 끝에 break를 넣지 않아도 된다.
fun getMnemonic(color: Color) =
    when(color){
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }

// 한 분기 안에 여러 값을 매치 패턴으로 사용할 수 있다.
fun getWarmth(color: Color) = when(color){
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "natural"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

// 인자로 받은 객체가 각 분기 조건에 있는 객체와 같은지 비교
// setOf : 읽기 전용 Set을 만든다.
fun mix(c1: Color, c2: Color) = when (setOf(c1,c2)){
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Dirty color")
}
// 분기 조건을 비교하기 위해 여러 Set 인스턴스를 생성
// 함수가 자주 호출된다면 불필요한 가비지 객체가 늘어나기 때문에 고쳐 사용하는것이 좋음
// 인자 없는 when 사용하면 불필요한 객체 생성을 막을 수 있다.
// 추가 객체를 만들지 않는 장점이 있지만 가독성이 떨어진다.
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW)||(c1 == YELLOW && c2 == RED) -> ORANGE
    (c1 == YELLOW && c2 == BLUE)||(c1 == BLUE && c2 == YELLOW) -> GREEN
    (c1 == BLUE && c2 == VIOLET)||(c1 == VIOLET && c2 == BLUE) -> INDIGO
    else -> throw Exception("Dirty color")
}

// 스마트 캐스트
// 타입 검사와 타입 캐스트를 조합하여 진행된다.
// 타입 검사 이후 별도의 타입 캐스팅이 필요없다.
interface Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

//fun eval(e: Expr) : Int {
//    if(e is Num){
//        val n = e as Num
//        return n.value;
//    }
//    if(e is Sum){
//        return eval(e.right) + eval(e.left)
//    }
//
//    throw IllegalArgumentException("Unknown expression")
//}

// is 키워드를 통해 타입 검사와 타입 캐스팅을 동시에 처리 하기 때문에 따로 타입 캐스팅을 할 필요가 없다.
// when을 이용해서 코드를 리팩토링 할 수 있음
fun eval(e: Expr) : Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.right)+eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>){
    println(eval(Sum(Sum(Num(1), Num(2)),Num(4))))
}