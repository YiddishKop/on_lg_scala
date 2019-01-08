object TestObject {
    var i = 0
    def func1 {
        i += 1
        println(i)
    }
}

println(TestObject.i)
TestObject.func1