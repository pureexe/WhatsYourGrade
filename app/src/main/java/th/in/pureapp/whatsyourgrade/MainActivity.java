package th.in.pureapp.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText scoreEditText;
    private Button exitButton;
    private Button findGradeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = (EditText) findViewById(R.id.name_edittext);
        scoreEditText = (EditText) findViewById(R.id.score_edittext);
        exitButton = (Button) findViewById(R.id.exit_button);
        findGradeButton = (Button) findViewById(R.id.find_grade_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Confirm Exit")
                        .setMessage("แน่ใจว่าต้องการออกจากแอพ?")
                        .setNegativeButton("ยกเลิก",null)
                        .setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        }).show();
            }
        });
        findGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String score = scoreEditText.getText().toString();
                double myScore;
                boolean isError = false;
                if(name.trim().equals("")){
                    nameEditText.setError(MainActivity.this.getString(R.string.fill_your_name));
                    isError = true;
                }
                try{
                    if(score.trim().equals("")){
                        throw new NumberFormatException();
                    }
                    myScore = Double.parseDouble(score);
                }catch(NumberFormatException nfe) {
                    scoreEditText.setError(MainActivity.this.getString(R.string.fill_your_score));
                    isError = true;
                }
                if(isError){
                    return ;
                }
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("score",score);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
