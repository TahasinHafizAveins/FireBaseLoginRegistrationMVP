package com.example.loginregistrationmodel.UserLogin;

public interface Contract {

    interface Presenter {
        Boolean validate(User user);

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
