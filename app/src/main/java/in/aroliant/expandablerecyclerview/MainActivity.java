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

        ArrayList<String> childNameList = new ArrayList<>();
        childNameList.add("Apple");
        childNameList.add("Mango");
        childNameList.add("Banana");

        childListHolder.add(childNameList);

        childNameList = new ArrayList<>();
        childNameList.add("Red bull");
        childNameList.add("Maa");
        childNameList.add("Horlicks");

        childListHolder.add(childNameList);

        childNameList = new ArrayList<>();
        childNameList.add("Knife");
        childNameList.add("Vessels");
        childNameList.add("Spoons");

        childListHolder.add(childNameList);

        ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter =
                new ExpandableRecyclerViewAdapter(getApplicationContext(), parentList,
                        childListHolder);

        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter);
    }

}
