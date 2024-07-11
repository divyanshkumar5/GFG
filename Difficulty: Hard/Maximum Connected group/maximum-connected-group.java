//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int MaxConnection(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxConnected = 0;
        int componentId = 2; // Start component IDs from 2 because grid is binary (0,1)
        Map<Integer, Integer> componentSize = new HashMap<>();

        // Step 1: Identify all connected components of 1s and their sizes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, componentId);
                    componentSize.put(componentId, size);
                    maxConnected = Math.max(maxConnected, size);
                    componentId++;
                }
            }
        }

        // Step 2: For each 0 cell, calculate the potential size if it were turned to 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenComponents = new HashSet<>();
                    int potentialSize = 1; // Include the flipped cell
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] > 1) {
                            int id = grid[ni][nj];
                            if (!seenComponents.contains(id)) {
                                potentialSize += componentSize.get(id);
                                seenComponents.add(id);
                            }
                        }
                    }
                    maxConnected = Math.max(maxConnected, potentialSize);
                }
            }
        }

        return maxConnected;
    }

    private int dfs(int[][] grid, int i, int j, int componentId) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        grid[i][j] = componentId;
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];
            size++;
            
            for (int[] dir : directions) {
                int ni = x + dir[0];
                int nj = y + dir[1];
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == 1) {
                    grid[ni][nj] = componentId;
                    stack.push(new int[]{ni, nj});
                }
            }
        }
        
        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1, 0, 0, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {0, 1, 1, 0}
        };
        System.out.println(solution.MaxConnection(grid)); // Output the maximum connected 1s after flipping one 0 to 1
    }
}