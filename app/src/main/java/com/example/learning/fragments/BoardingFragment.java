package com.example.learning.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.learning.R;
import com.example.learning.activities.MainActivity;

public class BoardingFragment extends Fragment {

    private Button login;
    private MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boarding, container, false);

        activity = (MainActivity) getActivity();

        login = view.findViewById(R.id.login_button);

        login.setOnClickListener(view1 ->
            activity.loadFullFragment(activity.whichFullFragment(R.layout.fragment_login))
        );

        return view;
    }
}