package Info;

import java.util.HashMap;

public class Vertex {
	private int value;
	private HashMap<Vertex,Integer> edges;
	
	public Vertex(int value) {
		this.value = value;
		this.edges = new HashMap<>();
	}
	
	public int getValue() {
		return value;
	}
	
	public int getEdgeSimilarityIndex(Vertex v) {
		return edges.get(v);
	}
}
