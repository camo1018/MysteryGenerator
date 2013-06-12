package pp.pathfinder;

import android.graphics.Point;

public class Node {
	
	public Point pos;
	public int costG;
	public int costH;
	public Node parentNode;
	
	public Node(Point pos) {
		this.pos = pos;		
	}
	
	public int getCost(Node node) {
		int x = node.pos.x - pos.x;
		int y = node.pos.y - pos.y;
		return (int) Math.sqrt(x * x + y * y);
	}
	
	public boolean addNode(Object node) {
		int node1 = costG = costH;
		int node2 = ((Node) node).costG + ((Node) node).costH;
		if (node1 <= node2) return true;
		else return false;
	}

}
