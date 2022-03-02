package ch3

val String.lastChar : Char
    get() = this.get(this.length-1)

fun main(){
    println("Kotlin".lastChar)
}