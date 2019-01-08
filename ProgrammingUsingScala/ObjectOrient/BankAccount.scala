// class Account(name:String, var balance:Double) {
// class Account(name:String, private var balance:Double) {
// class Account(name:String, balance:Double) {
class Account(name:String, bal:Double) {
    private var lBalance = (bal*100).toInt 
    // many other language dont have default public, they often have default
    // visibility less than public, why scala can make default as public.
    // because, if you realize late that you need to have some checks around it.
    // you can change the name of the var and write these 2 methods to basically
    // get the value and to set the value and all of sudden all of your outside
    // code works, because it doesn't know the difference --- the diff between
    // calling those methods and actually having a var .
    // but this way I could have additional code because I'm actuallly calling
    // the methods.

    // you can have somthing like a public var from outside world.
    // in fact, when you definde a 'public var', scala give you 2 mehtods
    // below automatically.

    // in C++, what identify the code and symbol is whether or not it's wrapped with ().
    // wrapped is code ,not wrapped is symbol
    // in scala code and symbol are with same formation without ()
    def balance = lBalance 
    
    // property assignment
    // add additional, logging personally
    def balance_=(newBal:Double) {
        println("enter wierd method")
        if(newBal>balance) deposit(newBal - balance)
        else withdraw(balance - newBal)
        // lBalance = newBal.toInt
    }

    def description:String = name+" $"+balance

    def deposit(amount:Double):Boolean = {
        if(amount>=0) {
            lBalance += (amount*100).toInt
            true
        } else false
    }

    def withdraw(amount:Double):Boolean = {
        if(amount>=0 && amount<=balance) {
            lBalance -= (amount*100).toInt
            true
        } else false
    }

    def isEmpty:Boolean = balance == 0.0
}

val account = new Account("mark", 1.00)
println(account.description)
account.withdraw(0.9)
println(account.description)
account.withdraw(0.1)
if(account.isEmpty) println("All money gone") else println("still got some")
println(account.description)
println(account.balance)
// account.balance = account.balance + 50
account.balance += 50
println(account.balance)
// you can have a huge amount of code outside of the class that
// depends upon 'balance' and utilizing it. 
// but ,now you want to modify balance name ,and make it private, and you
// don't want to break whole bunch of code.