package com.example.learning.cummon;

import androidx.appcompat.app.AppCompatActivity;

public class CummonExtendedActivity extends AppCompatActivity {

    public void showErrorDialog(CharSequence text){
        CustomErrorDialog dialog = new CustomErrorDialog(this, text);
        dialog.show(getSupportFragmentManager(), "ErrorDialog");
    }
}


