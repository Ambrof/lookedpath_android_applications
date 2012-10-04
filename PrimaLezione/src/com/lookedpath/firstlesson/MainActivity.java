package com.lookedpath.firstlesson;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void goToNext (View view) {
    	setContentView(R.layout.next);
    }
    public void goToMain (View view) {
    	setContentView(R.layout.activity_main);
    }
    public void goToInfo (View view) {
    	setContentView(R.layout.info);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings: 
            startActivity(new Intent(this, About.class));
        }
        return true;
    }

}
