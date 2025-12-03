import java.util.concurrent.ExecutorService;


public class Algo_Solver_Maze {
private  createmaze Maze;
private shared_StateOf_RatIn_Maze State;

public void Algo_Solver_Maze(createmaze Maze, shared_StateOf_RatIn_Maze State)
{
this.Maze=Maze;
this.State=State;

}



    public void solve_InDFS(Rat_in_maze Rat,ExecutorService temp_service)
    {

        dfs_solver(Rat.getRow(),Rat.getCol(),Rat,temp_service);

    }


    public boolean dfs_solver(int row, int col, Rat_in_maze Rat, ExecutorService temp_service ) {
        if (!Maze.Issafe(row, col))
        {
            return false;
        }

        synchronized (State)
        {
            if (State.getVisitedTo_cell(row, col))
            {
                return false;

            }
            State.setVisitedTo_cell(row, col, true);
        }


        Rat.move(row, col);



        if (row == Maze.Get_size() - 1 && col == Maze.Get_size() - 1) {
            State.AddSolution(Rat.getPath());
            return true;
        }
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, -1, 0, 1};

        boolean Ftemp_dir=true;


        for (int i = 0; i < 4; i++)
        {
            int NewRow = row + drow[i];
            int NewCol = col + dcol[i];
           if(!Maze.Issafe(NewRow,NewCol))
           {
               continue;
           }

           if (Ftemp_dir)
           {
           dfs_solver(NewRow,NewCol,Rat,temp_service);
           Ftemp_dir=false;
           }

           else {
               Rat_in_maze NRat=new Rat_in_maze(NewRow,NewCol);

               for (int []Position_i: Rat.getPath().ThisList())
               {
                NRat.getPath().addPath(Position_i[0],Position_i[1]);
               }

               temp_service.submit(()->dfs_solver(NewRow,NewCol,NRat,temp_service));
           }

        }
        Rat.getPath().removePath();
        return false;
    }

}
