package com.mildred.datastructures.exercises.Graph;

import com.mildred.datastructures.Graph;

public class GraphTesting {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.printGraph();

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        myGraph.printGraph();

        System.out.println();

        Graph graph2 = new Graph();
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "D");
        graph2.addEdge("A", "C");
        graph2.addEdge("B", "D");
        graph2.addEdge("C", "D");
        graph2.printGraph();

        graph2.removeVertex("D");
        graph2.printGraph();

    }
}
