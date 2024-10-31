package com.erick.appbarmenuexample.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.erick.appbarmenuexample.R;

public class JavaActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonFirstOption, radioButtonSecondOption, radioButtonThirdOption, radioButtonFourthOption;
    private Button button;
    private TextView textViewQuestion;
    private String[] questions;
    private String[][] options;
    private int correctAnswer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);

        initUIComponents();
    }

    private void initUIComponents() {

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonFirstOption = findViewById(R.id.radioButtonFirstOption);
        radioButtonThirdOption = findViewById(R.id.radioButtonThirdOption);
        radioButtonSecondOption = findViewById(R.id.radioButtonSecondOption);
        radioButtonFourthOption = findViewById(R.id.radioButtonFourthOption);

        questions = getResources().getStringArray(R.array.perguntas);
        options = getOptions();
    }

    private String[] @NonNull [] getOptions() {
        return new String[][]{
                getResources().getStringArray(R.array.opcao0),
                getResources().getStringArray(R.array.opcao1),
                getResources().getStringArray(R.array.opcao2),
        };
    }
}