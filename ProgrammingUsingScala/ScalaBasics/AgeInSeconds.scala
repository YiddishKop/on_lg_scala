println("input a number:")
val totalSeconds = readInt()
val someth = readLine()
println(s"totalSeconds is : ${totalSeconds}")
println(s"totalSeconds is : ${someth}")
val secondInDay = 24*60*60
val secondsInYear = 365*secondInDay
val secondsInMonth = 30*secondInDay
val years = totalSeconds / secondsInYear
val secondsLeftInYear = totalSeconds % secondInDay
