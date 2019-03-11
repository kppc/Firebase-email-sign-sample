package com.fitple.fbauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    String aa, getUid;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    Button leave, logout;
    AuthHelp authHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vFInd();
        authHelp = new AuthHelp(mAuth, this);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified = mUser.isEmailVerified();
        getUid = mUser.getUid();
        aa = mUser.getEmail();
        textView.setText(aa);

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authHelp.Leave();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void vFInd() {
        textView = (TextView) findViewById(R.id.textView);
        leave = (Button) findViewById(R.id.button3);
        logout = (Button) findViewById(R.id.button4);
    }
}
