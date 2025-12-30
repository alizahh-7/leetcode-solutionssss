class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length, c = grid[0].length, count = 0;
        
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                if (grid[i+1][j+1] != 5) continue; // center of 3x3 magic square must be 5
                
                boolean[] seen = new boolean[16];
                boolean valid = true;
                
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        int v = grid[x][y];
                        if (v < 1 || v > 9 || seen[v]) {
                            valid = false;
                            break;
                        }
                        seen[v] = true;
                    }
                    if (!valid) break;
                }
                if (!valid) continue;
                
                int s = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                if (grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] != s) continue;
                if (grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] != s) continue;
                
                if (grid[i][j] + grid[i+1][j] + grid[i+2][j] != s) continue;
                if (grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] != s) continue;
                if (grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] != s) continue;
                
                if (grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] != s) continue;
                if (grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] != s) continue;
                
                count++;
            }
        }
        return count;
    }
}
