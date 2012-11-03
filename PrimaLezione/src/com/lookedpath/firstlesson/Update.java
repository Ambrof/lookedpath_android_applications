package com.lookedpath.firstlesson;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
	
	public class Update extends ListActivity {
		private TextView testo2;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        testo2= (TextView) findViewById(R.id.textView2);
	        
	    }
		static final String URL = "http://www.lookedpath.tk/apps/firstapp/version.xml";
		static final String VERSION = "version";
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element
	 
		NodeList nl = doc.getElementsByTagName(VERSION);
		Element e = (Element) nl.item(0);
		public String version = parser.getValue(e, VERSION); // name child value
		public void a() {
		String actver = getString(R.string.version);
		if(actver!=version) {
	    		testo2.setText(R.string.newversion);
	    	} else {
	    		testo2.setText(R.string.nonewversion);
	    	}
			
		}
		}
	



