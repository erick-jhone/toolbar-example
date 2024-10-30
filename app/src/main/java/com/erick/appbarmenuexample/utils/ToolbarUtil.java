package com.erick.appbarmenuexample.utils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ToolbarUtil {

    public static void setupToolbar(AppCompatActivity activity, Toolbar toolbar, String title) {
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setTitle(title);
        }
    }
}