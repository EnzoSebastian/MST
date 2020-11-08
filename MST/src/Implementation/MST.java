package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Info.Vertex;
import Logic.Graph;

public class MST {
	public static Graph prim(Graph graph) {
		if(graph.size()!=0) {
			return primImplementation(graph);
		}
		else {
			throw new IllegalArgumentException("No se puede conseguir el AGM de un grafo vacio.");
		}
	}

	private static Graph primImplementation(Graph graph) {
		Set<Vertex> vertex = new HashSet<Vertex>();
		ArrayList<Vertex> copy = graph.cleanGraph();
		vertex.add(copy.get(0));
		Graph primTree = new Graph();
		int i = 1;
		while(i < copy.size()) {
			Vertex from = null;
			Vertex to = null;
			for(Vertex vert: vertex) {
				Iterator<Vertex> it = copy.iterator();
				while(it.hasNext()) {
					Vertex vertex2 = it.next();
					if(vertex.contains(vertex2)) {
						continue;
					}
					if(from == null) {
						from = vert;
						if(to == null) {
							to = vertex2;
						}
						else {
							if(from == vert) {
								if(from.calculateEdgeSimilarity(vertex2) < from.calculateEdgeSimilarity(to)) {
									to = vertex2;
								}
							}
							else {
								if(vert.calculateEdgeSimilarity(vertex2) < from.calculateEdgeSimilarity(to)) {
									from = vert;
									to = vertex2;
								}
							}
						}
					}
					else {
						if(from == vert) {
							if(from.calculateEdgeSimilarity(vertex2) < from.calculateEdgeSimilarity(to)) {
								to = vertex2;
							}
						}
						else {
							if(vert.calculateEdgeSimilarity(vertex2) < from.calculateEdgeSimilarity(to)) {
								from = vert;
								to = vertex2;
							}
						}
					}
				}
			}
			vertex.add(to);
			addVertex(primTree, from, to);
			i++;
		}
		return primTree;
	}

	private static void addVertex(Graph copy, Vertex from, Vertex to) {
		ArrayList<Vertex> graph = copy.getGraph();
		if(!graph.contains(from)) {
			graph.add(from);
		}
		if(!graph.contains(to)) {
			graph.add(to);
		}
		int index = graph.indexOf(from);
		graph.get(index).setEdgeSimilarityIndex(to);
	}
}
