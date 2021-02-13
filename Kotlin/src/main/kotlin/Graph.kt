import java.util.*
import kotlin.collections.ArrayList

class Graph(vertex: Int) {
    private var m_vertex = 0
    private var m_adj: ArrayList<ArrayList<Int>> = ArrayList<ArrayList<Int>>()
    init {
        m_vertex = vertex
    }

    public fun addEdge(v: Int, E: Int){
        m_adj[v].add(E)
    }

    public fun printAllVertex(){
        for (vertex in 0..m_vertex){
            println("vertex : $vertex + ${m_adj.get(0)}")
        }
    }

}