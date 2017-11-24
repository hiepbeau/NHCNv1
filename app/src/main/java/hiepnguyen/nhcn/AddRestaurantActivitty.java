package hiepnguyen.nhcn;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddRestaurantActivitty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant_activitty);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
        assert fab != null;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Add.class);
                startActivity(intent);
            }
        });
    }
}
