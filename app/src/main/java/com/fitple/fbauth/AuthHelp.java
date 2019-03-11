package com.fitple.fbauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class AuthHelp {
    private FirebaseAuth mAuth;
    private Context mContext;
    private Intent intent;

    public AuthHelp(FirebaseAuth mAuth, Context mContext) {
        this.mAuth = mAuth;
        this.mContext = mContext;
    }

    public void SignHelper(String mEmail, String mPwd) {
        mAuth.createUserWithEmailAndPassword(mEmail, mPwd)
                .addOnCompleteListener(((Activity) mContext), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(mContext, "오우~ 씬나게 로그인 해볼까?", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "뭔가 틀렸을거야 안되네..", Toast.LENGTH_SHORT).show();
                    Log.w("register", "회원가입 실패", task.getException());

                }
            }
        });
    }
    public void SignInHelper(String mEmail, String mPwd){
        mAuth.signInWithEmailAndPassword(mEmail, mPwd).addOnCompleteListener(((Activity) mContext), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    mContext.startActivity(new Intent(mContext, Main2Activity.class));
                } else {
                    Toast.makeText(mContext, "로그인 실패다 임마!", Toast.LENGTH_SHORT).show();
                    Log.w("signIn", "로그인 실패", task.getException());
                }
            }
        });
    }

    public void Leave(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.d("Levea", "탈퇴 성공");
                }
            }
        });
    }


}