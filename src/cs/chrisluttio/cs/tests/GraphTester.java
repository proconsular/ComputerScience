package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chrisluttio.cs.graphs.Graph;
import com.chrisluttio.cs.graphs.GraphNode;

public class GraphTester {

	@Test
	public void testInit() {
		Graph<Integer> graph = new Graph<>();
		assertNotEquals(null, graph);
	}
	
	@Test
	public void testInsert() {
		Graph<Integer> graph = new Graph<>();
		
		graph.insert(3);
		graph.insert(10);
		graph.insert(6);
		
		graph.connect(0, 1);
		graph.connect(0, 2);
		
		assertEquals(new Integer(3), graph.vertices.get(0).value);
		assertEquals(new Integer(10), graph.vertices.get(1).value);
		assertEquals(1, graph.traverse(0, 0));
		assertEquals(2, graph.traverse(0, 1));
		assertEquals(new Integer(6), graph.vertices.get(graph.traverse(0, 1)).value);
	}
	
	@Test
	public void testBFS() {
		Graph<Integer> graph = new Graph<>();
		
		graph.insert(10);
		graph.insert(5);
		graph.insert(7);
		graph.insert(11);
		graph.insert(14);
		graph.insert(1);
		
		graph.connect(0, 1);
		graph.connect(1, 2);
		graph.connect(2, 3);
		graph.connect(2, 1);
		graph.connect(3, 2);
		graph.connect(5, 1);
		graph.connect(4, 5);
		graph.connect(3, 4);
		
		graph.breathFirstSearch(0);
		
		assertEquals(new Integer(14), graph.vertices.get(5).parent.value);
		assertEquals(new Integer(11), graph.vertices.get(5).parent.parent.value);
		assertEquals(new Integer(7), graph.vertices.get(5).parent.parent.parent.value);
	}
	
	@Test
	public void testDFS() {
		Graph<Integer> graph = new Graph<>();
		
		graph.insert(10);
		graph.insert(5);
		graph.insert(7);
		graph.insert(11);
		graph.insert(14);
		graph.insert(1);
		
		graph.connect(0, 1);
		graph.connect(1, 3);
		graph.connect(2, 3);
		graph.connect(2, 1);
		graph.connect(3, 2);
		graph.connect(5, 1);
		graph.connect(4, 5);
		graph.connect(3, 4);
		
		graph.depthFirstSearch();
		
		GraphNode<Integer> current = graph.vertices.get(5);
		assertEquals(new Integer(14), current.parent.value);
		assertEquals(new Integer(11), current.parent.parent.value);
		assertEquals(new Integer(5), current.parent.parent.parent.value);
	}
	
}
