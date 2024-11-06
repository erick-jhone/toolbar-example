package com.erick.appbarmenuexample.data;

import com.erick.appbarmenuexample.R;
import com.erick.appbarmenuexample.model.ItemList;

import java.util.ArrayList;

public class ItemListRepository {
    public static ArrayList<ItemList> getItemList() {
        ArrayList<ItemList> itemList = new ArrayList<>();

        itemList.add(new ItemList("Java", R.drawable.java__2_));
        itemList.add(new ItemList("PHP", R.drawable.php));
        itemList.add(new ItemList("C", R.drawable.letra_c));

        return itemList;
    }
}
