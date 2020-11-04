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
	
	public ArrayList<Vertex> getEdges(Vertex v) {
		return v.getEdges();
	}
}
