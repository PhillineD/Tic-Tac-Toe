package com.example.phill.myapplication;

import android.service.quicksettings.Tile;

public class Game {

    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn = true;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver = false;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++) {

            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = TileState.BLANK;
            }
        }
    }



//      have a method that allows a user to “play
        public TileState choose(int row, int column) {

//            If that place is still blank, we can go ahead and fill it.
            if (board[row][column]== TileState.BLANK ){

//                if the current player is player one, fill it with a cross
                if (playerOneTurn == true){
                    board[row][column]= TileState.CROSS;
//                    playerOneTurn = GameState.PLAYER_ONE;
                    playerOneTurn = false;
                    return  TileState.CROSS;

                }

//                if the current player is player two, fill it with a circle
                else{
                    board[row][column]= TileState.CIRCLE;
                    playerOneTurn = true;
                    return  TileState.CIRCLE;
                }
            }

//            it’s an invalid move! Just return TileState.INVALID.
            else {
//                board[row][column] = TileState.INVALID;
                return TileState.INVALID;
            }


        }
}



