package com.example.loginregistrationmodel.UserLogin;

import com.example.loginregistrationmodel.Model.User;

public interface Contract {

    interface Presenter {
        Boolean validate(User user);
        void signIn(User user);
        void showSuccessToast(String massage);
    }

    interface View {

        void showErrorToast(int fieldId ,String massage);
        void showToastOnSuccess(String massage);
        void showToastOnError(String massage);
        void startHomeActivity();
        void gotoRegistrationActivity();

    }
}
