package graph;

public class IslandGroups {

    public static void main(String[] args) {
//        char grid[][] = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//            };
        char grid[][] = {
                {'1','1','0','0','1'},
                {'1','1','0','0','0'},
                {'0','0','1','1','1'},
                {'1','0','0','1','1'}
        };
        System.err.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        return getTotalConnectedComponents(grid, rows, columns);
    }

    private static int getTotalConnectedComponents(char[][] grid, int rows, int columns) {
        boolean visited[][] = new boolean[rows][columns];
        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    processGrid(grid, visited, i,j,rows,columns);
                }
            }
        }
        return count;
    }

    private static void processGrid(char[][] grid, boolean visited[][], int i, int j, int rows, int columns){
        visited[i][j] = true;
        if(i+1 < rows && grid[i+1][j] == '1' && !visited[i+1][j]){
            processGrid(grid, visited, i+1,j, rows, columns);
        }
        if(j+1 < columns && grid[i][j+1] == '1' && !visited[i][j+1]){
            processGrid(grid, visited, i, j+1, rows, columns);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1' && !visited[i][j-1]){
            processGrid(grid, visited, i, j-1, rows, columns);
        }
        if(i-1 >= 0 && grid[i-1][j] == '1' && !visited[i-1][j]){
            processGrid(grid, visited, i-1, j, rows, columns);
        }
    }
}

class Coordinates{
    int x;
    int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}
