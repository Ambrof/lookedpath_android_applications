package com.lookedpath.firstlesson;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
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
	    

	    public void goToUpdate (View v) {
	    	new connection().execute();
	    }
	    
	    public class connection extends AsyncTask<Void, Void, Boolean> {
            


			protected Boolean doInBackground(Void...params) {
            	 boolean updated=false;
                 final String URL = "http://www.lookedpath.tk/apps/firstapp/version.xml";
                 final String VERSION = "version";
                 XMLParser parser = new XMLParser();
                 String xml = parser.getXmlFromUrl(URL); // getting XML
                 Document doc = parser.getDomElement(xml); // getting DOM element
          
                 NodeList nl = doc.getElementsByTagName(VERSION);
                 Element e = (Element) nl.item(0);
                 String version = parser.getValue(e, VERSION); // name child value
                 String actver = getString(R.string.version);
                 if(actver==version){ updated=true; 
                 
            }
                 return updated;
            }
            protected void onPostExecute(Boolean updated) {
            	if(updated==false){
                	testo2.setText(R.string.newversion);
                } else {
                        testo2.setText(R.string.nonewversion);
                }
            	
            }
            
	    
            
	    }
	}
            
                   	    		
     	    

        
       


 
	
        
	    
	    
	    
		
	    



