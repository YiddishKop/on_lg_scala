class Vect3(val x:Double, val y:Double, val z:Double) {
    // scala allow method name is just an operator symbol, like +-*/ etc.
    // a little like operator symbol reloading in c++
    // be sure the symbol you defined is easily readable and understandable
    def +(v:Vect3) = new Vect3(x+v.x, y+v.y, z+v.z)
    def -(v:Vect3) = new Vect3(x-v.x, y-v.y, z-v.z)
    def dot(v:Vect3) = x*v.x + y*v.y + z*v.z
    def cross(v:Vect3) = new Vect3(
        y*v.z - z*v.y,
        z*v.z - x*v.z,
        x*v.y - y*v.x
    )

    // how to define unary operator
    // only allow 3 unary operator: -, !, ~ 
    def unary_-() = new Vect3(-x, -y, -z)

    def printForm:String = "("+x+", "+y+", "+z+")"
}

val v1 = new Vect3(1,2,3)
val v2 = new Vect3(3,2,1)
val v3 = new Vect3(3,6,9)
println((v1+v2).printForm)
println((v1-v2).printForm)
val vx = v1 cross v2 + v3
val vy = (v1 cross v2) + v3
println(vx.printForm)
println(vy.printForm)
println((-v1).printForm)