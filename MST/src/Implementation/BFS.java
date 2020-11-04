package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Info.Vertex;
import Logic.Graph;

public class BFS {
	public Set<Vertex> reachables(Graph graph, Vertex v) {
		Set<Vertex> reach = new HashSet<>();
		Set<Vertex> control = new HashSet<>();
		ArrayList<Vertex> pending = new ArrayList<>();
		pending.add(v);
		control.add(v);
		
		while(pending.size()!=0) {
			Vertex vertex = pending.get(0);
			reach.add(vertex);
			pending.remove(0);
			
			for (Vertex ver : graph.getEdges(vertex) ) {
				if(!control.contains(ver)) {
					pending.add(ver);
					control.add(ver);
				}
			}
		}
		return reach;
	}
	
	public boolean isConnected(Graph graph) {
		if(graph.size()==0) {
			return false;
		}
		else {
			Set<Vertex> set = reachables(graph,graph.getGraph().get(0));
			if(set.size() == graph.size()) {
				return true;
			}
		}
		return false;
	}
}
