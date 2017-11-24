package hiepnguyen.nhcn;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 20/11/2017.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList name;
    public static Activity activity;


    public GridAdapter(Activity activity, ArrayList name) {
        this.activity = activity;
        this.name = name;

    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return name.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            view = vi.inflate(R.layout.grid_layout, null);
        }
        TextView textView = view.findViewById(R.id.namePlacer);
        ImageView imageView = view.findViewById(R.id.imageHolder);


        if (name.get(i).toString().equals("HOME")) {
            imageView.setImageResource(R.drawable.ic_restaurant_menu_black_48dp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentAdd = new Intent(activity, AddRestaurantActivitty.class);
                    activity.startActivity(intentAdd);
                }
            });
        } else if (name.get(i).toString().equals("NOTES")) {
            imageView.setImageResource(R.drawable.ic_event_note_black_48dp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentNote = new Intent(activity, NoteActivity.class);
                    activity.startActivity(intentNote);
                }
            });

        } else if (name.get(i).toString().equals("ABOUT")) {
            imageView.setImageResource(R.drawable.ic_assignment_ind_black_48dp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentSetting = new Intent(activity, AboutActivity.class);
                    activity.startActivity(intentSetting);
                }
            });
        } else if (name.get(i).toString().equals("SETTINGS")) {
            imageView.setImageResource(R.drawable.ic_settings_black_48dp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentSetting = new Intent(activity, SettingActivity.class);
                    activity.startActivity(intentSetting);
                }
            });
        }
        textView.setText(name.get(i).toString());
        return view;
    }
}
