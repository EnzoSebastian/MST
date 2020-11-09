package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Implementation.BFS;
import Info.Person;
import Info.Vertex;
import Logic.Graph;

public class TestBFS {
	Graph graph;

	@Before
	public void setUp(){
		graph = new Graph();
		Person person1 = new Person("Enzo",5,5,2,4);
		Person person2 = new Person("Brian",5,5,1,1);
		Person person3 = new Person("Javier",5,3,4,5);
		Vertex ver1 = new Vertex(person1);
		Vertex ver2 = new Vertex(person2);
		Vertex ver3 = new Vertex(person3);
		graph.addVertex(ver1);
		graph.addVertex(ver2);
		graph.addVertex(ver3);
	}

	@Test
	public void bfs() {
		ArrayList<Vertex> array = BFS.reachables(graph);
		assertEquals(3,array.size());
	}
	
	@Test
	public void isConnected() {
		assertTrue(BFS.isConnected(graph));
	}

}
