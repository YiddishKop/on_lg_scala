import swing._
import event._
import java.awt.Color
import java.awt.geom._
import java.awt.image.BufferedImage
// import actors._

val numValues = if (args.length < 1) 300 else args(0).toInt

val nums = Array.fill(numValues)(math.random)
val values = Array.fill(3)(nums.map(x => x))

val images = for(i <- 1 to 3) yield {
    new BufferedImage(numValues, 200, BufferedImage.TYPE_INT_ARGB)
}

val panel = new Panel {
    override def paint(g:Graphics2D) {
        for(i <- images.indices) g.drawImage(images(i), 0, i*200, null)
    }
    preferredSize = new Dimension(numValues, 600)
}

def renderValues(img:BufferedImage, arr:Array[Double], j:Int, min:Int = -1) {
    val g = img.createGraphics
    g.setPaint(Color.black)
    g.fill(new Rectangle2D.Double(0, 0, img.getWidth, img.getHeight))
    g.setPaint(Color.white)
    for(i <- arr.indices) {
        g.draw(new Line2D.Double(i, 200, i, 200 - 190*arr(i)))
    }
    g.setPaint(Color.red)
    g.draw(new Line2D.Double(j,0,j,10))
    g.setPaint(Color.blue)
    g.draw(new Line2D.Double(min,0,min,10))
    panel.repaint
    Thread.sleep(10)
}

def testSorted(arr:Array[Double]):Boolean = {
    // Bad method:
    // 1. using 'var'
    // 2. inefficient --- even the 1st element is unsorted, the loop will go on to end
    var ret = true
    for(i <- 0 until arr.length - 1) {
        if(arr(i) >= arr(i+1)) ret = false
    }
    ret
}

def testSorted2(arr:Array[Double]):Boolean = {
    var i = 0
    while(i < arr.length - 1 && arr(i) <= arr(i+1)) i += 1 
    i >= arr.length - 1
}

def testSorted3(arr:Array[Double]):Boolean = {
    (arr.zip(arr.tail)).forall(t => t._1 <= t._2)
}


def testSort(sortFunc: Array[Double] => Unit):Boolean = {
    val nums = Array.fill(2000)(math.random)
    sortFunc(nums)
    testSorted3(nums) 
}


// mutable version: modify directly on array
def bubbleSort(arr:Array[Double]) {
    // flag bubble sort: outer loop will stop if nothing gets moved
    // non flag bubble sort: outer loop go through n - 1 times, this guarantee the result is sorted
    for (i <- 0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
        if(arr(j) > arr(j+1)) {
            val tmp = arr(j)
            arr(j) = arr(j+1)
            arr(j+1) = tmp
        }
        renderValues(images(0), arr, j)
    }
}

// selection sort
def minSort(arr:Array[Double]) {
    for(i <- 0 until arr.length - 1) {
        var min_index = i
        for(j <- i+1 until arr.length) {
            if(arr(j) < arr(min_index)) min_index = j
            // for vision
            renderValues(images(1), arr, j, min_index)
        }
        if (min_index != i) {
            val tmp = arr(i)
            arr(i) = arr(min_index)
            arr(min_index) = tmp
        }
    }
}

// insertion sort
def insertionSort(arr:Array[Double]) {
    for(i <- 1 until arr.length) {
        val tmp = arr(i)
        // use other loop, for reason that this loop should stop possibly at small than zero 
        var j = i - 1
        while(j > -1 && arr(j) > tmp) {
            arr(j+1) = arr(j )
            j -= 1
            // for vision
            renderValues(images(2), arr, j)
        }
        arr(j+1) = tmp 
    }
}

// println(testSort(bubbleSort))
// println(testSort(minSort))
// println(testSort(insertionSort))

val frame = new MainFrame{
    title = "Sorts"
    contents = panel
    centerOnScreen
}
frame.open

// scala.actors._ is not supported, be sure to ues AKKA
// Actor.actor(bubbleSort(values(0)))
// Actor.actor(minSort(values(1)))
// Actor.actor(insertionSort(values(2)))

// bubbleSort(values(0))
// minSort(values(1))
insertionSort(values(2))



