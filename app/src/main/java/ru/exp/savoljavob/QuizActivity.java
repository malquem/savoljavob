package ru.exp.savoljavob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // Добавление полей?
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    // Добавление перемменных и массива Question(QuizActivitz.java)
    private Question[] mQuestionBank = new Question[] {
            //Программа несколько раз вызывает конструктор Question и создает массив
            // объектов Question.
            new Question(R.string.question_s1, true),
            new Question(R.string.question_s2, true),
            new Question(R.string.question_s2, false),
            new Question(R.string.question_s2, false),
            new Question(R.string.question_s2, true),
            new Question(R.string.question_s2, true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /* Подключение виджета TextView */
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        //int question = mQuestionBank[mCurrentIndex].getTextResId();
        //mQuestionTextView.setText(question);

        // Получение ссылок на виджеты 1
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание уведомлений
                Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_LONG).show();
            }
        });



        // Получение ссылок на виджеты 2
        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Создание уведомлений
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Подключение новой кнопки
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //int question = mQuestionBank[mCurrentIndex].getTextResId();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        updateQuestion();
    }
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
}
