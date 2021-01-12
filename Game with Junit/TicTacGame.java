import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacGame {
    enum CellState {O, X,Empty}
    enum BoardState {INPROGRESS,DRAW, WIN_X,WIN_O}

    private int n;//stores number of rows of board
    private int m;//stores number of columns of board
    private int k;//stores number of symbols needed to win the game(either horizontolly, vertically, diaganolly or anti diaganolly)
    public CellState[] CellsStates; //Has cell of each state
    private BoardState CurrentBoardState; // stores current Board State
    private int NTurnsPlayed; // total number of turns played, gets updated every time a player plays
    private int PlayerNumber; //Either player 0 or player 1
    private ArrayList<CellState[]> TicTacToeCellsState; //ArrayList that contains the state of the TicTacToe object every turn
    private int Chosen_Row; //the value of row input by the user to play in
    private int Chosen_Column; //the value of column input by the user to play in
    private boolean First_AI_move;
    private int IndexInCaseNoOpportunity;
    private boolean dummyboolean;


    public TicTacGame () {
        this.n=3;
        this.m=3;
        this.k=3;
        CurrentBoardState=BoardState.INPROGRESS;
        PlayerNumber=1; // Initializing PlayerVariable
        CellsStates= new CellState[n*m];
        for(int i=0;i<(n*m); i++)
            CellsStates[i]=CellState.Empty; // initialize all cells to empty at the beginning
        TicTacToeCellsState = new ArrayList<CellState[]>();
        First_AI_move=true;
        IndexInCaseNoOpportunity=0;
        dummyboolean=false;
    }
    public TicTacGame (int n,int m) {
        this.n=n;
        this.m=m;
        this.k=3;
        CurrentBoardState=BoardState.INPROGRESS;
        PlayerNumber=1; // Initializing PlayerVariable
        CellsStates= new CellState[n*m];
        for(int i=0;i<(n*m); i++)
            CellsStates[i]=CellState.Empty; // initialize all cells to empty at the beginning
        TicTacToeCellsState = new ArrayList<CellState[]>();
        First_AI_move=true;
        IndexInCaseNoOpportunity=0;
        dummyboolean=false;
    }

    public TicTacGame (int n,int m,int k) {
        this.n=n;
        this.m=m;
        this.k=k;
        CurrentBoardState=BoardState.INPROGRESS;
        PlayerNumber=1; // Initializing PlayerVariable
        CellsStates= new CellState[n*m];
        for(int i=0;i<(n*m); i++)
            CellsStates[i]=CellState.Empty; // initialize all cells to empty at the beginning
        TicTacToeCellsState = new ArrayList<CellState[]>();
        First_AI_move=true;
        IndexInCaseNoOpportunity=0;
        dummyboolean=false;
    }

    public void NextPlayer(){ //get which player is next to make a turn

        //change return type as you want
        if (PlayerNumber==0) // if player 0, change to player 1
        {
            PlayerNumber=1;
        }
        else if (PlayerNumber==1)// if player 1, change to player 0
            PlayerNumber=0;
    }

    public void play(int index){ //sets the state of a given cell to either X, or O.
        //Also make sure to validate that if there was already data in the cell, dont overwrite it
        Scanner input=new Scanner(System.in);

        if(PlayerNumber==0)
        {
            while(index>=(n*m))
            {   System.out.println("Invalid either rows or columns...Please re-enter rows and columns");

                System.out.println("Enter valid row...Choose an integer from 0 to "+ (n-1));
                Chosen_Row=input.nextInt();
                while(Chosen_Row>=n)
                {
                    System.out.println("\nInvalid row number...choose from 0 to " +(n-1));
                    Chosen_Row=input.nextInt();
                }

                System.out.println("Enter valid column...Choose an integer from 0 to "+(m-1));
                Chosen_Column=input.nextInt();
                while(Chosen_Column>=m)
                {
                    System.out.println("\nInvalid Column number...choose from 0 to " +(m-1));
                    Chosen_Column=input.nextInt();
                }
                if(n>=m )
                    index=Chosen_Row*m + Chosen_Column; //This is index for single dimentional array
                else //if(n<m)
                {
                    if(Chosen_Row!=0)
                        index=Chosen_Row*m + Chosen_Column;
                    else
                        index=Chosen_Column;
                }
            }
            while(CellsStates[index]!=CellState.Empty)
            {

                System.out.println("Invalid Cell as there is already a symbol in this cell...Please re-input valid row and columns");
                System.out.println("Enter another row...Choose an integer from 0 to "+(n-1));
                Chosen_Row=input.nextInt();
                while(Chosen_Row>=n)
                {
                    System.out.println("\nInvalid row number...choose from 0 to " +(n-1));
                    Chosen_Row=input.nextInt();
                }
                System.out.println("Enter another column...Choose an integer from 0 to "+(m-1));
                Chosen_Column=input.nextInt();
                while(Chosen_Column>=m)
                {
                    System.out.println("\nInvalid Column number...choose from 0 to " +(m-1));
                    Chosen_Column=input.nextInt();
                }
                if(n>=m )
                    index=Chosen_Row*m + Chosen_Column; //This is index for single dimentional array
                else //if(n<m)
                {
                    if(Chosen_Row!=0)
                        index=Chosen_Row*m + Chosen_Column;
                    else
                        index=Chosen_Column;
                }
                if(CellsStates[index]==CellState.Empty)
                    break;

            }
            CellsStates[index]=CellState.X;
        }


        else if (PlayerNumber==1)
        {

            while(index>=(n*m))
            {   System.out.println("Invalid either rows or columns...Please re-enter rows and columns");

                System.out.println("Enter valid row...Choose an integer from 0 to "+ (n-1));
                Chosen_Row=input.nextInt();
                while(Chosen_Row>=n)
                {
                    System.out.println("\nInvalid row number...choose from 0 to " +(n-1));
                    Chosen_Row=input.nextInt();
                }

                System.out.println("Enter valid column...Choose an integer from 0 to "+(m-1));
                Chosen_Column=input.nextInt();
                while(Chosen_Column>=m)
                {
                    System.out.println("\nInvalid Column number...choose from 0 to " +(m-1));
                    Chosen_Column=input.nextInt();
                }
                if(n>=m )
                    index=Chosen_Row*m + Chosen_Column; //This is index for single dimentional array
                else //if(n<m)
                {
                    if(Chosen_Row!=0)
                        index=Chosen_Row*m + Chosen_Column;
                    else
                        index=Chosen_Column;
                }
            }
            while(CellsStates[index]!=CellState.Empty)
            {

                System.out.println("Invalid Cell as there is already a symbol in this cell...Please re-input valid row and columns");
                System.out.println("Enter another row...Choose an integer from 0 to "+(n-1));
                Chosen_Row=input.nextInt();
                while(Chosen_Row>=n)
                {
                    System.out.println("\nInvalid row number...choose from 0 to " +(n-1));
                    Chosen_Row=input.nextInt();
                }
                System.out.println("Enter another column...Choose an integer from 0 to "+(m-1));
                Chosen_Column=input.nextInt();
                while(Chosen_Column>=m)
                {
                    System.out.println("\nInvalid Column number...choose from 0 to " +(m-1));
                    Chosen_Column=input.nextInt();
                }
                if(n>=m )
                    index=Chosen_Row*m + Chosen_Column; //This is index for single dimentional array
                else //if(n<m)
                {
                    if(Chosen_Row!=0)
                        index=Chosen_Row*m + Chosen_Column;
                    else
                        index=Chosen_Column;
                }
                if(CellsStates[index]==CellState.Empty)
                    break;


            }
            CellsStates[index]=CellState.O;
        }

        NTurnsPlayed++;//Increment number of turns played
        SaveGameState();//saves the state of each tic tac toe states array to another ArrayList be used later for replay if requested by the user

    }

    public void AutomaticPlay(){
        boolean BlockOponent; // Try Blocing oponent,
        Random rand = new Random();
        if(CurrentBoardState==BoardState.INPROGRESS)
        {
            System.out.println("It is the PC's turn");
            if(First_AI_move==true)
            {
                int rand_index = rand.nextInt(n*m); // find a random number within array size
                while(CellsStates[rand_index]!=CellState.Empty) // if random number conflicts with the player's move
                {
                    rand_index = rand.nextInt(n*m);// generate a new random number
                }
                CellsStates[rand_index]=CellState.O;
                First_AI_move=false; // First_AI_move changed to fals
                //System.out.println("FIRST MOVE FOR PC AT INDEX = "+rand_index);
            }

            else{
                if(AI_Find_Opportunity()==true)
                {
                    //System.out.println("FOUND OPPORTUNITY TO WIN!!!"); //Uncomment this System.out Line to debug the Finding Opportunity Feature
                }
                else //AI_Find_Opportunity())==true
                {
                    BlockOponent=AI_BlockOponent();
                    if (BlockOponent==true)
                    {
                        // System.out.println("FOUND WAY TO BLOCK OPONENT!!!"); //Uncomment this System.out Line  to debug the BlockOponent Feature
                    }
                    else
                    {
                        AI_Play_Move();//AI WILL PLAY THE MOVE AS NO BLOCKOPENT NOR WINNING OPPORTUNITY WAS FOUND
                        
                    }
                }
            }
            CheckIfWinorDraw();
            NTurnsPlayed++;
            if(NTurnsPlayed==(n*m) && CurrentBoardState!=BoardState.WIN_X && CurrentBoardState!=BoardState.WIN_O)
            {
                SetCurrentBoardState(BoardState.DRAW);
            }
            SaveGameState();
        }
    }

    public boolean AI_Find_Opportunity() // finds a winning oportunity
    {
        int index=0;
        int IndexTemp=0; // a duplicate of index and is used later
        boolean flag=false;
        int O_Counter=0;
        boolean checkifwinOpp=false;
        boolean WinOpportunity=false;



        //  Try finding a winning Opportunity vertically if detected
        for (int i=0; i<(n*m);i++) // for each coulumn
        {    index=i;
            IndexTemp=index;

            if( (index<(n*m) ))
                for(int j=0;j<k;j++)
                {
                    if( !(index<(n*m)) )
                        break;

                    if(CellsStates[index]==CellState.O)
                    {
                        O_Counter++;
                        IndexInCaseNoOpportunity=index;
                    }
                    if(O_Counter==k-1)
                    {
                        int symbolindex=IndexTemp;
                        flag=false;
                        for(int z=0;z<k;z++) // a for loop that breaks that goes through the cells with sybmols and if detects an X, it breaks to give chance to detect other vertical scenarios of winning
                        {
                            if(symbolindex>n*m-1)// if symbolindex exceeds array size
                                break;
                            if(CellsStates[symbolindex]==CellState.X )
                                flag=true;
                            symbolindex=symbolindex+m;
                        }
                        if(flag)
                        {
                            //flag becomes true so break
                            break;
                        }

                        //if we reached this line, this means that we didnt break in the above for loop
                        WinOpportunity=true;
                        break;
                    }
                    index=index+m;
                }
            if(WinOpportunity==true)
                break;
            O_Counter=0;//Reset O_Counter
        }

        if(WinOpportunity==true)
        {

            for(int z=0;z<k;z++)
            {
                if( !(IndexTemp<(n*m)) )
                    break;
                if(CellsStates[IndexTemp]==CellState.Empty)
                {
                    //Computer should play at this IndexTemp to win
                    CellsStates[IndexTemp]=CellState.O;
                    checkifwinOpp=true;
                    return checkifwinOpp;

                }
                IndexTemp=IndexTemp+m;
            }
        }
        return checkifwinOpp; //return checkifwinOpp
    }

    public void AI_Play_Move() // If we entered this function, this means No win opportunity nor Blocking opportunity was found
    {

        //Random rand = new Random();

        int CalculatedIndex=IndexInCaseNoOpportunity+2*m; // we add 2 cells down to Last O
        if(CalculatedIndex>=n*m)// if Calculated Index was bigger than array size
        {
            CalculatedIndex=m-1;// Assign Calculated Index to right upper corner
            //CalculatedIndex is bigger than array size so CalulatedIndex is assigned to m-1
        }
        // then if it was not empty go into while loop
        while(CellsStates[CalculatedIndex]!=CellState.Empty && CurrentBoardState!=BoardState.DRAW )
        {
            // add 1 more cell down if the index was not free
            CalculatedIndex=CalculatedIndex+1*m;

            if(CalculatedIndex>=n*m)// if Calculated Index was bigger than array size
            	CalculatedIndex=0; //Reset Index to beginning of array
            else
            {   //System.out.println("CalculatedIndex is bigger than array size so CalulatedIndex is assigned to some random number");
                //CalculatedIndex=rand.nextInt(n*m);
                if(CellsStates[CalculatedIndex]!=CellState.Empty) // calculated index had a symbol in it
                    CalculatedIndex=0; // initalize calculatedindex to beginning of board
                while(CellsStates[CalculatedIndex]!=CellState.Empty && CurrentBoardState!=BoardState.DRAW ) // while there are no empty cells and game still didnt draw
                {
                    //CalculatedIndex=rand.nextInt(n*m);// Assign Calculated Index to a random number
                    CalculatedIndex=CalculatedIndex+1; // Move 1 cell starting from calculatingindex=0 till finding an empty cell
                }
            }
        }

        CellsStates[CalculatedIndex]=CellState.O; // Assign O to calculated Symbol

    }



    public boolean AI_BlockOponent()
    {   boolean checkifwinOpp=false;
        int index=0;
        int IndexTemp=0; // a duplicate of index and is used later
        boolean flag=false;
        int X_Counter=0;
        boolean winOppForenemy=false;



        //  Block enemy(user) vertically if detected
        for (int i=0; i<(n*m);i++) // for each coulumn
        {    index=i;
            IndexTemp=index;

            for(int j=0;j<k;j++)
            {
                if( !(index<(n*m)) )
                    break;

                if(CellsStates[index]==CellState.X)
                {
                    X_Counter++;

                }
                if(X_Counter==k-1)
                {
                    int symbolindex=IndexTemp;
                    flag=false;
                    for(int z=0;z<k;z++) // a for loop that breaks that goes through the cells with sybmols and if detects an O, breaks to give chance to detect other cases,where oponent can blocked
                    {
                        if(symbolindex>n*m-1)// if symbolindex exceeds array size
                            break;
                        if(CellsStates[symbolindex]==CellState.O )
                            flag=true;
                        symbolindex=symbolindex+m;
                    }
                    if(flag)
                    {

                        break;//flag is true so break and dont make winoppforenemy become true
                    }

                    //if we reached this line, this means that we didnt break in the above for loop, which if detects an O, we should break
                    winOppForenemy=true;
                    break; //winoppforenemy is true so break
                }
                index=index+m;   //move 1 cell down
            }

            if(winOppForenemy==true)
            {
                if( !(IndexTemp<(n*m)) )
                    break;
                for(int z=0;z<k;z++)
                {
                    if( !(IndexTemp<(n*m)) )
                        break;
                    if(CellsStates[IndexTemp]==CellState.Empty)
                    {
                        CellsStates[IndexTemp]=CellState.O;
                        checkifwinOpp=true;
                        return checkifwinOpp;
                    }
                    IndexTemp=IndexTemp+m;
                }
                break;
            }

            X_Counter=0;
        }


        if(winOppForenemy==false) // if still no block opportunity detected
        {
            //Check Horizontol
            index=0; //reset index
            IndexTemp=0;//reset IndexTemp
            X_Counter=0; //reset X_Counter
            flag=false;//reset flag

            for (int i=0; i<(n*m);i=i+1) // for each coulumn
            {   index=i;
                IndexTemp=index;


                for(int j=0;j<k;j++)
                {
                    if(!(index<(n*m)))
                    {

                        break;
                    }

                    if(CellsStates[index]==CellState.X )
                    {
                        X_Counter++;

                    }

                    if(X_Counter==k-1)
                    {   //IF X_Counter ==k-1
                        //One X is left for winning
                        //
                        
                        int X=IndexTemp+X_Counter; //Note: X_Counter equals k-1   //This is index for X if reaching right cell of row

                        //System.out.println("X is = "+ X);

                        if( (index-X_Counter)<0)
                        {
                            IndexTemp=index+1;
                            winOppForenemy=true;
                            break;

                        }

                        else if(X%m==0) // if reached right of row
                        {
                            winOppForenemy=false;
                        }
                        else if(X%m !=0) //if not right of row
                        {
                            int symbolindex=IndexTemp;
                            flag=false;
                            for(int z=0;z<k;z++) // a for loop that breaks that goes through the cells with sybmols and if detects an O, breaks to give chance to detect other cases,where oponent can blocked
                            {
                                if(symbolindex>n*m-1)// if symbolindex exceeds array size
                                    break;
                                if(CellsStates[symbolindex]==CellState.O )
                                    flag=true;
                                symbolindex=symbolindex+1;
                            }
                            if(flag)
                            {
                                break;
                            }

                            //if we reached this line, this means that we didnt break in the above for loop, which if detects an O, we should break

                            if((IndexTemp+1)%m==0) // If reach new row, Dont block oponent (because wrong cell within the game)
                            {
                                winOppForenemy=false;
                            }
                            else{
                                //IndexTemp=IndexTemp;
                                winOppForenemy=true;
                                break;
                            }
                        }

                    }

                    index=index+1;
                }
                X_Counter=0; //reset for new row
                if(winOppForenemy==true)
                {
                    break;
                }
            }

            if(winOppForenemy==true) // if true, re go over the row to see which cell was the empty one and fill it to block the enemy from playing in it and winning
            {

                for(int z=0;z<k;z++)
                {


                    if(CellsStates[IndexTemp]==CellState.Empty )
                    {
                        //System.out.println("Computer should play at index = "+IndexTemp+ " to block the enemy");
                        CellsStates[IndexTemp]=CellState.O;
                        checkifwinOpp=true;
                        return checkifwinOpp;
                    }
                    IndexTemp=IndexTemp+1;
                }


            }

        }

        //check diagonal
        if(winOppForenemy==false)// if still no block opportunity detected
        {

            flag=false;
            index=0; //reset index
            X_Counter=0; //reset X_Counter
            for (int i=0; i<(n*m);i++) // for each coulumn
            {   index=i;
                IndexTemp=index;


                for(int j=0;j<k;j++)
                {
                    if(!(index<(n*m)))
                        break;


                    if(CellsStates[index]==CellState.X)
                    {
                        X_Counter++;
                    }


                    if(X_Counter==k-1) // if 1 X left to win
                    {
                        int X= IndexTemp+X_Counter*(m+1); // Note : X_Counter is equal to (k-1) , which is constant throughout the program
                        

                        if(X%m!=0)
                        {
                            int symbolindex=IndexTemp;
                            flag=false;
                            for(int z=0;z<k;z++) // a for loop that breaks that goes through the cells with sybmols and if detects an O, breaks to give chance to detect other cases,where oponent can blocked
                            {
                                if(symbolindex>n*m-1)// if symbolindex exceeds array size
                                    break;
                                if(CellsStates[symbolindex]==CellState.O )
                                    flag=true;
                                symbolindex=symbolindex+m+1;
                            }

                            if(flag)

                            {

                                break;
                            }
                            //if we reached this line, this means that we didnt break in the above for loop, which if detects an O, we should break
                            winOppForenemy=true;

                            //IndexTemp=IndexTemp;
                            if(IndexTemp<0) // If reached beginning of board
                            {
                                IndexTemp=index-m -1;
                            }
                            break;

                        }
                        else
                        {
                            winOppForenemy=false;
                            
                        }
                    }

                    if(winOppForenemy==true)
                        break;

                    index=index+m+1; // Move 1 cell down diagianolly
                }


                if(winOppForenemy==true)
                {
                    break;
                }
                X_Counter=0; //Reseting X_Counter for new index
            }

            if(winOppForenemy==true)
            {
                for(int z=0;z<k;z++)
                {   if( !(IndexTemp<(n*m)) )
                    break;


                    if(CellsStates[IndexTemp]==CellState.Empty )
                    {
                        CellsStates[IndexTemp]=CellState.O;
                        checkifwinOpp=true;
                        return checkifwinOpp;

                    }
                    IndexTemp=IndexTemp+m+1;
                }


            }

        }

        if(winOppForenemy==false) // if still no block opportunity detected
        {
            //check anti-diagonal
            index=0;//reset index
            IndexTemp=0;
            X_Counter=0; //reset X_Counter
            winOppForenemy=false;
            flag=false;

            for (int i=0; i<(n*m);i++) // for each coulumn
            {   index=i;
                IndexTemp=index;


                for(int j=0;j<k;j++)
                {
                    if(!(index<(n*m)))
                        break;

                    if(CellsStates[index]==CellState.X)
                    {
                        X_Counter++;
                    }


                    if(X_Counter==k-1)
                    {
                        if(IndexTemp%m==0)//if reached very left of board
                        {
                            winOppForenemy=false;
                        }

                        else  if (IndexTemp%m!=0)
                        {   int X=IndexTemp+X_Counter*(m-1);//start with (k-1)th or X_Counter cell  (homa equal ba3d keda keda) because in the kth cell if it is (X+1%m==0),
                            //                          this means that we reached the very right of the table

                            if(CellsStates[IndexTemp]==CellState.O )
                                break;

                            else if((X+1)%m==0)
                            {
                                winOppForenemy=false;  // because this means the computer will play on wrong place (at the same row)

                            }

                            else{//If X was detected
                                int symbolindex=IndexTemp;
                                flag=false;
                                for(int z=0;z<k;z++) // a for loop that breaks that goes through the cells with sybmols and if detects an O, breaks to give chance to detect other cases,where oponent can blocked
                                {
                                    if(symbolindex>n*m-1)// if symbolindex exceeds array size
                                        break;
                                    if(CellsStates[symbolindex]==CellState.O )
                                        flag=true;
                                    symbolindex=symbolindex+m-1;
                                }
                                if(flag)
                                    break;

                                //if we reached this line, this means that we didnt break in the above for loop, which if detects an O, we should break
                                winOppForenemy=true;
                                //IndexTemp=IndexTemp;
                                break;
                            }
                        }
                    }


                    if(winOppForenemy==true)
                    {
                        
                        break;
                    }
                    index=index+m-1;
                }

                if(winOppForenemy==true)
                {
                    
                    break;
                }
                X_Counter=0;//reset for new row

            }


            if(winOppForenemy==true)
            {

                for(int z=0;z<k;z++)
                {
                    if( !(IndexTemp<(n*m)) )
                        break;

                    if(CellsStates[IndexTemp]==CellState.Empty )
                    {
                        //System.out.println("Computer should play at index = "+IndexTemp+ " to block the enemy");
                        CellsStates[IndexTemp]=CellState.O;
                        checkifwinOpp=true;
                        return checkifwinOpp;

                    }
                    IndexTemp=IndexTemp+m-1; // Move 1 cell down Anti-diagonally

                }
            }
        }

        return checkifwinOpp;
    }
    public void SaveGameState(){
        CellState[] arr = new CellState[CellsStates.length];
        arr=CellsStates.clone();
        TicTacToeCellsState.add(arr);
        //printTicTac(TicTacToeCellsState.get(0));
    }

    public void Replay(int Point1,int Point2){
        for(int i=Point1-1;i<=Point2-1;i++)
        {
            System.out.println("This is point "+(i+1));
            printTicTac(TicTacToeCellsState.get(i));
        }
        //printTicTac(TicTacToeCellsState.get(0));

    }

    public void printTicTac( CellState[] TicTacToeState){
        System.out.println("############\n");

        for(int i=0;i<TicTacToeState.length;i++)
        {

            if(i%this.m==0 && i!=0)
            {   //System.out.println("i%this.n = "+ i%this.n);
                System.out.printf("\n");
                for (int z=0;z<this.m;z++)
                    System.out.printf("----");
                System.out.printf("\n");
                //System.out.printf("\n-----------\n");
            }

            if(i%this.m ==(this.m-1))
            {
                if(TicTacToeState[i]==CellState.Empty)
                    System.out.printf("   ");
                else if(TicTacToeState[i]==CellState.X)
                    System.out.printf(" X ");
                else if(TicTacToeState[i]==CellState.O)
                    System.out.printf(" O ");
            }
            else{
                if(TicTacToeState[i]==CellState.Empty)
                    System.out.printf("   |");
                else if(TicTacToeState[i]==CellState.X)
                    System.out.printf(" X |");
                else if(TicTacToeState[i]==CellState.O)
                    System.out.printf(" O |");
            }

        }
        System.out.printf("\n\n############\n");
        if (dummyboolean==false) // while didnt reach stage of replaying
        {
            if(GetCurrentBoardState()==BoardState.WIN_X)
                System.out.printf("\n** X has Won the game... Congratulations! **\n");
            else if(GetCurrentBoardState()==BoardState.WIN_O)
                System.out.printf("\n** O has Won the game... Congratulations! **\n");
            else if(GetCurrentBoardState()==BoardState.DRAW)
                System.out.printf("\n** It is a DRAW! **\n");

        }

    }

    public void CheckIfWinorDraw(){ //checks for game state every turn and changes it if winning or drawing occurs
        int X_Counter=0;
        int O_Counter=0;

        int index=0;

        //check vertical
        for (int i=0; i<(n*m);i++) // for each coulumn
        {   index=i;

            if((index) <(n*m))
            {for(int j=0;j<k;j++)
            {
                if(!(index<(n*m)))
                    break;

                if(CellsStates[index]==CellState.X)
                {
                    X_Counter++;


                }
                else
                    X_Counter=0; // reset if no X was found vertical

                if(CellsStates[index]==CellState.O)
                {
                    O_Counter++;

                }
                else
                    O_Counter=0; // reset if no X was found vertical
                if(X_Counter==k)
                {

                    SetCurrentBoardState(BoardState.WIN_X);
                    break;
                }
                else if(O_Counter==k)
                {

                    SetCurrentBoardState(BoardState.WIN_O);
                    break;
                }

                index=index+m;

            }
            }
            X_Counter=0;//reset for new row
            O_Counter=0;
            if(CurrentBoardState!= (BoardState.INPROGRESS)) //if board state became no longerin progress (either players won or drew)
                break;

        }


        //check horizontol
        index=0; //reset index
        X_Counter=0; //reset X_Counter
        O_Counter=0;
        if(CurrentBoardState==BoardState.INPROGRESS)
        {
            for (int i=0; i<(n*m);i=i+m) // for each coulumn
            {    index=i;


                if((index) <(n*m))
                {for(int j=0;j<m;j++)
                {
                    if(!(index<(n*m)))
                        break;

                    if(CellsStates[index]==CellState.X )
                    {
                        X_Counter++;

                    }
                    else
                        X_Counter=0; // reset if no X was found vertical

                    if(CellsStates[index]==CellState.O )
                    {
                        O_Counter++;

                    }
                    else
                        O_Counter=0; // reset if no X was found vertical
                    if(X_Counter==k)
                    {
                        //X has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_X);
                        break;
                    }
                    if(O_Counter==k)
                    {
                        //O has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_O);
                        break;
                    }
                    index=index+1;
                }

                }
                X_Counter=0;//reset for new row
                O_Counter=0;
                if(CurrentBoardState!= (BoardState.INPROGRESS))
                    break;

            }
        }

        if(CurrentBoardState== (BoardState.INPROGRESS))
        {
            //check diagonal
            index=0; //reset index
            X_Counter=0; //reset X_Counter
            O_Counter=0;
            for (int i=0; i<(n*m);i++) // for each coulumn
            {   index=i;

                if((index) <(n*m))
                {for(int j=0;j<k;j++)
                {
                    if(!(index<(n*m)))
                        break;

                    if(CellsStates[index]==CellState.X)
                    {
                        X_Counter++;


                    }
                    else
                        X_Counter=0; // reset if no X was found vertical

                    if(CellsStates[index]==CellState.O)
                    {
                        O_Counter++;

                    }
                    else
                        O_Counter=0; // reset if no X was found vertical



                    if(X_Counter==k)
                    {
                        //X has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_X);
                        break;
                    }
                    if(O_Counter==k)
                    {
                        //O has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_O);
                        break;
                    }
                    if((index+1)%m==0) //if reached very right of board
                    {
                        X_Counter=0;
                        O_Counter=0;
                    }
                    index=index+m+1;

                }
                }
                X_Counter=0;//reset for new row
                O_Counter=0;
                if(CurrentBoardState!= BoardState.INPROGRESS)
                    break;

            }

        }
        if(CurrentBoardState==BoardState.INPROGRESS)
        {
            //Check Anti-diagonal
            index=0;//reset index
            X_Counter=0; //reset X_Counter
            O_Counter=0;

            for (int i=0; i<(n*m);i++) // for each coulumn
            {   index=i;

                if((index) <(n*m))
                {for(int j=0;j<k;j++)
                {
                    if(!(index<(n*m)))
                        break;

                    if(CellsStates[index]==CellState.X)
                    {
                        X_Counter++;

                    }
                    else
                        X_Counter=0; // reset if no X was found vertical

                    if(CellsStates[index]==CellState.O)
                    {
                        O_Counter++;

                    }
                    else
                        O_Counter=0; // reset if no X was found vertical



                    if(X_Counter==k)
                    {
                        //]X has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_X);
                        break;
                    }
                    if(O_Counter==k)
                    {
                        //O has WON... Now breaking out of loop
                        SetCurrentBoardState(BoardState.WIN_O);
                        break;
                    }
                    if(index%m==0) //if reached the very left of board
                    {
                        X_Counter=0;
                        O_Counter=0;
                    }
                    index=index+m-1;

                }
                }
                X_Counter=0;//reset for new row
                O_Counter=0;
                if(CurrentBoardState!=BoardState.INPROGRESS)
                    break;

            }
        }

        if(NTurnsPlayed==(this.n*this.m) && CurrentBoardState!=BoardState.WIN_X && CurrentBoardState!=BoardState.WIN_O)
            SetCurrentBoardState(BoardState.DRAW);
    }

    public void Set_dummyboolean(boolean x)
    {
        dummyboolean=x;
    }

    public boolean Get_dummyboolean()
    {
        return dummyboolean;
    }

    public CellState[] Get_CellsStates()
    {
        return CellsStates;
    }

    public void Set_ChosenRow(int n){ // updates the row ,where the player chooses to play in the X or the O
        Chosen_Row=n;
    }

    public void Set_ChosenColumn(int m){ // updates the Column ,where the player chooses to play in the X or the O
        Chosen_Column=m;
    }


    public void Set_n(int n)
    {
        this.n=n;
    }

    public void Set_m(int m)
    {
        this.m=m;
    }

    public void Set_k(int k)
    {
        this.k=k;
    }

    public int Get_n()
    {
        return n;
    }

    public int Get_m()
    {
        return m;
    }

    public int Get_k()
    {
        return k;
    }

    public int Get_Chosen_Row()
    {
        return Chosen_Row;
    }

    public int Get_Chosen_Column()
    {
        return Chosen_Column;
    }

    public void Set_NTurns(int x)
    {
        NTurnsPlayed=x;
    }

    public int Get_NTurns(){
        return NTurnsPlayed;
    }
    public BoardState GetCurrentBoardState(){

        return CurrentBoardState;
    }
    public void  SetCurrentBoardState(BoardState x){

        this.CurrentBoardState=x;
    }

    public void Set_PlayerNumber(int x){
        PlayerNumber=x;
    }
    public int Get_PlayerNumber(){
        return PlayerNumber;
    }
}
