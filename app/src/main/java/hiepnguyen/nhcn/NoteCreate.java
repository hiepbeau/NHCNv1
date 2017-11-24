package hiepnguyen.nhcn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NoteCreate extends AppCompatActivity {
    EditText title, body;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);


        Button btn = (Button) findViewById(R.id.noteSaveButton);

        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        spinner = (Spinner) findViewById(R.id.pinSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }


}
