package searchalgorithms.aSearch;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Grid: 0 = walkable, 1 = wall (obstacle)
        int[][] grid = {
            {0, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0}
        };

        Node start = new Node(0, 0); // Top-left
        Node goal = new Node(4, 5);  // Bottom-right

        List<Node> path = AStar.findPath(grid, start, goal);

        if (path.isEmpty()) {
            System.out.println("No path found!");
        } else {
            System.out.println("Path found! Steps: " + (path.size() - 1));
            System.out.println("Path: " + path);

            // Visualize the path on the grid
            printGridWithPath(grid, path);
        }
    }

    // Helper to visualize the grid and the path
    private static void printGridWithPath(int[][] grid, List<Node> path) {
        // Create a copy of the grid
        char[][] display = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                display[i][j] = grid[i][j] == 1 ? '█' : '·'; // Wall or empty
            }
        }

        // Mark the path with 'P' (except start and goal)
        for (Node node : path) {
            display[node.x][node.y] = 'P';
        }
        // Override start and goal
        display[path.get(0).x][path.get(0).y] = 'S';
        display[path.get(path.size() - 1).x][path.get(path.size() - 1).y] = 'G';

        // Print the grid
        System.out.println("\nVisual Grid:");
        for (char[] row : display) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


