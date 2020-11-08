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
			for (Vertex vertex : graph) {
				vertex.setEdgeSimilarityIndex(v);
				v.setEdgeSimilarityIndex(vertex);
			}
			graph.add(v);
		}
	}
	
	public ArrayList<Vertex> cleanGraph() {
		ArrayList<Vertex> copy = new ArrayList<>();
		for(Vertex ver:graph) {
			ver.cleanEdges();
			copy.add(ver);
		}
		return copy;
	}
	
	public void removeBiggerEdge(){
		Vertex from = null;
		Vertex to = null;
		int i = -1;
		for(Vertex v:this.graph) {
			for(Vertex v2:v.getEdges()) {
				if(v.getEdgeSimilarityIndex(v2) > i) {
					from = v;
					to = v2;
				}
			}
		}
		int index = from.indexOf(to);
		from.removeEdge(index);
	}
	
}
