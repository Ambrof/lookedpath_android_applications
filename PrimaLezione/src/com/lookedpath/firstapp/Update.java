package com.lookedpath.firstapp;
 
 
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
 
 
       
public class Update extends Activity {
    private TextView testo2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.update);
        super.onCreate(savedInstanceState);
        testo2= (TextView) findViewById(R.id.textView2);

    }
    public void goToUpdate (View view) {
        new connection().execute();
    }
    public class connection extends AsyncTask<Void, Void, Boolean> {
        protected Boolean doInBackground(Void... params) {
             boolean updated=false;
             String lastversion=null;
             String actver=null;
             Element e=null;
             final String URL = "http://www.lookedpath.tk/apps/firstapp/version.xml";
             final String VERSION = "version";
             final String APPLICATION = "application";
             XMLParser parser = new XMLParser();
             String xml = parser.getXmlFromUrl(URL); // getting XML
             Document doc = parser.getDomElement(xml); // getting DOM element

             NodeList nl = doc.getElementsByTagName(APPLICATION);
             for (int i=0;i<nl.getLength();i++) {
                e = (Element) nl.item(0);
                lastversion = parser.getValue(e, VERSION); // name child value
             }

             try {
            	   actver = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            	} catch (NameNotFoundException err) {
            	    Log.e("tag", err.getMessage());
            	}
             if(actver.equals(lastversion)) {
            	 updated=true;
             }
                          

             return updated;
        }
        protected void onPostExecute(Boolean result) {
            if(result==false){
                testo2.setText(R.string.newversion);
            } else {
                testo2.setText(R.string.nonewversion);
            }
        }

    };

}