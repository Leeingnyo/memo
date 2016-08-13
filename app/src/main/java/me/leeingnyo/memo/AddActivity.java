package me.leeingnyo.memo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText titleEdit;
    EditText contentsEdit;
    CheckBox checkDate;
    EditText dateEdit;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titleEdit = (EditText)findViewById(R.id.title_edit);
        contentsEdit = (EditText)findViewById(R.id.contents_edit);
        checkDate = (CheckBox)findViewById(R.id.check_date);
        dateEdit = (EditText)findViewById(R.id.date_edit);
        saveButton = (Button)findViewById(R.id.save_button);

        checkDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    dateEdit.setVisibility(View.VISIBLE);
                } else {
                    dateEdit.setVisibility(View.GONE);
                }
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save(){
        String title = titleEdit.getText().toString();
        if (title.equals("")){
            Toast.makeText(AddActivity.this, "제목은 필수입니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        String contents = contentsEdit.getText().toString();
        Boolean check = checkDate.isChecked();
        if (check) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = sdf.parse(dateEdit.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
                Toast.makeText(AddActivity.this, "날짜 형식이 틀렸습니다. '20xx-xx-xx'로 해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            MemoManager.getInstance(this).add(new Memo(title, contents, date));
        } else {
            MemoManager.getInstance(this).add(new Memo(title, contents));
        }
        finish();
    }
}
