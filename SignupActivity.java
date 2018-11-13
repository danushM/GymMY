package com.example.danush.projectroughdraft;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText username, password, passwordConfirmation;
    Button signup;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editText3);
        password = findViewById(R.id.editText4);
        passwordConfirmation = findViewById(R.id.editText5);

        signup = findViewById(R.id.button2);

        db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS loginCredentials(uname VARCHAR, passwd VARCHAR);");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(passwordConfirmation.getText().toString())) {
                    String query = "INSERT INTO loginCredentials VALUES ('" + username.getText().toString() + "', '" + password.getText().toString() + "' );";
                    db.execSQL(query);
                    final ProgressDialog signupAnimation = new ProgressDialog(SignupActivity.this);
                    signupAnimation.setIndeterminate(true);
                    signupAnimation.setMessage("Signing you up...");
                    signupAnimation.show();

                    Intent openMainScreen = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(openMainScreen);
                    finish();
                }

            }
        });
    }
}
