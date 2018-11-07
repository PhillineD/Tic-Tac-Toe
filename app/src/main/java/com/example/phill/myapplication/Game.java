package com.example.phill.myapplication;

import android.service.quicksettings.Tile;

public class Game {

    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)

            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

//      have a method that allows a user to “play
        public TileState choose(int row, int column) {

//            If that place is still blank, we can go ahead and fill it.
            if (board[row][column]== TileState.BLANK ){

//                if the current player is player one, fill it with a cross
                if (playerOneTurn){
                    board[row][column]= TileState.CROSS;
//                    playerOneTurn = GameState.PLAYER_ONE;
                    playerOneTurn = false;

//                    Check if player has won the game
                    return  TileState.CROSS;

                }

//                if the current player is player two, fill it with a circle
                else{
                    board[row][column]= TileState.CIRCLE;
                    playerOneTurn = true;


//                    Check if player has won the game

                    return  TileState.CIRCLE;
                }
            }

//            it’s an invalid move! Just return TileState.INVALID.
            else {
                return TileState.INVALID;
            }


        }

//    This method should verify the state of the board
//    return an appropriate value of the GameState enum
    public GameState won(){
        int count = 0;
        for(int i=0; i<BOARD_SIZE; i++)

//            check if horizontal win
            if ( board[i][0] == board[i][1]  &&   board[i][0] == board[i][3]) {
                return GameState.WIN;
            }

//            check if vertical win
            else if  ( board[0][i] == board[1][i] &&  board[0][i] == board[3][i]) {
                return GameState.WIN;
            }

//            check if schuin vanuit links win
            else if  ( board[0][0] == board[1][1]  && board[0][0] == board[3][3]) {
                return GameState.WIN;
            }

//            check if schuin vanuit rechts win
            else if  ( board[0][3] == board[1][1]  && board[0][3] == board[3][1] {
                return GameState.WIN;
            }


//            check if draw
        for(int i=0; i<BOARD_SIZE; i++){
           for (int j = 0; j < BOARD_SIZE; j++){
                if (board[i][j] != TileState.BLANK){
                    count= count + 1;
                }
           }
        }
        //         because neither player has won but all tiles have been claimed
        if (count == (BOARD_SIZE*BOARD_SIZE)){
                return GameState.DRAW;
        }
        else{
            return GameState.IN_PROGRESS;
        }

    }



}



