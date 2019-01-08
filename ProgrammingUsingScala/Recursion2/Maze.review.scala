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

// multi-parts problem: min(left_Small, right_Small, up_Small, down_Small) + 1
// multi-dimension recursive path
def shortestPath(maze:Array[Array[Int]], xs:Int, ys:Int, xe:Int, ye:Int):Int = {
    if(xs == xe && ys == ye) 0
    // recursive roll back
    else if(xs < 0 || ys < 0 || xs >= maze.length || ys >= maze(0).length || maze(xs)(ys) == -2 || maze(xs)(ys) == -1) 1000000 else{
        maze(xs)(ys) = -2
        val dist = (shortestPath(maze, xs+1, ys, xe, ye) min
                    shortestPath(maze, xs-1, ys, xe, ye) min
                    shortestPath(maze, xs, ys+1, xe, ye) min
                    shortestPath(maze, xs, ys-1, xe, ye)    ) + 1
        maze(xs)(ys) = 0
        dist
    }
}

// efficient with memoized path have passed with less steps
def shortestPath2(maze:Array[Array[Int]], xs:Int, ys:Int, xe:Int, ye:Int, steps:Int):Int = {
    if(xs == xe && ys == ye) 0
    // recursive roll back
    else if(xs < 0 || ys < 0 || xs >= maze.length || ys >= maze(0).length || maze(xs)(ys) == -1) 1000000 
    else if(maze(xs)(ys) > 0 && maze(xs)(ys) < steps) 1000000 
    else{
        maze(xs)(ys) = steps 
        val dist = (shortestPath2(maze, xs+1, ys, xe, ye, steps + 1) min
                    shortestPath2(maze, xs-1, ys, xe, ye, steps + 1) min
                    shortestPath2(maze, xs, ys+1, xe, ye, steps + 1) min
                    shortestPath2(maze, xs, ys-1, xe, ye, steps + 1)    ) + 1
        dist
    }
}
println(shortestPath(maze, 0, 0, 9, 9))
println(shortestPath2(maze, 0, 0, 9, 9, 1))
maze.foreach(a => println(a.mkString(", ")))