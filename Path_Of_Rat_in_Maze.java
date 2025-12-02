import java.util.*;
import java.util.LinkedList;
import java.util.List;


public class Path_Of_Rat_in_Maze {

    private LinkedList<int[]>path;

    public Path_Of_Rat_in_Maze (){
        path=new LinkedList<>();
    }

    public void addPath(int start, int end)
    {
        path.add(new int[]{start,end});
    }

    public void removePath()
    {
        if (!path.isEmpty()){
            path.removeLast();
        }
    }

    public  int size()
    {
        return path.size();
    }

    public List<int[]> ThisList(){
        return path;
    }
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for (int[] i : path)
        {
            str.append("(").append(i[0]).append(",").append(i[1]).append(") ");
        }
        return str.toString();
        }
    }


