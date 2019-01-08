class Rational(val numer:Int, val denom:Int) {
    def print {println(numer+"/"+denom)} 
    def multiply(r2:Rational):Rational = {
        new Rational(numer*r2.numer, denom*r2.denom)
    }
}

val r = new Rational(2,3)
r.print
println(r.numer)
val r1 = new Rational(3,4)
println(r.multiply(r1).numer)