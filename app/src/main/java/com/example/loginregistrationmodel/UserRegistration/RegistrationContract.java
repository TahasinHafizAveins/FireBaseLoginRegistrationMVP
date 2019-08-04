package com.example.loginregistrationmodel.UserRegistration;

import com.example.loginregistrationmodel.Model.User;

public interface RegistrationContract {

    interface Presenter{

        boolean validate(User user);
        void signUp(User user);
        void showSuccessToast(String massage);

    }

    interface View{
        void showToastOnSuccess(String massage);
        void showToastOnError(String massage);
        void showErrorToast(int fieldId, String massage);
        void startHomeActivity();
        void startLoginActivity();
        void thisActivity();
    }
}
