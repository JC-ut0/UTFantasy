package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import csc207.phase1.UTFantasy.R;

public class MenuActivity extends AppCompatActivity {

    String items[] = new String[]{"poison1","poison2","poison3","poison4","poison5","poison6"};
    String pokemons[] = new String[]{"pokemon1", "pokemon2","pokemon3","pokemon4","pokemon5"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybagitem);


        final ListView listView1 = (ListView) findViewById(R.id.list_view);
        final ListView listView2 = (ListView) findViewById(R.id.list_view2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemons);
        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
//        listView.setBackgroundColor(Color.LTGRAY);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MenuActivity.this, items[position], Toast.LENGTH_SHORT).show();
            }
        });
        listView1.setVisibility(View.INVISIBLE);
//        listView2.setVisibility(View.INVISIBLE);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    listView1.setVisibility(View.VISIBLE);
                    listView2.setVisibility(View.INVISIBLE);
//                    Toast.makeText(MenuActivity.this, "kkk", Toast.LENGTH_SHORT).show();
                }else{
                    listView1.setVisibility(View.INVISIBLE);
                    listView2.setVisibility(View.VISIBLE);
//                    Toast.makeText(MenuActivity.this, "www", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView textView = (TextView)findViewById(R.id.textView);

//        Switch switch1 = (Switch) findViewById(R.id.switch1);
//        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    listView1.setVisibility(View.VISIBLE);
//                    listView2.setVisibility(View.INVISIBLE);
////                    Toast.makeText(MenuActivity.this, "kkk", Toast.LENGTH_SHORT).show();
//                }else{
//                    listView1.setVisibility(View.INVISIBLE);
//                    listView2.setVisibility(View.VISIBLE);
////                    Toast.makeText(MenuActivity.this, "www", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });



    }
}
