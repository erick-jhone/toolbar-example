package com.erick.appbarmenuexample.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.erick.appbarmenuexample.R;

public class PhpActivity extends AppCompatActivity {

    private RadioGroup radioGroup, radioGroup2,radioGroup3;
    private RadioButton radioButtonFirstOption,
            radioButtonSecondOption,
            radioButtonThirdOption,
            radioButtonFourthOption,
            radioButtonFirstOption2,
            radioButtonSecondOption2,
            radioButtonThirdOption2,
            radioButtonFourthOption2,
            radioButtonFirstOption3,
            radioButtonSecondOption3,
            radioButtonThirdOption3,
            radioButtonFourthOption3;;
    private Button button;
    private TextView textViewQuestion, textViewQuestion2, textViewQuestion3;
    private String[] questions;
    private String[][] options;
    private int correctAnswerForQuestion1 = 1;
    private int correctAnswerForQuestion2 = 1;
    private int correctAnswerForQuestion3 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_php);

        initUIComponents();
        seeQuestions(0);
        seeQuestions(1);
        seeQuestions(2);
        setupListeners();
    }

    private void setupListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                if(selectedRadioButton != null) {
                    String question = selectedRadioButton.getText().toString();
                    String answer = "";
                    if(question.equals(options[0][correctAnswerForQuestion1])){
                        answer = "Correto";
                    } else {
                        answer = "Incorreto";
                    }
                    Toast.makeText(PhpActivity.this, answer, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PhpActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     * Atualiza a interface do usuário para exibir uma nova pergunta e suas opções de resposta.
     *
     * @param questionIndex O índice da pergunta no array de perguntas que deve ser exibida.
     */
    private void seeQuestions(int questionIndex) {
        String question = questions[questionIndex];
        if(questionIndex == 0) {
            textViewQuestion.setText(question);
            radioGroup.clearCheck();
            radioButtonFirstOption.setText(options[questionIndex][0]);
            radioButtonSecondOption.setText(options[questionIndex][1]);
            radioButtonThirdOption.setText(options[questionIndex][2]);
            radioButtonFourthOption.setText(options[questionIndex][3]);
        }

        if (questionIndex == 1) {
            textViewQuestion2.setText(question);
            radioGroup2.clearCheck();
            radioButtonFirstOption2.setText(options[questionIndex][0]);
            radioButtonSecondOption2.setText(options[questionIndex][1]);
            radioButtonThirdOption2.setText(options[questionIndex][2]);
            radioButtonFourthOption2.setText(options[questionIndex][3]);
        }

        if (questionIndex == 2) {
            textViewQuestion3.setText(question);
            radioGroup3.clearCheck();
            radioButtonFirstOption3.setText(options[questionIndex][0]);
            radioButtonSecondOption3.setText(options[questionIndex][1]);
            radioButtonThirdOption3.setText(options[questionIndex][2]);
            radioButtonFourthOption3.setText(options[questionIndex][3]);
        }
    }

    private void initUIComponents() {

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioButtonFirstOption = findViewById(R.id.radioButtonFirstOption);
        radioButtonThirdOption = findViewById(R.id.radioButtonThirdOption);
        radioButtonSecondOption = findViewById(R.id.radioButtonSecondOption);
        radioButtonFourthOption = findViewById(R.id.radioButtonFourthOption);
        radioButtonFirstOption2 = findViewById(R.id.radioButtonFirstOption2);
        radioButtonThirdOption2 = findViewById(R.id.radioButtonThirdOption2);
        radioButtonSecondOption2 = findViewById(R.id.radioButtonSecondOption2);
        radioButtonFourthOption2 = findViewById(R.id.radioButtonFourthOption2);
        radioButtonFirstOption3 = findViewById(R.id.radioButtonFirstOption3);
        radioButtonThirdOption3 = findViewById(R.id.radioButtonThirdOption3);
        radioButtonSecondOption3 = findViewById(R.id.radioButtonSecondOption3);
        radioButtonFourthOption3 = findViewById(R.id.radioButtonFourthOption3);

        button = findViewById(R.id.buttonQuestion);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewQuestion2 = findViewById(R.id.textViewQuestion2);
        textViewQuestion3 = findViewById(R.id.textViewQuestion3);

        questions = getResources().getStringArray(R.array.perguntas_php);
        options = getOptions();
    }

    private String[][] getOptions() {
        return new String[][]{
                getResources().getStringArray(R.array.opcoes_php0),
                getResources().getStringArray(R.array.opcoes_php1),
                getResources().getStringArray(R.array.opcoes_php2),
        };
    }
}