package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //呼び元画面から送られてきたintent情報を入手
        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        //確認
        Toast.makeText(this,"年齢"+age,Toast.LENGTH_SHORT).show();

        //画面のパーツ
        TextView Profile1 = findViewById(R.id.Profile1);
        EditText nameText = findViewById(R.id.nameText);
        EditText passText = findViewById(R.id.passText);
        Button clearN = findViewById(R.id.clearN);
        Button clearP = findViewById(R.id.clearP);
        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        Button button3 = findViewById(R.id.button3);

        clearN.setOnClickListener(this);
        clearP.setOnClickListener(this);
        button3.setOnClickListener(this);

        clearP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(passText.getText());
                return false;
            }
        });

        button3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(radioButton.isChecked()==true){
                    Toast.makeText(getApplicationContext(),R.string.man,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.woman,Toast.LENGTH_SHORT).show();
                }

                finish(); //画面消える
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.nameText);
        EditText passText = findViewById(R.id.passText);
        switch(view.getId()){
            case R.id.clearN:
                nameText.setText("");
                break;
            case R.id.clearP:
                passText.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.button3:
                Toast.makeText(this,"名前:"+nameText.getText(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}