import java.util.ArrayList;
import java.util.List;


public class shared_StateOf_RatIn_Maze {
    private boolean[][] VisitedCall;
    private List <Path_Of_Rat_in_Maze> solution;


    public shared_StateOf_RatIn_Maze(int size)
    {
        VisitedCall=new boolean[size][size];
        solution=new ArrayList<>();
    }
    public synchronized void setVisitedTo_cell(int x, int y, boolean value)
    {
        VisitedCall[x][y]=value;

    }

    public synchronized boolean getVisitedTo_cell(int x, int y)
    {
        return VisitedCall[x][y];
    }

    public synchronized void AddSolution(Path_Of_Rat_in_Maze conditions)
    {
        Path_Of_Rat_in_Maze temp=new Path_Of_Rat_in_Maze();
        for (int []position_I: conditions.ThisList())
        {
            temp.addPath(position_I[0],position_I[1]);
        }
        solution.add(temp);
    }

    public synchronized List<Path_Of_Rat_in_Maze> getSolution()
    {
        return solution;
    }


}
