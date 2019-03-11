package com.fitple.fbauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button register, signIn, leave;
    String mEmail, mPwd;
    FirebaseAuth mAuth;
    AuthHelp authHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vFind();
        mAuth = FirebaseAuth.getInstance();
        authHelp = new AuthHelp(mAuth, this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = email.getText().toString();
                mPwd = password.getText().toString();

                authHelp.SignHelper(mEmail, mPwd);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = email.getText().toString();
                mPwd = password.getText().toString();

                authHelp.SignInHelper(mEmail, mPwd);
            }
        });


    }

    public void vFind() {
        email = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        register = (Button) findViewById(R.id.button);
        signIn = (Button) findViewById(R.id.button2);
        leave = (Button) findViewById(R.id.button3);
    }
}
