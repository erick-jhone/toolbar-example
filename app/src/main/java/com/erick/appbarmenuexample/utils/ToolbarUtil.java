package com.erick.appbarmenuexample.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ToolbarUtil {

    public static void setupToolbar(AppCompatActivity activity, Toolbar toolbar, String title, boolean showBackButton) {
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle(title);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(showBackButton);
        }
    }
}