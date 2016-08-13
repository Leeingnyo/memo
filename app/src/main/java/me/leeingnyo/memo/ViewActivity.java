package me.leeingnyo.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView titleView;
    TextView dateView;
    TextView contentsView;

    Memo memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        titleView = (TextView)findViewById(R.id.title);
        dateView = (TextView)findViewById(R.id.date);
        contentsView = (TextView)findViewById(R.id.contents);

        Intent intent = getIntent();
        memo = (Memo)intent.getParcelableExtra("memo");

        titleView.setText(memo.getTitle());
        dateView.setText(memo.getDate());
        contentsView.setText(memo.getContents());
    }
}
