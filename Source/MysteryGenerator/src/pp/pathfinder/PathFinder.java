package pp.pathfinder;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import android.graphics.Point;

/**
 * A* Pathfinder Algorithm for Movement. 
 * @author PaulPa
 *
 */
public class PathFinder {

	private PriorityQueue<Node> openQueue;
	private LinkedList<Node> closedList;
	private int[][] map;
	private int[] block;

	public PathFinder(int[][] map) {
		this.map = map;
		openQueue = new PriorityQueue<Node>();
		closedList = new LinkedList<Node>();
	}

	public LinkedList<Node> searchPath(Point startPos, Point endPos) {
		Node startNode = new Node(startPos);
		Node endNode = new Node(endPos);
		startNode.costG = 0;
		startNode.costH = startNode.getCostToNode(endNode);
		startNode.parentNode = null;
		openQueue.add(startNode);
		while (!openQueue.isEmpty()) {
			Node currNode = (Node) openQueue.remove();
			closedList.add(currNode);
			if (closedList.contains(endNode)) {
				return closedList;
			}
			for (Node node : currNode.getAdjacentNodes()) {
				if (closedList.contains(node))
					continue;
				if (false) // TODO: Check to see if node is traversable
					continue;
				if (!openQueue.contains(currNode)){
					openQueue.add(node);
					node.parentNode = currNode;
					node.costG = currNode.costG + currNode.getCostToNode(node);
					node.costH = node.getCostToNode(endNode);
				}
				else {
					if (node.costG > (currNode.costG + currNode.getCostToNode(node))) {
						node.costG = currNode.costG + currNode.getCostToNode(node);
					}
				}
			}
		}
		return null;
	}

}
