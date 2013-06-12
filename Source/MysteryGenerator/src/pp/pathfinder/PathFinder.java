package pp.pathfinder;

import java.util.LinkedList;
import java.util.List;

import android.graphics.Point;

/**
 * A* Pathfinder 
 * @author PaulPa
 *
 */
public class PathFinder {

	private LinkedList<Node> openList;
	private LinkedList<Node> closedList;
	private int[][] map;
	private int[] block;
	
	public PathFinder(int[][] map) {
		this.map = map;
		openList = new LinkedList<Node>();
		closedList = new LinkedList<Node>();
	}
	
	public List<Node> searchPath(Point startPos, Point endPos) {
		Node startNode = new Node(startPos);
		Node endNode = new Node(endPos);
		startNode.costG = 0;
		startNode.costH = startNode.getCost(endNode);
		startNode.parentNode = null;
		openList.add(startNode);
		while (!openList.isEmpty()) {
			Node firstNode = (Node) openList.removeFirst();
			if (firstNode.equals(endNode)) {
				return buildPath(firstNode);
			}
		}
	}
	
}
