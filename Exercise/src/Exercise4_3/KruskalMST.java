package Exercise4_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

import java.util.Arrays;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;

public class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1.0E-12;

    private double weight;
    private Queue<Edge> mst = new Queue<Edge>();

    public KruskalMST(EdgeWeightedGraph G) {
        Edge[] edges = new Edge[G.E()];
        int t = 0;
        for (Edge e : G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges);

        UF uf = new UF(G.V());
        for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            Edge e = edges[i];
            int v = e.either();
            int w = e.other(v);

            // v-w does not create a cycle
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w); // merge v and w components
                mst.enqueue(e); // add edge e to mst
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
    
        
    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        In in = new In("Exercise/lib/algs4-data/tinyEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}
