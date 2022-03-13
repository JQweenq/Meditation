package com.example.learning.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learning.R;
import com.example.learning.activities.MainActivity;

public class BoardingFragment extends Fragment {

    private Button login;
    private ImageView ico;
    private TextView hello;
    private Context ctx;
    private MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boarding, container, false);

        activity = (MainActivity) getActivity();
        ctx = getContext();

        login = view.findViewById(R.id.login_button);
        ico = view.findViewById(R.id.ico);
        hello = view.findViewById(R.id.hello);

        login.setOnClickListener(view1 ->
            activity.loadFullFragment(activity.whichFullFragment(R.layout.fragment_login))
        );

//        Animation alpha = AnimationUtils.loadAnimation(ctx, R.anim.rotation);
//        login.startAnimation(alpha);

        Animation scale = AnimationUtils.loadAnimation(ctx, R.anim.full);
        ico.startAnimation(scale);
//
//        Animation translate = AnimationUtils.loadAnimation(ctx, R.anim.anim_translate);
//        hello.startAnimation(translate);



        return view;
    }

}