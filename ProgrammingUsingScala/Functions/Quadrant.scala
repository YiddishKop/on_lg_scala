def quadrant(x:Double, y:Double):Int = {
    if(x>0){
        if(y>0) 1 else 3
    } else{
        if(y>0) 2 else 4
    }
}

def quadrantAndMagnitude(x:Double, y:Double):(Int, Double) = {
    val quad = quadrant(x,y)
    val mag = math.sqrt(x*x+y*y)
    quad -> mag
}

println("input x-coordinate: ")
val ix = readDouble
println("input y-coordinate: ")
val iy = readDouble
println(quadrantAndMagnitude(ix,iy))
