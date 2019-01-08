// how to represent the disks inside of our program
// disk:Int (because only size matter)
// disks:List[Int]
// towers:Array[List[Int]]

val pegs = Array(List(1,2,3,4), List[Int](), List[Int]())

def moveOne(from:Int, to:Int) = {
    require(pegs(to).isEmpty || pegs(from).head < pegs(to).head)
    pegs(to) = pegs(from).head :: pegs(to)
    pegs(from) = pegs(from).tail
    println(pegs.mkString(", "))
}

def hanoi(num:Int, from:Int, to:Int) {
    if(num != 1) {
        hanoi(num-1, from, 3-from-to)
        moveOne(from, to)
        hanoi(num-1, 3-from-to, to)
    } else moveOne(from, to)
} 

hanoi(pegs(0).length,0,2)