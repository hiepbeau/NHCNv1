package hiepnguyen.nhcn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> basicFields;
    GridView gridView;
    GridAdapter adapter;
    public static DBHandle dbHandle;

    public static ArrayList<String> divisions;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicFields = new ArrayList<>();
        dbHandle = new DBHandle(this);
        activity = this;
        getSupportActionBar().show();


        divisions = new ArrayList<>();
        divisions.add("Take-out");
        divisions.add("Sit-down");
        divisions.add("Delivery");

        gridView = (GridView) findViewById(R.id.grid);

        basicFields.add("HOME");
        basicFields.add("NOTES");
        basicFields.add("SETTINGS");
        basicFields.add("ABOUT");

        adapter = new GridAdapter(this, basicFields);
        gridView.setAdapter(adapter);

    }

    public void loadAbout(MenuItem item) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}
