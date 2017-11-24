package hiepnguyen.nhcn;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter adapter;
    ArrayList titles;
    ArrayList contents;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        titles = new ArrayList();
        contents = new ArrayList();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_Note);

        assert fab != null;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, NoteCreate.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.noteList);


        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titles.get(i).toString());
        alert.setMessage(contents.get(i).toString());
        alert.setPositiveButton("OK", null);
        alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_menu, menu);
        return true;
    }

    public void refreshNote(MenuItem item) {
    }
}
