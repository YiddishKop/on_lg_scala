import scala.swing._

val frame = new MainFrame {
    title = "My First GUI"
    contents = Button("Click Me!")(println("Button was clicked.")) // print to console, not the GUI frame
    contents = new TextArea
    // 'contents'(including Buttong and other things) must below to 'size'. other wise the frame will just cut to size of a button
    // when you set the contents, it will change the size and it does this by using an operation called pack() and pack() throw
    // things into as small of a space as it can.
    size = new Dimension(500, 500)// window occur on the top-left corner of workspace
    centerOnScreen
}

frame.visible = true