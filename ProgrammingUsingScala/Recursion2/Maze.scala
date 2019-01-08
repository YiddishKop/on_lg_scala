// a 10*10 maze represented by array of array
val maze = Array(Array( 0,-1, 0,-1, 0, 0, 0, 0, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0, 0, 0, 0, 0,-1,-1,-1, 0, 0),
                 Array( 0,-1, 0,-1,-1,-1, 0, 0, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1,-1,-1, 0, 0),
                 Array( 0,-1, 0, 0, 0,-1, 0, 0, 0, 0),
                 Array( 0,-1,-1,-1, 0,-1, 0,-1,-1, 0),
                 Array( 0, 0, 0, 0, 0,-1, 0, 0, 0, 0))

val mazet= Array(Array( 0,-1, 0,-1, 0, 0, 0, 0, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1, 0,-1, 0, 0),
                 Array( 0, 0, 0, 0, 0,-1,-1,-1, 0, 0),
                 Array( 0,-1, 0,-1,-1,-1, 0, 0, 0, 0),
                 Array( 0,-1, 0,-1, 0,-1,-1,-1, 0, 0),
                 Array( 0,-1, 0, 0, 0,-1, 0, 0, 0, 0),
                 Array( 0,-1,-1,-1, 0,-1, 0,-1,-1, 0),
                 Array( 0, 0, 0, 0, 0,-1, 0, 0, 0, 0))

val maze2= Array(Array( 0, 0, 0),
                 Array( 0,-1, 0),
                 Array(-1,-1, 0))

// (x,y) where I am, (ex,ey) where exit.
def shortestPath(maze:Array[Array[Int]], x:Int, y:Int, ex:Int, ey:Int):Int = {
    if(x == ex && y == ey) 0 
    else if(x<0 || x>=maze.length || y<0 || y>=maze(x).length || maze(x)(y)<0) {
        // Not - 1 or Int.MaxValue, because I later will add min(up,down,left,right)+1
        // '-1' will always make min = -1
        // 'MaxValue' maybe dangerous because of +1 will make it negative
        100000000 
    } else {
        // we must prevent the dribble round problem, left-ritht-left-right-left...
        // Leaving a record of where we've been, it likes to dropping bread crums
        // leaving maze(x)(y)=-2 will 
        maze(x)(y) = -2
        val dist =(shortestPath(maze, x+1, y, ex, ey) min
                   shortestPath(maze, x-1, y, ex, ey) min
                   shortestPath(maze, x, y+1, ex, ey) min
                   shortestPath(maze, x, y-1, ex, ey)) + 1
        maze(x)(y) = 0
        dist
    }
}

def shortestPath2(maze:Array[Array[Int]], x:Int, y:Int, ex:Int, ey:Int, steps:Int):Int = {
    if(x == ex && y == ey) 0 
    else if(x<0 || x>=maze.length || y<0 || y>=maze(x).length || maze(x)(y)<0) {
        // Not - 1 or Int.MaxValue, because I later will add min(up,down,left,right)+1
        // '-1' will always make min = -1
        // 'MaxValue' maybe dangerous because of +1 will make it negative
        100000000 
    } else if(maze(x)(y)>0 && maze(x)(y)<=steps) {
        100000000
    } else {
        // bread crumbs dosen't show any information except whether or not you've been there
        // leave steps there like toast that's had stamped on it
        maze(x)(y) = steps 
        val dist =(shortestPath2(maze, x+1, y, ex, ey, steps+1) min
                   shortestPath2(maze, x-1, y, ex, ey, steps+1) min
                   shortestPath2(maze, x, y+1, ex, ey, steps+1) min
                   shortestPath2(maze, x, y-1, ex, ey, steps+1)) + 1
        // we not pick it back now
        // maze(x)(y) = 0
        dist
    }
}

println(maze(0)(0))
println(maze(8)(8))
println(shortestPath(maze,0,0,9,9))
maze.foreach(a => println(a.mkString(", ")))

println(mazet(0)(0))
println(mazet(8)(8))
println(shortestPath2(mazet,0,0,9,9,1))
mazet.foreach(a => println(a.mkString(", ")))



// val STP1Start = System.nanoTime
// shortestPath(maze2,0,0,2,2)
// println("STP1 used " + (System.nanoTime - STP1Start)*1E-9)

// val STP2Start = System.nanoTime
// shortestPath2(maze2,0,0,2,2,1)
// println("STP2 used " + (System.nanoTime - STP2Start)*1E-9)
