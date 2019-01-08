// hanoi tower
/* Getting recursion function
    1. head,tail/ init,last vs. many parts. => init,last
    2. repeated process => big = moveSmall then move big one then moveSmall
   Linear recursion path
   No optimization
*/

val tower = Array(List(1,2,3), List[Int](), List[Int]())

def moveOne(from:Int, to:Int) {
    require(tower(from).length >= 1 && (tower(to).isEmpty || tower(from).head < tower(to).head))
    val (h,t) = (tower(from).head, tower(from).tail)
    tower(from) = t
    tower(to) = h :: tower(to)
    println(tower.mkString)
}

def hanoi(n:Int, from:Int, to:Int) {
    if(n == 1) moveOne(from, to)
    else{
        hanoi(n-1, from, 3-from-to)
        moveOne(from, to)
        hanoi(n-1, 3-from-to, to)
    }
}

println(tower.mkString)
hanoi(3, 0, 2)