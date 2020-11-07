package Logic;

import java.util.ArrayList;

import Info.Vertex;

public class Graph {
	private ArrayList<Vertex> graph;
	
	public Graph() {
		this.graph = new ArrayList<>();
	}
	
	public ArrayList<Vertex> getGraph() {
		return graph;
	}
	
	public int size() {
		return graph.size();
	}
	
	public ArrayList<Vertex> copyGraph() {
		ArrayList<Vertex> copy = new ArrayList<Vertex>();
		for (Vertex vertex : this.graph) {
			copy.add(vertex);
		}
		clean(copy);
		return copy;
	}
	
	private void clean(ArrayList<Vertex> copy) {
		for (Vertex vertex : copy) {
			vertex.cleanEdges();
		}
	}
	
//	public Vertex getMinimumEdge(Vertex v) {
//		Vertex ver = null;
//		for (Vertex vertex : v.getEdges()) {
//			if(ver == null) {
//				ver = vertex;
//			}
//			else {
//				if(v.getEdgeSimilarityIndex(vertex) < v.getEdgeSimilarityIndex(ver)) {
//					ver = vertex;
//				}
//			}
//		}
//		return ver;
//	}
}
