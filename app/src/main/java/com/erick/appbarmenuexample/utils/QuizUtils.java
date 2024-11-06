package com.erick.appbarmenuexample.utils;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.erick.appbarmenuexample.R;

public class QuizUtils {
    public static void checkAnswer(Context context, RadioGroup group, TextView feedbackView, int questionIndex, int correctAnswer, String[][] options) {
        int selectedId = group.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = group.findViewById(selectedId);

        if (selectedRadioButton != null) {
            String answerText = selectedRadioButton.getText().toString();
            if (answerText.equals(options[questionIndex][correctAnswer])) {
                feedbackView.setText(R.string.resposta_correta);
                feedbackView.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
            } else {
                feedbackView.setText(R.string.resposta_incorreta);
                feedbackView.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }
}