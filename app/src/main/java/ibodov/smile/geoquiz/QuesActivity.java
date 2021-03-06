package ibodov.smile.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// 1
public class QuesActivity extends AppCompatActivity {

    private Button mTrueButton; //иниц. кнопки
    private Button mFalseButton; //иниц. кнопки

    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question); //
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
//        int question = mQuestionBank[mCurrentIndex].getmTextResId();
//        mQuestionTextView.setText(question);



        mTrueButton = (Button) findViewById(R.id.true_button); //деклар кнопки
        mTrueButton.setOnClickListener(new View.OnClickListener() { //назначаем слушателя
            @Override
            public void onClick(View v) {
                    Toast.makeText(QuesActivity.this,
                                           R.string.incorrect_toast,
                                           Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button); //деклар кнопки
        mFalseButton.setOnClickListener(new View.OnClickListener() { //назначаем слушателя
            @Override
            public void onClick(View v) {
                    Toast.makeText(QuesActivity.this,
                                           R.string.correct_toast,
                                           Toast.LENGTH_SHORT).show();
            }
        });

        //Подулючения новой кнопки
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override//
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getmTextResId();
//                mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        updateQuestion();

    }

}