import java.util.*;
import java.util.Random;

public class createmaze {
    int[][] cell;
    int size;



    public createmaze(int size) {
        cell = new int[size][size];
        this.size = size;
        generate_Maze();
    }



    public int Get_size(){
        return size;
    }

    public  int[][] get_maze(){
        return cell;
    }

    public void generate_Maze()
    {
        Random rand = new Random();
for (int i = 0; i < cell.length; i++)
{
    for (int j = 0; j < cell[i].length; j++)
    {
        cell[i][j] = rand.nextInt(size);
    }
}
cell[0][0]=0;
cell[size-1][size-1]=0;
    }
   public void print_Maze()
   {
        System.out.println("the intial Maze");
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[i].length; j++){
                System.out.print(cell[i][j]+" ");
            }
            System.out.println();
        }
   }

   public boolean Issafe(int x, int y)
   {
   return (x>=0 && x<size && y>=0 && y<size && cell[x][y]==0);
   }

}
