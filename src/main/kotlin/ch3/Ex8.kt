package ch3

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User){
    if(user.name.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if(user.address.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    } // user를 데이터베이스에 저장한다.
}

fun saveUser1(user: User){
    fun validate(user: User, value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // user를 데이터베이스에 저장한다.
}

fun saveUser2(user: User){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    // user를 데이터베이스에 저장한다.
}

// 확장 함수
fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${id}: empty ${fieldName}")
        } // 바깥 함수의 파라미터에 직접 접근할 수 있다.
    }
    validate(name, "Name")
    validate(address, "Address")
}
fun saveUser3(user: User){
    user.validateBeforeSave()
    // user를 데이터베이스에 저장한다.
}

fun main() {
    saveUser(User(1, "", ""))
    saveUser1(User(1, "", ""))
    saveUser2(User(1, "", ""))
    saveUser3(User(1, "", ""))
}

// Exception in thread "main" java.lang.IllegalArgumentException: Can't save user 1: empty Name