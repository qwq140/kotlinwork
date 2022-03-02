package ch2

// 문자열 템플릿
// 문자열 리터럴 안에서 변수를 사용할 때 변수 앞에 $를 추가하면 된다.
// 복잡한 식의 경우도 중괄호를 둘러싸서 문자열 템플릿 안에 넣을 수 있다.
fun main(args : Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "kotlin"
    println("Hello, $name!")

    println("Hello, ${if (args.isNotEmpty()) args[0] else "kotlin"}!")
}