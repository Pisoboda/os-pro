import java.util.*;
import java.util.Random;

public class createmaze {
    int[][] maze;
    int size;



    public createmaze(int size) {
        maze = new int[size][size];
        this.size = size;
        generate_Maze();
    }



    public int Get_size(){
        return size;
    }


    public void generate_Maze()
    {
        Random rand = new Random();
for (int i = 0; i < maze.length; i++)
{
    for (int j = 0; j < maze[i].length; j++)
    {
        maze[i][j] = rand.nextInt(size);
    }
}
maze[0][0]=0;
maze[size-1][size-1]=0;
    }
   public void print_Maze()
   {
        System.out.println("the intial Maze");
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
   }

   public boolean Issafe(int x, int y)
   {
   return (x>=0 && x<size && y>=0 && y<size && maze[x][y]==0);
   }


}
