package android.kismar.quizzapp;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
//****
//by kismar

public class MainActivity extends AppCompatActivity {


    int score = 0;
    // Initialises user's name
    EditText nameField;
    String Username;

    // checks if checkboxes for question 1 are ticked and shows correct answers
    CheckBox question1ChkBx1;
    CheckBox question1ChkBx2;
    CheckBox question1ChkBx3;
    CheckBox question1ChkBx4;

    //checks if radio button for question 2 is checked
    RadioButton question2radio1;
    RadioButton question2radio2;

    // checks for user entered variable in question 3
    EditText question3answer;
    TextView question3Option1;
    TextView question3Option2;
    TextView question3Option3;
    TextView question3Option4;

    //    checks for radio check in question 4
    RadioButton question4radio1;
    RadioButton question4radio2;

    //    checks for radio check in question 5
    CheckBox question5ChkBx1;
    CheckBox question5ChkBx2;
    CheckBox question5ChkBx3;
    CheckBox question5ChkBx4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void verifyAnswer(View view) {
        // Get user's name
        nameField = findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        Username = nameEditable.toString();

        //        checks if checkboxes for question 1 are ticked and shows correct answers
        question1ChkBx1 = findViewById(R.id.question1ChkBx1);
        question1ChkBx2 = findViewById(R.id.question1ChkBx2);
        question1ChkBx3 = findViewById(R.id.question1ChkBx3);
        question1ChkBx4 = findViewById(R.id.question1ChkBx4);

        //    checks if radio button for question 2 is checked
        question2radio1 = findViewById(R.id.question2radio1);
        question2radio2 = findViewById(R.id.question2radio2);

        //    checks for user entered variable in question 3
        question3answer = findViewById(R.id.question3answer);
        Editable answer3editable = question3answer.getText();
        String answer3 = answer3editable.toString().trim();
        question3Option1 = findViewById(R.id.question3Option1);
        question3Option2 = findViewById(R.id.question3Option2);
        question3Option3 = findViewById(R.id.question3Option3);
        question3Option4 = findViewById(R.id.question3Option4);

        //    checks for radio check in question 4
        question4radio1 = findViewById(R.id.question4radio1);
        question4radio2 = findViewById(R.id.question4radio2);
        //        checks if checkboxes for question 5 are ticked and shows correct answers

        question5ChkBx1 = findViewById(R.id.question5ChkBx1);
        question5ChkBx2 = findViewById(R.id.question5ChkBx2);
        question5ChkBx3 = findViewById(R.id.question5ChkBx3);
        question5ChkBx4 = findViewById(R.id.question5ChkBx4);
//    predetermined answers for each question
//   correct answers change color to green, wrong answers change color to red
//        Question 1
        if ((question1ChkBx1.isChecked() && !question1ChkBx2.isChecked() && !question1ChkBx3.isChecked() && !question1ChkBx4.isChecked())) {
            score += 20;
            question1ChkBx1.setTextColor(getResources().getColor(R.color.colorGreen));
        } else {
            if (question1ChkBx1.isChecked()) {
                question1ChkBx1.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question1ChkBx2.isChecked()) {
                question1ChkBx2.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question1ChkBx3.isChecked()) {
                question1ChkBx3.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question1ChkBx4.isChecked()) {
                question1ChkBx4.setTextColor(getResources().getColor(R.color.colorRed));
            }
        }
        // Question 2
        if (question2radio1.isChecked()) {
            question2radio1.setTextColor(getResources().getColor(R.color.colorGreen));
            score += 20;
        }
        if (question2radio2.isChecked()) {
            question2radio2.setTextColor(getResources().getColor(R.color.colorRed));
        }
        // Question 3
        if (answer3.equalsIgnoreCase("A")) {
            question3Option1.setTextColor(getResources().getColor(R.color.colorRed));

        }
        if (answer3.equalsIgnoreCase("B")) {
            question3Option2.setTextColor(getResources().getColor(R.color.colorRed));

        }
        if (answer3.equalsIgnoreCase("C")) {
            question3Option3.setTextColor(getResources().getColor(R.color.colorRed));

        }
        if (answer3.equalsIgnoreCase("D")) {
            question3Option4.setTextColor(getResources().getColor(R.color.colorGreen));
            score += 20;
            //Question 4

        }
        if (question4radio1.isChecked()) {
            question4radio1.setTextColor(getResources().getColor(R.color.colorGreen));
            score += 20;
        }
        if (question4radio2.isChecked()) {
            question4radio2.setTextColor(getResources().getColor(R.color.colorRed));
        }
        //Question 5

        if ((question5ChkBx4.isChecked() && !question5ChkBx1.isChecked() && !question5ChkBx2.isChecked() && !question5ChkBx3.isChecked())) {
            score += 20;
            question5ChkBx4.setTextColor(getResources().getColor(R.color.colorGreen));
        } else {
            if (question5ChkBx1.isChecked()) {
                question5ChkBx1.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question5ChkBx2.isChecked()) {
                question5ChkBx2.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question5ChkBx3.isChecked()) {
                question5ChkBx3.setTextColor(getResources().getColor(R.color.colorRed));
            }
            if (question5ChkBx4.isChecked()) {
                question5ChkBx4.setTextColor(getResources().getColor(R.color.colorRed));
            }
        }

        // modify toast format and Username Score

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(String.format(Username + " your score is  %s ", score + "\n Thanks!!"));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        //      waits after 800 milliseconds and resets all views and score
        final Handler handler = new Handler();
        new Timer().schedule(new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        reset();
                    }
                });
            }
        }, 3000);

    }

    //    resets all views and uncheck all check boxes and radio buttons

    public void reset() {
        score = 0;
        //       resets text colors
        question1ChkBx1.setTextColor(getResources().getColor(R.color.black));
        question1ChkBx2.setTextColor(getResources().getColor(R.color.black));
        question1ChkBx3.setTextColor(getResources().getColor(R.color.black));
        question1ChkBx4.setTextColor(getResources().getColor(R.color.black));
        question2radio1.setTextColor(getResources().getColor(R.color.black));
        question2radio2.setTextColor(getResources().getColor(R.color.black));
        question3Option1.setTextColor(getResources().getColor(R.color.black));
        question3Option2.setTextColor(getResources().getColor(R.color.black));
        question3Option3.setTextColor(getResources().getColor(R.color.black));
        question3Option4.setTextColor(getResources().getColor(R.color.black));
        question4radio1.setTextColor(getResources().getColor(R.color.black));
        question4radio2.setTextColor(getResources().getColor(R.color.black));
        question5ChkBx1.setTextColor(getResources().getColor(R.color.black));
        question5ChkBx2.setTextColor(getResources().getColor(R.color.black));
        question5ChkBx3.setTextColor(getResources().getColor(R.color.black));
        question5ChkBx4.setTextColor(getResources().getColor(R.color.black));
        // reset CheckButtons

        question1ChkBx1.setChecked(false);
        question1ChkBx2.setChecked(false);
        question1ChkBx3.setChecked(false);
        question1ChkBx4.setChecked(false);
        question5ChkBx1.setChecked(false);
        question5ChkBx2.setChecked(false);
        question5ChkBx3.setChecked(false);
        question5ChkBx4.setChecked(false);

        // reset radioGroups
        RadioGroup radioGroup1 = findViewById(R.id.radioGroupQuestion2);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = findViewById(R.id.radioGroupQuestion4);
        radioGroup2.clearCheck();


        // reset nameField and edittext
        nameField.getText().clear();
        question3answer.getText().clear();
    }
}
