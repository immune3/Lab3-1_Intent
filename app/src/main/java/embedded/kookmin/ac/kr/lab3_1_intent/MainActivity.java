package embedded.kookmin.ac.kr.lab3_1_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int ACT_EDIT = 0;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView) findViewById(R.id.text);
        Button btEdit = (Button) findViewById(R.id.bt_1);

        btEdit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NextActivity.class);
                i.putExtra("TextIn", mText.getText().toString());
                startActivityForResult(i, ACT_EDIT);
            }

        });
    }
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ACT_EDIT:
                if(resultCode == RESULT_OK) {
                    mText.setText(data.getStringExtra("TextOut"));
                }
                break;
        }
    }
}
