package Implementation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import Info.Vertex;
import Logic.Graph;

public class BFS {
	public static Set<Vertex> reachables(Graph graph) {
		Set<Vertex> reach = new HashSet<>();
		Set<Vertex> control = new HashSet<>();
		Queue<Vertex> pending = new LinkedList<>();
		if(graph.size()!=0) {
			Vertex v = graph.getGraph().get(0);
			pending.add(v);
			control.add(v);
			
			while(pending.size()!=0) {
				Vertex vertex = pending.poll();
				reach.add(vertex);
				//pending.remove(vertex);
				
				for (Vertex ver : vertex.getEdges() ) {
					if(!control.contains(ver)) {
						pending.add(ver);
						control.add(ver);
					}
				}
			}
		}
		return reach;
	}
	
	public static boolean isConnected(Graph graph) {
		if(graph.size()==0) {
			return false;
		}
		else {
			Set<Vertex> set = reachables(graph);
			if(set.size() == graph.size()) {
				return true;
			}
		}
		return false;
	}
}
