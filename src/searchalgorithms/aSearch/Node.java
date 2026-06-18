package searchalgorithms.aSearch;

import java.util.Objects;

public class Node implements Comparable<Node> {
    public int x, y;          // Position on the grid
    public int gCost;         // Cost from Start to this node
    public int hCost;         // Heuristic cost from this node to Goal (Manhattan)
    public int fCost;         // Total cost: gCost + hCost
    public Node parent;       // Which node did we come from?

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.gCost = Integer.MAX_VALUE; // Start with "infinite" cost
        this.hCost = 0;
        this.fCost = Integer.MAX_VALUE;
        this.parent = null;
    }

    // Calculate fCost whenever g or h changes
    public void calculateFCost() {
        this.fCost = this.gCost + this.hCost;
    }

    // This allows the PriorityQueue to sort Nodes by fCost (lowest first)
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.fCost, other.fCost);
    }

    // Important for checking if two nodes are the same cell
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


