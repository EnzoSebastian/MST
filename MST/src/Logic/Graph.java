package Logic;

import java.util.ArrayList;

import Info.Vertex;
import Validations.Validations;

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
	
	public void addVertex(Vertex v) {
		Validations.isNull(v);
		if(this.size()==0) {
			graph.add(v);
		}
		else {
			graph.add(v);
			for (Vertex vertex : graph) {
				vertex.setEdgeSimilarityIndex(v);
				v.setEdgeSimilarityIndex(vertex);
			}
		}
	}
	
}
