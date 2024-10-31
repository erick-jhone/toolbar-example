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
        seeQuestions(0);
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
                    if(question.equals(options[0][correctAnswer])){
                        answer = "Correto";
                    } else {
                        answer = "Incorreto";
                    }
                    Toast.makeText(JavaActivity.this, answer, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(JavaActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
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
        textViewQuestion.setText(question);
        radioGroup.clearCheck();
        radioButtonFirstOption.setText(options[questionIndex][0]);
        radioButtonSecondOption.setText(options[questionIndex][1]);
        radioButtonThirdOption.setText(options[questionIndex][2]);
        radioButtonFourthOption.setText(options[questionIndex][3]);
    }

    private void initUIComponents() {

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonFirstOption = findViewById(R.id.radioButtonFirstOption);
        radioButtonThirdOption = findViewById(R.id.radioButtonThirdOption);
        radioButtonSecondOption = findViewById(R.id.radioButtonSecondOption);
        radioButtonFourthOption = findViewById(R.id.radioButtonFourthOption);

        button = findViewById(R.id.buttonQuestion);
        textViewQuestion = findViewById(R.id.textViewQuestion);

        questions = getResources().getStringArray(R.array.perguntas);
        options = getOptions();
    }

    private String[][] getOptions() {
        return new String[][]{
                getResources().getStringArray(R.array.opcao0),
                getResources().getStringArray(R.array.opcao1),
                getResources().getStringArray(R.array.opcao2),
        };
    }
}