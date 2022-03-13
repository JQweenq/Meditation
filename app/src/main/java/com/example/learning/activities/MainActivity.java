package com.example.learning.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.learning.fragments.NavigationFragment;
import com.example.learning.fragments.ProfileFragment;
import com.example.learning.cummon.CummonExtendedActivity;
import com.example.learning.fragments.BoardingFragment;
import com.example.learning.fragments.HomeFragment;
import com.example.learning.R;
import com.example.learning.fragments.LoginFragment;
import com.example.learning.fragments.MainFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends CummonExtendedActivity {

    public Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor logs = new HttpLoggingInterceptor();
        logs.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logs).build();

        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl("http://mskko2021.mad.hakta.pro/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

        loadFullFragment(whichFullFragment(R.layout.fragment_boarding));
    }

    @SuppressLint("NonConstantResourceId")
    public Fragment whichFragment(int id) {
        switch (id) {
            case R.layout.fragment_navigation:
            case R.id.navigation_navigation: {
                return new NavigationFragment();
            }
            case R.layout.fragment_profile:
            case R.id.navigation_profile: {
                return new ProfileFragment();
            }
            default: {
                return new HomeFragment();
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    public Fragment whichFullFragment(int id) {
        switch (id) {
            case R.layout.fragment_login: {
                return new LoginFragment();
            }
            case R.layout.fragment_main: {
                return new MainFragment();
            }
            default: {
                return new BoardingFragment();
            }
        }
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void loadFullFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.full_frame, fragment);
        if (!(fragment instanceof BoardingFragment)) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}