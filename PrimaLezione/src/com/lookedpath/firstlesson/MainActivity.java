package com.lookedpath.firstlesson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
	private TextView testo;
	private boolean  next=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testo= (TextView) findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void goToNext (View view) {
    	if(next==false) {
    		next=true;
    		testo.setText(R.string.next);
    	} else {
    		next=false;
    		testo.setText(R.string.first);
    	}

    }
    public void goToInfo (View view) {
    	setContentView(R.layout.info);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if  (item.getItemId()==R.id.menu_settings) startActivity(new Intent(this, About.class));
        return true;
    }

}
