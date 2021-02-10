package ru.geekbrains.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ARG_EXTRA = "arg_extra";
    public static final int RC_MESSAGE = 1122;

    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView startActivityTV = findViewById(R.id.tv_start_activity);
        TextView openDialTV = findViewById(R.id.tv_open_dial);
        TextView shareTV = findViewById(R.id.tv_share);
        resultTV = findViewById(R.id.tv_result);
        startActivityTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivitySecond();
            }
        });

        openDialTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialScreen();
            }
        });

        shareTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShareScreen();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_MESSAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String message = data.getStringExtra("message");
                resultTV.setText(message);
            }
        }
    }

    private void startActivitySecond() {
        Intent intent = new Intent(this, ActivitySecond.class);
        ActivitySecondModel model = new ActivitySecondModel("Filipp", "Kirkorov", 55);
        intent.putExtra(ARG_EXTRA, model);
        startActivityForResult(intent, RC_MESSAGE);
    }

    private void openDialScreen() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://ya.ru"));
        startActivity(intent);
    }

    private void openShareScreen() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "сообщение");
        intent.setType("text/plain");
        startActivity(intent);
    }
}