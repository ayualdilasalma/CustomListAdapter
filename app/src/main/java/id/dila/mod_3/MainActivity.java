package id.dila.mod_3;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] arrNamaKomponen;
    String[] arrDesc;
    TypedArray arrGambar;
    List<Komponen> listKomponen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        listKomponen = new ArrayList<>();
        arrNamaKomponen = getResources().getStringArray(R.array.arrKomponen);
        arrDesc = getResources().getStringArray(R.array.arrDesc);
        arrGambar = getResources().obtainTypedArray(R.array.kompPict);

        for (int i = 1; i < arrNamaKomponen.length; i++ ) {
            Komponen item = new Komponen(arrNamaKomponen[i], arrDesc[i], arrGambar.getResourceId(i, -1));
            listKomponen.add(item);
        }

        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, listKomponen);
        listView.setAdapter(adapter);
        arrGambar.recycle();

//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrMenu));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 : startActivity(new Intent(MainActivity.this, ButtonActivity.class)) ;
                             break;
                    case 1 : startActivity(new Intent(MainActivity.this, EditTextActivity.class));
                             break;
                    case 2 : startActivity(new Intent(MainActivity.this, CheckboxActivity.class));
                             break;
                    case 3 : startActivity(new Intent(MainActivity.this, RadioButtonActivity.class));
                             break;
                    case 4 : startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
                             break;
                    case 5 : startActivity(new Intent(MainActivity.this, PickerActivity.class));
                             break;
                    case 6 : startActivity(new Intent(MainActivity.this, StudiKasusActivity.class));
                             break;
                }
            }
        });
    }
}
