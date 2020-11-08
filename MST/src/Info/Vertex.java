package Info;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Validations.Validations;

public class Vertex {
	private Person person;
	private HashMap<Vertex,Integer> edges;
	
	public Vertex(Person p) {
		Validations.isNull(p);
		this.person = p;
		this.edges = new HashMap<>();
	}
	
	public Person getPerson() {
		return person;
	}
	
	public ArrayList<Vertex> getEdges() {
		ArrayList<Vertex> allEdges = new ArrayList<>();
		for (Vertex vertex : edges.keySet()) {
			allEdges.add(vertex);
		}
		return allEdges;
	}
	
	public int getEdgeSimilarityIndex(Vertex v) {
		if(this.edges.containsKey(v)) {
			return edges.get(v);
		}
		else {
			throw new IllegalArgumentException("El vertice no se relaciona con el vertice pasado.");
		}
	}
	
	public void setEdgeSimilarityIndex(Vertex v) {
		int edgeValue = calculateEdgeSimilarityIndex(v);
		edges.put(v, edgeValue);
	}
	
	private int calculateEdgeSimilarityIndex(Vertex v) {
		return Math.abs(person.getInterest("sports") - v.getPerson().getInterest("sports"))
				+ Math.abs(person.getInterest("music") - v.getPerson().getInterest("music"))
				+ Math.abs(person.getInterest("newsShow") - v.getPerson().getInterest("newsShow"))
				+ Math.abs(person.getInterest("science") - v.getPerson().getInterest("science"));
	}
}
