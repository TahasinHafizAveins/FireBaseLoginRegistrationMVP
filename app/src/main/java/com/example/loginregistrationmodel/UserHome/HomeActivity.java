package com.example.loginregistrationmodel.UserHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.loginregistrationmodel.R;
import com.example.loginregistrationmodel.UserHome.main.MainFragment;
import com.example.loginregistrationmodel.UserHome.verified.VerifiedFragment;
import com.example.loginregistrationmodel.UserLogin.LoginActivity;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPresenter = new HomePresenter(this);

    }
    public void onStart() {
        super.onStart();
        mPresenter.checkCurrentUser();

    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void reCreate() {
        recreate();
    }

    @Override
    public void checkVerifiedUser() {
        mPresenter.checkVerifiedUser();
    }

    @Override
    public void loadMainFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new MainFragment()).commit();
    }

    @Override
    public void loadVerifiedFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new VerifiedFragment()).commit();
    }

    @Override
    public void logOut() {
        mPresenter.logOut();
    }
}
