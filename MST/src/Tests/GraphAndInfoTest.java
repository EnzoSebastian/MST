package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Info.Person;
import Info.Vertex;
import Logic.Graph;

public class GraphAndInfoTest {
	Graph graph;
	Person person;
	Vertex vertex;

	@Before
	public void setUpBefore(){
		graph = new Graph();
	}

	@Test
	public void graphCreatedEmpty() {
		assertEquals(0,graph.size());
	}
	
	@Test
	public void createRealPerson() {
		person = new Person("Enzo",5,5,2,4);
	}
	
	@Test (expected = NullPointerException.class)
	public void createPersonNullName() {
		person = new Person(null,5,5,2,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonEmptyString() {
		person = new Person("",5,5,2,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonLowerIntegerSports() {
		person = new Person("Enzo",0,5,2,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonHigherIntegerSports() {
		person = new Person("Enzo",6,5,2,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonLowerIntegerMusic() {
		person = new Person("Enzo",5,0,2,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonHigherIntegerMusic() {
		person = new Person("Enzo",5,6,2,4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void createPersonLowerIntegerNewsShow() {
		person = new Person("Enzo",5,5,0,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonHigherIntegerNewsShow() {
		person = new Person("Enzo",5,5,6,4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonLowerIntegerScience() {
		person = new Person("Enzo",5,5,2,0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createPersonHigherIntegerScience() {
		person = new Person("Enzo",5,5,2,6);
	}
	
	@Test
	public void realPersonGetName() {
		person = new Person("Enzo",5,5,2,4);
		assertEquals("Enzo",person.getName());
	}
	
	@Test
	public void realPersonGetSports() {
		person = new Person("Enzo",5,5,2,4);
		assertEquals(5,person.getInterest("sports"));
	}
	
	@Test
	public void realPersonGetMusic() {
		person = new Person("Enzo",5,5,2,4);
		assertEquals(5,person.getInterest("music"));
	}
	
	@Test
	public void realPersonGetNewsShow() {
		person = new Person("Enzo",5,5,2,4);
		assertEquals(2,person.getInterest("newsShow"));
	}
	
	@Test
	public void realPersonGetScience() {
		person = new Person("Enzo",5,5,2,4);
		assertEquals(4,person.getInterest("science"));
	}
	
	@Test
	public void createVertex() {
		person = new Person("Enzo",5,5,2,4);
		vertex = new Vertex(person);
	}
	
	@Test
	public void createVertexAndAddToGraph() {
		person = new Person("Enzo",5,5,2,4);
		vertex = new Vertex(person);
		graph.addVertex(vertex);
		assertTrue(graph.getGraph().contains(vertex));
	}
	
	@Test (expected = NullPointerException.class)
	public void createVertexWithNullPerson() {
		vertex = new Vertex(null);
	}
	
	@Test
	public void getPersonFromVertex() {
		person = new Person("Enzo",5,5,2,4);
		vertex = new Vertex(person);
		assertEquals(person,vertex.getPerson());
	}
	
	@Test
	public void compareVertexEdgeSimilarity() {
		person = new Person("Enzo",5,5,2,4);
		vertex = new Vertex(person);
		graph.addVertex(vertex);
		
		Person nuevo= new Person("Brian",5,5,5,5);
		Vertex nuevoV= new Vertex(nuevo);
		graph.addVertex(nuevoV);
		
		assertEquals(4,vertex.getEdgeSimilarityIndex(nuevoV));
	}
	
}
