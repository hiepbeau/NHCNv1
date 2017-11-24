package hiepnguyen.nhcn;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 22/11/2017.
 */

public class DBHandle {

    SQLiteDatabase database;
    Activity activity;

    public DBHandle(Activity activity) {
        this.activity = activity;

        database = activity.openOrCreateDatabase("ASSIST", activity.MODE_PRIVATE, null);
        createTable();
    }

    private void createTable() {
        try {
            String queryRes = "CREATE TABLE IF NOT EXISTS restaurants (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, type TEXT);";
            database.execSQL(queryRes);
        } catch (Exception e) {
            Toast.makeText(activity, "Error Occured for create table", Toast.LENGTH_LONG).show();

        }

        try {
            String queryNote = "CREATE TABLE IF NOT EXISTS NOTES(title varchar(100) not null," +
                    "body varchar(10000), cls varchar(1000), sub varchar(1000), datex TIMESTAMP default CURRENT_TIMESTAMP);";
            database.execSQL(queryNote);
        } catch (Exception e) {
            Toast.makeText(activity, "Error Occured for create table", Toast.LENGTH_LONG).show();

        }

    }

    public boolean execAction(String query) {
        Log.i("dbHandle", query);
        try {
            database.execSQL(query);
        } catch (Exception e) {
            Log.e("dbHandle", query);
            Toast.makeText(activity, "Error Occured for execAction", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public Cursor execQuery(String query) {
        try {
            return database.rawQuery(query, null);
        } catch (Exception e) {
            Log.e("dbHandle", query);
            //      Toast.makeText(activity,"Error Occured for execAction",Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
