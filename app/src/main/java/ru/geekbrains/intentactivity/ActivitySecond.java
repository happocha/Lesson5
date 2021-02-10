package ru.geekbrains.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {

    private EditText messageEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameTextView = findViewById(R.id.tv_name);
        TextView surnameTextView = findViewById(R.id.tv_surname);
        TextView ageTextView = findViewById(R.id.tv_age);

        messageEditText = findViewById(R.id.et_message);
        Button backButton = findViewById(R.id.btn_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitWithResult();
            }
        });

        Intent intent = getIntent();

        if (intent != null) {
            ActivitySecondModel model = (ActivitySecondModel) intent.getParcelableExtra(MainActivity.ARG_EXTRA);
            nameTextView.setText(model.getName());
            surnameTextView.setText(model.getSurname());
            ageTextView.setText(String.valueOf(model.getAge()));
        }
    }

    private void exitWithResult() {
        String message = messageEditText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("message", message);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
