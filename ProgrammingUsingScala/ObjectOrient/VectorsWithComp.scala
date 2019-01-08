class Vect3(var x:Double, var y:Double, var z:Double) {
    def +(v:Vect3) = Vect3(x+v.x, y+v.y, z+v.z)
    def -(v:Vect3) = Vect3(x-v.x, y-v.y, z-v.z)
    def dot(v:Vect3) = x*v.x + y*v.y + z*v.z
    def cross(v:Vect3) = Vect3(
        y*v.z - z*v.y,
        z*v.z - x*v.z,
        x*v.y - y*v.x
    )
    def unary_-() = Vect3(-x, -y, -z)

    def apply(index:Int):Double = index match {
        case 0 => x
        case 1 => y
        case 2 => z
    }

    def update(index:Int, value:Double):Unit = index match{
        case 0 => x = value
        case 1 => y = value
        case 2 => z = value
    }

    def printForm:String = "("+x+", "+y+", "+z+")"
}

object Vect3{
    def apply(x:Double, y:Double, z:Double) = new Vect3(x,y,z)

    def main(args:Array[String]) {
        val v1 = Vect3(1,2,3)
        val v2 = Vect3(3,2,1)
        val v3 = Vect3(3,6,9)
        println((v1+v2).printForm)
        println((v1-v2).printForm)
        val vx = v1 cross v2 + v3
        val vy = (v1 cross v2) + v3
        println(vx.printForm)
        println(vy.printForm)
        println((-v1).printForm)
        // sth like array
        println(v1(0)) // v1(0) expends to v1.apply(0)
        // if variable is mutable and has the apply function defined, you can
        v1(1) = 99     // v1(1) = 99 expends to v1.update(1, 99)
        println(v1(1))
    }
}