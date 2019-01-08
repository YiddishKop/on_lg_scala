// calculator
var currentValue = 0.0
var option = ""

do{
    println("""Select one of the following options: +,-,*,/,clear,quit""")
    println("Current value = " + currentValue)
    option = readLine.trim
    // sometimes, user input will add some space, but they don't know
    option match{
        case "+" => 
            println("Enter a value to add.")
            currentValue += readDouble
        case "-" => 
            println("Enter a value to subtract.")
            currentValue -= readDouble
        case "*" => 
            println("Enter a value to multiply.")
            currentValue *= readDouble
        case "/" => 
            println("Enter a value to divide.")
            currentValue /= readDouble
        case "clear" => 
            currentValue = 0
        case "quit" => 
        case _ =>
            println("That is not a valid option, try again")
    }
} while(option!="quit")