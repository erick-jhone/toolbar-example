package com.erick.appbarmenuexample.activities;

import static com.erick.appbarmenuexample.utils.AnswerKey.JAVA_CORRECT_ANSWER_FOR_QUESTION_1;
import static com.erick.appbarmenuexample.utils.AnswerKey.JAVA_CORRECT_ANSWER_FOR_QUESTION_2;
import static com.erick.appbarmenuexample.utils.AnswerKey.JAVA_CORRECT_ANSWER_FOR_QUESTION_3;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.erick.appbarmenuexample.R;
import com.erick.appbarmenuexample.utils.NavigationUtils;
import com.erick.appbarmenuexample.utils.QuizUtils;
import com.erick.appbarmenuexample.utils.ToolbarUtil;

public class JavaActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);

        Toolbar toolbar = findViewById(R.id.appToolbar);
        ToolbarUtil.setupToolbar(this, toolbar, "", true);

        initUIComponents();
        seeQuestions(0);
        seeQuestions(1);
        seeQuestions(2);
        setupListeners();
        button.setEnabled(false);
        setupRadioGroupListeners();
    }

    private void setupRadioGroupListeners() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> checkAllQuestionsAnswered());
        radioGroup2.setOnCheckedChangeListener((group, checkedId) -> checkAllQuestionsAnswered());
        radioGroup3.setOnCheckedChangeListener((group, checkedId) -> checkAllQuestionsAnswered());
    }

    private void checkAllQuestionsAnswered() {
        boolean allAnswered = radioGroup.getCheckedRadioButtonId() != -1 &&
                radioGroup2.getCheckedRadioButtonId() != -1 &&
                radioGroup3.getCheckedRadioButtonId() != -1;

        button.setEnabled(allAnswered);
    }

    private void setupListeners() {
        button.setOnClickListener(view -> {
            QuizUtils.checkAnswer(this, radioGroup, feedbackTextView1, 0, JAVA_CORRECT_ANSWER_FOR_QUESTION_1, options);
            QuizUtils.checkAnswer(this, radioGroup2, feedbackTextView2, 1, JAVA_CORRECT_ANSWER_FOR_QUESTION_2, options);
            QuizUtils.checkAnswer(this, radioGroup3, feedbackTextView3, 2, JAVA_CORRECT_ANSWER_FOR_QUESTION_3, options);

            button.setText(R.string.voltar_ao_in_cio);

            button.setOnClickListener(v -> {
                NavigationUtils.navigateAndPop(this, MainActivity.class);
            });
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

        feedbackTextView1 = findViewById(R.id.feedbackTextView1);
        feedbackTextView2 = findViewById(R.id.feedbackTextView2);
        feedbackTextView3 = findViewById(R.id.feedbackTextView3);

        button = findViewById(R.id.buttonQuestion);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewQuestion2 = findViewById(R.id.textViewQuestion2);
        textViewQuestion3 = findViewById(R.id.textViewQuestion3);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}