package com.example.loginregistrationmodel.UserRegistration;

public interface RegistrationContract {

    interface Presenter{

        boolean validate(User user);
        void showSuccessToast(String massage);

    }

    interface View{
        void showToastOnSuccess(String massage);
        void showToastOnError(String massage);
        void showErrorToast(int fieldId, String massage);
        void startHomeActivity();
        void startLoginActivity();
    }
}
