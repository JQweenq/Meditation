package com.example.learning.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learning.R;
import com.example.learning.activities.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    private MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        activity = (MainActivity) getActivity();

        BottomNavigationView navigationView = view.findViewById(R.id.nav_view);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            activity.loadFragment(activity.whichFragment(R.id.navigation_home));
            return true;
        });

        activity.loadFragment(activity.whichFragment(R.layout.fragment_home));

        return view;
    }
}