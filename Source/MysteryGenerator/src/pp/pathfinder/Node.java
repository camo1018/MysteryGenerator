package pp.pathfinder;

import java.util.ArrayList;

import android.graphics.Point;

public class Node implements Comparable<Node> {

	public Point pos;
	public int costG;
	public int costH;
	public Node parentNode;

	public final int NODE_DELTA = 5;

	public Node(Point pos) {
		this.pos = pos;		
	}

	public int getCostToNode(Node node) {
		int x = node.pos.x - pos.x;
		int y = node.pos.y - pos.y;
		return (int) Math.sqrt(x * x + y * y);
	}

	public boolean addNode(Object node) {
		int node1 = costG + costH;
		int node2 = ((Node) node).costG + ((Node) node).costH;
		if (node1 <= node2) return true;
		else return false;
	}

	public int getFCost() {
		return costG + costH;
	}

	public ArrayList<Node> getAdjacentNodes() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Point> pointList = new ArrayList<Point>();
		Point p1 = new Point(pos.x - NODE_DELTA, pos.y + NODE_DELTA);
		Point p2 = new Point(pos.x - NODE_DELTA, pos.y);
		Point p3 = new Point(pos.x - NODE_DELTA, pos.y - NODE_DELTA);
		Point p4 = new Point(pos.x, pos.y + NODE_DELTA);
		Point p5 = new Point(pos.x, pos.y - NODE_DELTA);
		Point p6 = new Point(pos.x + NODE_DELTA, pos.y + NODE_DELTA);
		Point p7 = new Point(pos.x + NODE_DELTA, pos.y);
		Point p8 = new Point(pos.x + NODE_DELTA, pos.y - NODE_DELTA);
		pointList.add(p1); pointList.add(p2); pointList.add(p3); pointList.add(p4); pointList.add(p5); pointList.add(p6); pointList.add(p7); pointList.add(p8);
		for (Point p : pointList) {
			Node node = new Node(p);
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public int compareTo(Node another) {
		return this.getFCost() - another.getFCost();
	}
	
	public boolean equals(Node another) {
		return this.pos.equals(another.pos);
	}
	
	public static int getCostBetweenNodes(Node node1, Node node2) {
		return node1.getCostToNode(node2);
	}


}
