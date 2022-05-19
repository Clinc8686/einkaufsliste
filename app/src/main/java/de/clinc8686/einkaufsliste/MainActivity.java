package de.clinc8686.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = getResources().getStringArray(R.array.shoppingListCompleter);  //get string resources
        ids = new int[]{ R.id.shopping1, R.id.shopping2, R.id.shopping3, R.id.shopping4, R.id.shopping5 };  //get ids from AutoCompleteTextViews
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        //add to all ids the adapter
        for (int id : ids) {
            AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(id);
            actv.setTextColor(Color.BLACK);
            actv.setAdapter(adapter);
            actv.setThreshold(1);
        }
    }

    //print toast
    public void printToast(View view) {
        StringBuilder string = new StringBuilder();

        for (int id : ids) {
            AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(id);
            if (actv.getText().length() > 0) {
                string.append(actv.getText()).append(", ");
            }
        }
        Toast.makeText(MainActivity.this, string.deleteCharAt(string.length()-2), Toast.LENGTH_LONG).show();
    }
}