package com.erick.appbarmenuexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.erick.appbarmenuexample.R;
import com.erick.appbarmenuexample.utils.ToolbarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.appToolbar);
        ToolbarUtil.setupToolbar(this, toolbar, "");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;

        if(item.getItemId() == R.id.java){
            intent = new Intent(MainActivity.this, JavaActivity.class);
            startActivity(intent);
            return true;
        }


        if(item.getItemId() == R.id.php){
            intent = new Intent(MainActivity.this, PhpActivity.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId() == R.id.c){
            intent = new Intent(MainActivity.this, CActivity.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}