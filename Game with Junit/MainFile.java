
import java.util.Scanner;

public class MainFile{

    public static void main(String[] args){
        //    System.out.println(0%3);
        Scanner input=new Scanner(System.in);

        System.out.println("Enter Game Mode...Type 'A' to play vs PC or 'M' for manually 2 users to play vs each other");

        char GameMode = input.next(".").charAt(0);
        while(GameMode != 'A' && GameMode != 'M')
        {
            System.out.println("You Entered an Invalid letter...Please Enter either 'A' or 'M' ");
            GameMode = input.next(".").charAt(0);
        }

        System.out.println("Enter n (the number of rows in the game)... n must be bigger than or equal 1");
        int n= input.nextInt();
        while(n<1)
        {
            System.out.println("Enter n (the number of rows)... n must be bigger than or equal 1 ");
            n= input.nextInt();
        }

        System.out.println("Enter m (the number of columns in the game)... m must be bigger than or equal 1");
        int m= input.nextInt();
        while(m<1)
        {
            System.out.println("Enter m (the number of columns)... m must be bigger than or equal 1 ");
            m= input.nextInt();
        }

        System.out.println("Enter k (the number of symbols required to win the game)... k must be smaller than or equal either n or m");
        int k= input.nextInt();
        while( k>m && k>n)
        {
            System.out.println("k is invalid...Please note that k must be smaller than or equal either n or m");
            k= input.nextInt();
        }
        System.out.println("n is "+n+"\nm is "+m+"\nk is "+k);

        TicTacGame Game= new TicTacGame(n,m,k);
        Game.printTicTac(Game.CellsStates);
        int CalculatedIndex=0;

        while (Game.GetCurrentBoardState() == TicTacGame.BoardState.INPROGRESS)
        {
            Game.NextPlayer();
            System.out.println("Its the Users turn");
            System.out.println("\nOn What Row do you want to play...choose from 0 to " +(n-1));
            int ChosenRow=input.nextInt();

            Game.Set_ChosenRow(ChosenRow);
            System.out.println("\nOn What Column do you want to play...choose from 0 to " +(m-1));
            int ChosenColumn=input.nextInt();
            Game.Set_ChosenColumn(ChosenColumn);

            if(n>=m )
                CalculatedIndex=ChosenRow*m + ChosenColumn; //This is index for single dimentional array
            else //if(n<m)
            {
                if(ChosenRow!=0)
                    CalculatedIndex=ChosenRow*m + ChosenColumn;
                else
                    CalculatedIndex=ChosenColumn;
            }
            //System.out.println(CalculatedIndex);

            Game.play(CalculatedIndex);
            Game.CheckIfWinorDraw();
            Game.printTicTac(Game.CellsStates);

            if(GameMode=='A')
            {
                Game.NextPlayer();
                Game.AutomaticPlay();
                Game.CheckIfWinorDraw();
                Game.printTicTac(Game.CellsStates);
            }

        }
        Game.Set_dummyboolean(true); // Stops replaying messages of winning or losing or drawing after ending game
        System.out.println("\nAt What point in the game do you want to replay from in the game?...You can choose from 1st point up to "+Game.Get_NTurns()+"th point");
        System.out.println("Please Enter an Integer from 1 to "+Game.Get_NTurns());
        int Point1=input.nextInt();
        while (Point1<1 || Point1>Game.Get_NTurns())
        {
            System.out.println("Invalid input...Please Try Again with a value bigger than or equal 1 and smaller than or equal "+Game.Get_NTurns());
            Point1=input.nextInt();
        }
        System.out.println("\nAt What point in the game do you want to replay to in the game?...You can choose from "+Point1+"th point up to "+Game.Get_NTurns()+"th point");
        System.out.println("Please Enter an Integer from "+Point1 +" to "+Game.Get_NTurns());
        int Point2=input.nextInt();
        while (Point2<Point1 || Point2>Game.Get_NTurns())
        {
            System.out.println("Invalid input...Please Try Again with a value bigger than or equal "+Point1+" and smaller than or equal "+Game.Get_NTurns());
            Point2=input.nextInt();
        }
        Game.Replay(Point1,Point2);


    }
}