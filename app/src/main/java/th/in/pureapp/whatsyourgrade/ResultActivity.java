package th.in.pureapp.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView gradeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nameTextView = (TextView) findViewById(R.id.name_textview);
        gradeTextView = (TextView) findViewById(R.id.grade_textview);
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra("name"));
        double score = Double.parseDouble(intent.getStringExtra("score"));
        gradeTextView.setText(getGrade(score));
    }

    private String getGrade(double score) {
        if(score >= 80){
            return "A";
        }
        if(score >= 70){
            return "B";
        }
        if(score >= 60){
            return "C";
        }
        if(score >= 50){
            return "D";
        }
        return "F";
    }
}
