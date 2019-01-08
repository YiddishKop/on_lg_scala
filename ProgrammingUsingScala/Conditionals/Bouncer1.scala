println("How old are you?")
val age = readInt
var response = ""
if(age<21) {
    response = "Get lost."
    println("old enough.")
} else {
    response = "come on in."
}
println(response)