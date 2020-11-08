package Tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Implementation.MST;

import Info.Person;
import Info.Vertex;
import Logic.Graph;

public class TestMST {
	Graph graph;

	@Before
	public void setUp(){
		graph = new Graph();
		Person person1 = new Person("Enzo",5,5,2,4);
		Person person2 = new Person("Brian",3,2,1,1);
		Person person3 = new Person("Javier",1,3,5,5);
		Person person4 = new Person("Pablo",5,3,1,1);
		Person person5 = new Person("Sergio",2,3,3,2);
		Vertex ver1 = new Vertex(person1);
		Vertex ver2 = new Vertex(person2);
		Vertex ver3 = new Vertex(person3);
		Vertex ver4 = new Vertex(person4);
		Vertex ver5 = new Vertex(person5);
		graph.addVertex(ver1);
		graph.addVertex(ver2);
		graph.addVertex(ver3);
		graph.addVertex(ver4);
		graph.addVertex(ver5);
	}

	@Test
	public void MST() {
		Graph newer = MST.prim(graph);
		ArrayList<Vertex> mst = newer.getGraph();
		for(int i = 0;i < mst.size()-1;i++) {
			Vertex v = mst.get(i);
			if(v.getEdges().size()!=0) {
				System.out.println(v.getPerson().getName() + " se relaciona con: ");
				for(Vertex ver:v.getEdges()) {
					System.out.println("(" + ver.getPerson().getName() + ", Valor de arista: " + v.getEdgeSimilarityIndex(ver) + ")");
				}
			}
		}
		
		System.out.println("El grafo contiene los vertices: ");
		for (Vertex vertex : mst) {
			System.out.println(vertex.getPerson().getName());
		}
	}
	
	@Test
	public void MSTremovedEdge() {
		Graph newer = MST.prim(graph);
		newer.removeBiggerEdge();
		ArrayList<Vertex> mst = newer.getGraph();
		for(int i = 0;i < mst.size()-1;i++) {
			Vertex v = mst.get(i);
			if(v.getEdges().size()!=0) {
				System.out.println(v.getPerson().getName() + " se relaciona con: ");
				for(Vertex ver:v.getEdges()) {
					System.out.println("(" + ver.getPerson().getName() + ", Valor de arista: " + v.getEdgeSimilarityIndex(ver) + ")");
				}
			}
		}
		
		System.out.println("El grafo contiene los vertices: ");
		for (Vertex vertex : mst) {
			System.out.println(vertex.getPerson().getName());
		}
	}

}
