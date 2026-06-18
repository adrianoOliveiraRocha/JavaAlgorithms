package searchalgorithms.aSearch;

import java.util.*;

public class AStar {

    // The main A* method
    public static List<Node> findPath(int[][] grid, Node start, Node goal) {
        // PriorityQueue automatically sorts nodes by fCost (lowest first)
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();

        // Initialize the start node
        start.gCost = 0;
        start.hCost = calculateHeuristic(start, goal);
        start.calculateFCost();
        openSet.add(start);

        while (!openSet.isEmpty()) {
            // Get the node with the lowest fCost
            Node current = openSet.poll();

            // If we reached the goal, reconstruct and return the path
            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            // Move current from open to closed
            closedSet.add(current);

            // Check all 4-directional neighbors (up, down, left, right)
            List<Node> neighbors = getNeighbors(grid, current);
            for (Node neighbor : neighbors) {
                // Skip if neighbor is already evaluated
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                // Calculate the tentative gCost (moving costs 1 step)
                int tentativeGCost = current.gCost + 1;

                // If this new path to neighbor is better (or neighbor not in openSet)
                if (tentativeGCost < neighbor.gCost || !openSet.contains(neighbor)) {
                    // Update neighbor's costs and parent
                    neighbor.parent = current;
                    neighbor.gCost = tentativeGCost;
                    neighbor.hCost = calculateHeuristic(neighbor, goal);
                    neighbor.calculateFCost();

                    // If neighbor is not in openSet, add it
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    // Manhattan Distance Heuristic (perfect for 4-directional grid movement)
    private static int calculateHeuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // Get walkable neighbors (no walls, within grid bounds)
    private static List<Node> getNeighbors(int[][] grid, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = node.x + dx[i];
            int newY = node.y + dy[i];

            // Check bounds and if cell is walkable (grid value == 0 means open)
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 0) {
                neighbors.add(new Node(newX, newY));
            }
        }
        return neighbors;
    }

    // Reconstruct the path by following parent pointers backwards
    private static List<Node> reconstructPath(Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;
        while (current != null) {
            path.add(0, current); // Insert at the beginning
            current = current.parent;
        }
        return path;
    }
}

