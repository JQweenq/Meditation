package com.example.learning.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.learning.R;
import com.example.learning.activities.MainActivity;
import com.example.learning.data.remotly.ApiRequest;
import com.example.learning.data.remotly.LoginBody;
import com.example.learning.data.remotly.LoginResponse;
import com.example.learning.data.remotly.QuotesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private MainActivity activity;
    private Button login;
    private EditText email;
    private EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login = view.findViewById(R.id.login_button);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        activity = (MainActivity) getActivity();

        login.setOnClickListener(view1 -> {

            LoginBody body = new LoginBody(
                    email.getText(),
                    password.getText()
            );

            new Thread(() -> {
                activity.retrofit.create(ApiRequest.class).postLogin(body).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.code() != 200){
                            activity.showErrorDialog("Вход не выполнен");
                        } else {
                            activity.loadFullFragment(activity.whichFullFragment(R.layout.fragment_main));
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        activity.showErrorDialog(t.toString());
                    }
                });
            }).start();

        });

        return view;
    }
}