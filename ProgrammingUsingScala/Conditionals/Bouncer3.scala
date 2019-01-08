println("How old are you?")
val age = readInt

/*
Different from Bouncer1.scala
1. we should perfer val to var;
2. use <if else> as an statement. 
*/
val response = if(age<21) "Get lost." else "come on in."
println(response)

// we can merge the 2 expression to 1.
println(if (age < 21) "Get lost." else "come on in.")