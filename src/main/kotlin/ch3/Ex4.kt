package ch3

// 확장 함수의 오버라이드
// 코틀린에서 확장 함수는 오버라이드할 수 없다.
open class View {
    open fun click() = println("View clicked")
}

class Button: View(){
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("View showOff")
fun Button.showOff() = println("Button showOff")

fun main(){
    val view: View = Button()
    view.click() // Button clicked
    view.showOff() // View showOff
}