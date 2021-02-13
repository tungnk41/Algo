

fun main(args: Array<String>) {
    var g = Graph(3)
    g.addEdge(0,1)
    g.addEdge(0,2)
    g.addEdge(1,0)
    g.addEdge(1,2)
    g.addEdge(2,0)
    g.addEdge(2,1)
    g.printAllVertex()

}