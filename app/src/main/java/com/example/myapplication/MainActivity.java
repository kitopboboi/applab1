package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText NameIntro;
    private TextView textView, textView2, textView3, textView4, Reminder;
    private RadioButton Paper, Scissor, Rock;
    private Button ConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NameIntro = findViewById(R.id.NameIntro);
        Reminder = findViewById(R.id.Reminder);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        Paper = findViewById(R.id.Paper);
        Scissor = findViewById(R.id.Scissor);
        Rock = findViewById(R.id.Rock);
        ConfirmButton = findViewById(R.id.ConfirmButton);

        ConfirmButton.setOnClickListener(view -> {
            if (NameIntro.length() < 1) {
                Reminder.setText("Please input your name");
            } else {
                NameIntro.setText(String.format("Name\n%s", Reminder.getText().toString()));

                if (Paper.isChecked()) {
                    textView3.setText("Winner\n Paper");
                } else if (Scissor.isChecked()) {
                    textView3.setText("Winner\n Scissor");
                } else {
                    textView3.setText("Winner\n Rock" );

                }

                int computer_random = (int) (Math.random() * 3);

                if (computer_random == 0) {
                    textView2.setText("Computer Output\nPaper");
                } else if (computer_random == 1) {
                    textView2.setText("Computer Output\nScissor");
                } else {
                    textView2.setText("Computer Output\nRock");
                }

                if ((Paper.isChecked() && computer_random == 2) ||
                (Scissor.isChecked() && computer_random ==0) ||
                        (Rock.isChecked() &&  computer_random == 1)) {
                    textView3.setText("Victory\n"+ NameIntro.getText().toString());
                    Reminder.setText("Congratulations!");

                } else if ((Paper.isChecked() && computer_random == 1) ||
                (Scissor.isChecked() && computer_random == 2) ||
                        (Rock.isChecked() && computer_random == 0)) {
                    textView3.setText("Victory\nComputer");
                    Reminder.setText("Draw, Try Again");
                }

            }
        });

    }
}