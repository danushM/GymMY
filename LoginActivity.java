package com.example.danush.projectroughdraft;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText usernameText, passwordText;
    Button login;
    TextView slink, fpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.editText);
        passwordText = findViewById(R.id.editText2);

        slink = findViewById(R.id.textView);
        fpass = findViewById(R.id.textView5);

        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = usernameText.getText().toString();
                String passwordString = passwordText.getText().toString();

                if(usernameString.equals("admin") && passwordString.equals("admin")) {
                    login.setEnabled(false);
                    final ProgressDialog progressAnimation = new ProgressDialog(LoginActivity.this);
                    progressAnimation.setIndeterminate(true);
                    progressAnimation.setMessage("Logging you in...");
                    progressAnimation.show();

                    Intent openMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(openMain);
                    //finish();
                }
                /*String storedUname, storedPword;

                credentials = openOrCreateDatabase("projectDB", Context.MODE_PRIVATE, null);

                resultSet = credentials.rawQuery("Select * from loginCredentials", null);
                resultSet.moveToNext();
                storedUname*/
            }
        });

        slink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignUp = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(openSignUp);
                finish();
            }
        });

        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog forgotPasswordAlert = new AlertDialog.Builder(getApplicationContext()).create();

                //A text box for entering the email address
                EditText emailText = new EditText(getApplicationContext());
                emailText.setGravity(Gravity.CENTER);
                emailText.setHint("Enter registered email address...");

                //Button to submit the email address
                forgotPasswordAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //for now just hide the dialog
                        forgotPasswordAlert.hide();
                    }
                });
            }
        });
    }
}