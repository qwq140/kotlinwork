package test

import ch2.Color // 다른 패키지에서 정의한 Color 클래스를 임포트
import ch2.Color.* // 짧은 이름으로 사용하기 위해 enum 상수를 모두 임포트

fun getWarmth(color: Color) = when(color){
    RED, ORANGE, YELLOW -> "warm" // 임포트한 enum 상수를 이름만으로 사용
    GREEN -> "natural"
    BLUE, INDIGO, VIOLET -> "cold"
}