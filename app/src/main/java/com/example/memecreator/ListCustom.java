package com.example.memecreator;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;

/**
 * Created by Sameer on 24/10/16.
 */

import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class ListCustom extends Activity {

    ListView list;
    String[] itemname ={
            "Willy Wonka",
            "Candy Crash",
            "Flurty",
            "Most Interesting Man",
            "Crazy Duck",
            "Lord of Toy",
            "Come on Pussy",
            "Pussy T"
    };

    Integer[] imgid={
            R.drawable.meme1,
            R.drawable.meme10,
            R.drawable.meme11,
            R.drawable.meme12,
            R.drawable.meme13,
            R.drawable.meme14,
            R.drawable.meme15,
            R.drawable.meme16,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
               /* Intent myIntent = new Intent(ListCustom.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", position);
                myIntent.putExtras(bundle);
                startActivityForResult(myIntent, 0);*/


            }
        });
    }





}