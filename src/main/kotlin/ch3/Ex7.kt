package ch3

fun parsePath(path: String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePath1(path: String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun main() {
    // 정규식을 파라미터로 받는 함수는 String이 아닌 Regex 타입의 값을 받는다.
    println("12.345-6.A".split("\\.|-".toRegex())) // 정규식을 명시적으로 만든다.

    println("12.345-6.A".split(".", "-")) // 여러 구분 문자열을 지정한다.
    // [12, 345, 6, A]
    // 문자열 대신 문자를 인자로 넘겨도 마찬가지 결과를 볼 수 있다.

    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    // Dir: /Users/yole/kotlin-book, name: chapter, ext: adoc

    parsePath1("/Users/yole/kotlin-book/chapter.adoc")
    // Dir: /Users/yole/kotlin-book, name: chapter, ext: adoc
}