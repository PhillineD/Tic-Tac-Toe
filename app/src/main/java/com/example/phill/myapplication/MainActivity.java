package com.example.phill.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Game game;
    int row;
    int column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

//    public void buttonClicked(View view) {
//    }

//a method that will process tile clicks
    public void tileClicked(View view) {

        // First step is to translate the button ID into coordinates
        // to find out which button it is
        int id = view.getId();
        if (id == 1){
            row = 1;
            column = 1;
        }
        else if (id == 2){
            row =1;
            column = 2;
        }
        else if (id == 3){
            row =1;
            column = 3;
        }
        else if (id == 4){
            row =2;
            column = 1;
        }
        else if (id == 5){
            row =2;
            column = 2;
        }
        else if (id == 6){
            row =2;
            column = 3;
        }
        else if (id == 7){
            row =3;
            column = 1;
        }
        else if (id == 8){
            row =3;
            column = 2;
        }
        else if (id == 9){
            row =3;
            column = 3;
        }
        // store the corresponding row and column

        // moet deze coördinaten aan de spelkeuzemethode toevoegen
        TileState state = game.choose(row, column);

        // String to fill in the button
        String button = "";

        // Depending on the outcome of the choose method, it has to update the selected button. Here’s a starter:
        switch(state) {
            case CROSS:
                // Make the button a cross
                button = "X";
                break;
            case CIRCLE:

                // Make the button a circle
                button = "O";
                break;
            case INVALID:

                // There is already something in the checkbox
                button = "";
                break;
        }

        GameState finish = game.won();

        switch (finish){
            case IN_PROGRESS:
                break;
            case PLAYER_ONE:
                break;
            case PLAYER_TWO:
                break;
            case DRAW:
                break;
            case WIN:
                break;
        }



        TextView b = (TextView) view;
        b.setText(button);

    }
    public void resetClicked(View view) {
        game = new Game();
//        we can simply throw away the old game and create a new one
//         update user interface
    }

}
