package com.erick.appbarmenuexample.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class NavigationUtils {

    public static final String NAVIGATION_KEY_JAVA = "Java";
    public static final String NAVIGATION_KEY_PHP = "PHP";
    public static final String NAVIGATION_KEY_C = "C";

    public static void navigate(Context context, Class<?> destination) {
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);
    }

    public static void navigateAndPop(Context context, Class<?> destination) {
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}