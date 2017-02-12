package com.vipinkr.recyclerviewexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "MainActivity";
    ArrayList<Person> list = new ArrayList<Person>();
    RecyclerView rv;
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv=(RecyclerView)findViewById(R.id.recyclerView);
        createValues();
        rv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter=new RecyclerViewAdapter(list);

        rv.setAdapter(recyclerViewAdapter);
      //  rv.setItemAnimator(new DefaultItemAnimator());
        rv.addOnItemTouchListener(new RecyclerItemClickListener(this,rv,this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createValues() {
        Log.d(TAG, "createValues: creating values");

        Person p1 = new Person("Ronaldo", R.drawable.person1);
        list.add(p1);
        Person p2 = new Person("Julia", R.drawable.person2);
        list.add(p2);
        Person p3 = new Person("Ramos", R.drawable.person1);
        list.add(p3);

        Log.d(TAG, "createValues: list size: "+list.size());
    }

    @Override
    public void onClick(View view, int position) {
      //  Toast.makeText(this,"click at position :"+position,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"name of person: "+list.get(position).getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(View view, int position) {
        Toast.makeText(this,"long click at position :"+position,Toast.LENGTH_SHORT).show();
    }
}
