package com.example.phill.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    Game game;
    int row;
    int column;
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    Button a1, a2, a3 , b1, b2, b3, c1, c2, c3;
    TextView Win_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        a1 = findViewById(R.id.Button1);
        a2 = findViewById(R.id.Button2);
        a3 = findViewById(R.id.Button3);
        b1 = findViewById(R.id.Button4);
        b2 = findViewById(R.id.Button5);
        b3 = findViewById(R.id.Button6);
        c1 = findViewById(R.id.Button7);
        c2 = findViewById(R.id.Button8);
        c3 = findViewById(R.id.Button9);


    }

//    public void buttonClicked(View view) {
//    }

//a method that will process tile clicks
    public void tileClicked(View view) {

        // First step is to translate the button ID into coordinates
        // to find out which button it is
        GameState finish = game.won();

        switch (finish){
            case IN_PROGRESS:
                int id = view.getId();
                Button button = (Button) view;

                if (id == a1.getId()){
                    row = 0;
                    column = 0;
                }
                else if (id == a2.getId()){
                    row =0;
                    column = 1;
                }
                else if (id == a3.getId()){
                    row =0;
                    column = 2;
                }
                else if (id == b1.getId()){
                    row =1;
                    column = 0;
                }
                else if (id == b2.getId()){
                    row =1;
                    column = 1;
                }
                else if (id == b3.getId()){
                    row =1;
                    column = 2;
                }
                else if (id == c1.getId()){
                    row =2;
                    column = 0;
                }
                else if (id == c2.getId()){
                    row =2;
                    column = 1;
                }
                else if (id == c3.getId()){
                    row =2;
                    column = 2;
                }
                // store the corresponding row and column
                TileState state = game.choose(row, column);

                // String to fill in the button
                String but = "";

                // Depending on the outcome of the choose method, it has to update the selected button. Here’s a starter:
                switch(state) {
                    case CROSS:

                        // Make the button a cross
                        but = "X";
                        break;
                    case CIRCLE:

                        // Make the button a circle
                        but= "0";
                        break;
                    case INVALID:

                        // There is already something in the checkbox

                        break;
                }
                TextView b = (TextView) view;
                b.setText(but);

            case DRAW:

//                Win_Text = findViewById(R.id.textView);
//                Win_Text.setText("Nobody won the game, click on RESET to start a new game");
                break;

//             When player one has won
            case PLAYER_ONE:
                Win_Text = findViewById(R.id.textView);
                Win_Text.setText("Player one has won");
                break;
//            When player two has won
            case PLAYER_TWO:
                Win_Text = findViewById(R.id.textView);
                Win_Text.setText("Player two has won");
                break;

        }


    }
    public void resetClicked(View view) {
        Win_Text = findViewById(R.id.textView);
        Win_Text.setText("");
        a1.setText("");
        a2.setText("");
        a3.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");
        game = new Game();
//        we can simply throw away the old game and create a new one
//         update user interface
    }

}
