import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacGameTest {



    @Test
    void Get_n() {
        TicTacGame ttt = new TicTacGame(3,3,3);
        assertEquals(3,ttt.Get_n());
    }
    @Test
    void Get_m(){
        TicTacGame ttt = new TicTacGame(3,3,3);
        assertEquals(3,ttt.Get_m());
    }
    @Test
    void Get_k(){
        TicTacGame ttt = new TicTacGame(3,3,3);
        assertEquals(3,ttt.Get_k());
    }
    @Test
    void Next_Player(){
        TicTacGame ttt = new TicTacGame(3,3,3);
        assertEquals(1,ttt.Get_PlayerNumber());
    }
    @Test
    void CheckIfWinOrDraw(){
        TicTacGame ttt = new TicTacGame(3,3,3);
        assertEquals(TicTacGame.BoardState.INPROGRESS,ttt.GetCurrentBoardState());
    }
    @Test
    void Get_NTurns(){
        TicTacGame ttt = new TicTacGame(3,3,3);
        ttt.CellsStates[0] = TicTacGame.CellState.X;
        assertEquals(0,ttt.Get_NTurns());
    }
}