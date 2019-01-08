def countDown(n:Int) {
    if(n>0){
        println(n)
        countDown(n-1)
    }
}

countDown(9)

def countUp(n:Int) {
    if(n>0){
        countUp(n-1)
        println(n)
    }
}

countUp(9)

def fibo(n:Int):Int = {
    if(n>0){
        if(n>2) fibo(n-1) + fibo(n-2)
        else 1
    } else 0
}

for(i <- 1 to 20) println(fibo(i))