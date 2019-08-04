package com.example.loginregistrationmodel.UserLogin;

import android.util.Patterns;

import androidx.annotation.NonNull;

import com.example.loginregistrationmodel.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPresenter implements Contract.Presenter {

    private Contract.View mView;

    public LoginPresenter(Contract.View mView) {
        this.mView = mView;
    }


    @Override
    public Boolean validate(User user) {

        if (user.getEmail().isEmpty()) {
            mView.showErrorToast(1, "You Must enter your Email");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()) {
            mView.showErrorToast(1, "You Must enter valid Email");
            return false;
        }

        if (user.getPassword().length() < 6) {
            mView.showErrorToast(2, "Password Length must be more then 6 Letter");
            return false;
        }


        return true;
    }

    @Override
    public void signIn(User user) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    mView.startHomeActivity();
                } else {
                    mView.showToastOnError("SignIn Unsuccessful");
                }
            }
        });
    }

    @Override
    public void showSuccessToast(String massage) {
        mView.showToastOnSuccess(massage);
        mView.startHomeActivity();

    }
}
