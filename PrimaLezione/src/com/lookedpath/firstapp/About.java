package com.lookedpath.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class About extends Activity { 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }
    
    public void goToSite (View view) {
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http://www.lookedpath.tk"));
    	startActivity(intent);
    }
}
