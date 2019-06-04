package in.aroliant.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView expanderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        expanderRecyclerView = findViewById(R.id.recyclerView);

        initiateExpander();

    }


    private void initiateExpander() {

        ArrayList<String> parentList = new ArrayList<>();
        ArrayList<ArrayList> childListHolder = new ArrayList<>();

        parentList.add("Fruits & Vegetables");
        parentList.add("Beverages & Health");
        parentList.add("Home & Kitchen");

        ArrayList<String> childList = new ArrayList<>();
        childList.add("Apple");
        childList.add("Mango");
        childList.add("Banana");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Red bull");
        childList.add("Maa");
        childList.add("Horlicks");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Knife");
        childList.add("Vessels");
        childList.add("Spoons");

        childListHolder.add(childList);

        ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter =
                new ExpandableRecyclerViewAdapter(getApplicationContext(), parentList,
                        childListHolder);

        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter);
    }

}
