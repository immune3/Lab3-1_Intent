package embedded.kookmin.ac.kr.lab3_1_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity{

    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mEdit = (EditText)findViewById(R.id.editText);

        Intent i = getIntent();
        mEdit.setText(i.getStringExtra("TextIn"));

        Button btOk = (Button)findViewById(R.id.bt_ok);
        btOk.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent();
                i.putExtra("TextOut", mEdit.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });

        Button btCancle = (Button)findViewById(R.id.bt_cancle);
        btCancle.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
