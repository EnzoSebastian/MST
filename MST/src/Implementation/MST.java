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
		//Set<Vertex> edges = new HashSet<>();
		Graph copy = new Graph();
		int i = 1;
		while(i <= graph.size()-1) {
			Vertex from = null;
			Vertex to = null;
			for(Vertex vert: vertex) {
				Iterator<Vertex> it = vert.getEdges().iterator();
				while(it.hasNext()) {
					Vertex vertex2 = it.next();
					if(from == null) {
						from = vert;
						if(vertex.contains(vertex2)) {
							it.next();
						}
						else if(to == null && !vertex.contains(vertex2)) {
							to = vertex2;
						}
						else {
							if(from == vert) {
								if(from.getEdgeSimilarityIndex(vertex2) < from.getEdgeSimilarityIndex(to) 
										) {
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
			copy.getGraph().add(from);
			int index = copy.getGraph().indexOf(from);
			copy.getGraph().get(index).setEdgeSimilarityIndex(to);
		}
		return copy.getGraph();
	}
}
