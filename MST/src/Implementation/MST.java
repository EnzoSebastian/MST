package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Info.Vertex;
import Logic.Graph;

public class MST {
	public static ArrayList<Vertex> minimumSpanningTree(Graph graph) {
		if(graph.size()!=0) {
			return prim(graph);
		}
		else {
			throw new IllegalArgumentException("No se puede conseguir el AGM de un grafo vacio.");
		}
	}

	private static ArrayList<Vertex> prim(Graph graph) {
		Set<Vertex> vertex = new HashSet<Vertex>();
		vertex.add(graph.getGraph().get(0));
		Graph copy = new Graph();
		int i = 1;
		while(i <= graph.size()-1) {
			Vertex from = null;
			Vertex to = null;
			for(Vertex vert: vertex) {
				Iterator<Vertex> it = vert.getEdges().iterator();
				Vertex vertex2 = it.next();
				while(it.hasNext()) {
					if(vertex.contains(vertex2)) {
						it.next();
						continue;
					}
					if(from == null) {
						from = vert;
						if(to == null) {
							to = vertex2;
						}
						else {
							if(from == vert) {
								if(from.getEdgeSimilarityIndex(vertex2) < from.getEdgeSimilarityIndex(to)) {
									to = vertex2;
								}
							}
							else {
								if(vert.getEdgeSimilarityIndex(vertex2) < from.getEdgeSimilarityIndex(to)) {
									from = vert;
									to = vertex2;
								}
							}
						}
					}
					else {
						if(from == vert) {
							if(from.getEdgeSimilarityIndex(vertex2) < from.getEdgeSimilarityIndex(to)) {
								to = vertex2;
							}
						}
						else {
							if(vert.getEdgeSimilarityIndex(vertex2) < from.getEdgeSimilarityIndex(to)) {
								from = vert;
								to = vertex2;
							}
						}
					}
				}
			}
			vertex.add(to);
			addVertex(copy, from, to);
		}
		return copy.getGraph();
	}

	private static void addVertex(Graph copy, Vertex from, Vertex to) {
		copy.getGraph().add(from);
		int index = copy.getGraph().indexOf(from);
		copy.getGraph().get(index).setEdgeSimilarityIndex(to);
	}
}
