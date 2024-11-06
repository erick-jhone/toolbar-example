package com.erick.appbarmenuexample.activities;

import static com.erick.appbarmenuexample.utils.NavigationUtils.NAVIGATION_KEY_JAVA;
import static com.erick.appbarmenuexample.utils.NavigationUtils.NAVIGATION_KEY_C;
import static com.erick.appbarmenuexample.utils.NavigationUtils.NAVIGATION_KEY_PHP;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.erick.appbarmenuexample.R;
import com.erick.appbarmenuexample.adapter.ItemListAdapter;
import com.erick.appbarmenuexample.data.ItemListRepository;
import com.erick.appbarmenuexample.model.ItemList;
import com.erick.appbarmenuexample.utils.NavigationUtils;
import com.erick.appbarmenuexample.utils.ToolbarUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    private ListView listViewQuizOptions;
    private ItemListAdapter adapter;
    private ArrayList<ItemList> items;
    private MainActivity activityContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.appToolbar);
        ToolbarUtil.setupToolbar(this, toolbar, "", false);
        listViewQuizOptions = findViewById(R.id.listViewQuizOptions);
        activityContext = this;
        makeAdapter();
        listViewQuizOptions.setAdapter(adapter);
    }

    private void makeAdapter() {
        items = ItemListRepository.getItemList();
        adapter = new ItemListAdapter(this, items);
        listViewQuizOptions.setAdapter(adapter);
        listViewQuizOptions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemList item = (ItemList) parent.getItemAtPosition(position);
        openScreen(item.getData());
    }

    private void openScreen(String quizCategory){
        switch(quizCategory) {
            case NAVIGATION_KEY_JAVA:
                NavigationUtils.navigate(activityContext, JavaActivity.class);
                break;
            case NAVIGATION_KEY_PHP:
                NavigationUtils.navigate(activityContext, PhpActivity.class);
                break;
            case NAVIGATION_KEY_C:
                NavigationUtils.navigate(activityContext, CActivity.class);
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;

        if(item.getItemId() == R.id.java){
            NavigationUtils.navigate(activityContext, JavaActivity.class);
            return true;
        }


        if(item.getItemId() == R.id.php){
            NavigationUtils.navigate(activityContext, PhpActivity.class);
            return true;
        }

        if(item.getItemId() == R.id.c){
            NavigationUtils.navigate(activityContext, CActivity.class);
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