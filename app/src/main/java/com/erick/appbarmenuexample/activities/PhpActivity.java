package com.erick.appbarmenuexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.erick.appbarmenuexample.R;
import com.erick.appbarmenuexample.utils.ToolbarUtil;

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
    private TextView textViewQuestion, textViewQuestion2, textViewQuestion3, feedbackTextView1, feedbackTextView2, feedbackTextView3;
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

        Toolbar toolbar = findViewById(R.id.appToolbar);
        ToolbarUtil.setupToolbar(this, toolbar, "");

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
                checkAnswer(radioGroup, feedbackTextView1, 0, correctAnswerForQuestion1);
                checkAnswer(radioGroup2, feedbackTextView2, 1, correctAnswerForQuestion2);
                checkAnswer(radioGroup3, feedbackTextView3, 2, correctAnswerForQuestion3);

                button.setText("Voltar ao Início");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PhpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }

    private void checkAnswer(RadioGroup group, TextView feedbackView, int questionIndex, int correctAnswer) {
        int selectedId = group.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        if (selectedRadioButton != null) {
            String answerText = selectedRadioButton.getText().toString();
            if (answerText.equals(options[questionIndex][correctAnswer])) {
                feedbackView.setText("Resposta Correta");
                feedbackView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            } else {
                feedbackView.setText("Resposta Incorreta");
                feedbackView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        } else {
            Toast.makeText(PhpActivity.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
        }
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

        feedbackTextView1 = findViewById(R.id.feedbackTextView1);
        feedbackTextView2 = findViewById(R.id.feedbackTextView2);
        feedbackTextView3 = findViewById(R.id.feedbackTextView3);


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