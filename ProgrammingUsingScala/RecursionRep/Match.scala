def matchSomething(arg:Any):Any = {
    arg match{
        case 42 => 
            println("the ulimate answer.")
        case "mark" => 
            println("my name.")
        
        // this is a tuple pattern below, it will match any 2-tuple here.
        case (a,b) => 
            println("it was a tuple with " +a+" and " +b)
        
        // this is a variable pattern below, it will match any Double type value here, and give it a name 'x'. 
        case x:Double => 
            val x1 = x + 1
            println("The number "+x1)
            if (x1 > 3) 3 else 1.9999999
        
        // this is a variable pattern below, it will match any Int type value here, and give it a name 'i' 
        case i:Int =>
            val i1 = i*30000000
            println("An Integer "+i1)

        case _ =>
            println("I have no idea what that was.")
    }
}