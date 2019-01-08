import java.io.{PrintWriter, BufferedWriter, FileWriter, File}

def logisticMap(x:Double, r:Double):Double = r*x*(1-x)
// argument can be java.io.File Object, or file-path
// print out logistic map
println("what value do you want to use for r?")
val r = readDouble // scala built-in fn
val seq = new PrintWriter("logseq.txt")
val cobweb = new PrintWriter("cobweb.txt")
var x = 0.1
var last = 0.0
for(i <- 1 to 100) {
    last = x
    x = logisticMap(x, r)
    seq.println(x)
    cobweb.println(last + " " +x)
}
seq.close
cobweb.close

// val file = new File("logseq2.txt")
// val bw = new BufferedWriter(new FileWriter(file))
// bw.write("hello world")
// bw.close()