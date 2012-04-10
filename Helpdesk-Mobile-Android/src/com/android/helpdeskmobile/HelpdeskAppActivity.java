package com.android.helpdeskmobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HelpdeskAppActivity extends ListActivity {
	/* Global variables for the activity go here. */

	/* Called when the activity is first created. */
	@Override	    
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String[] actions = getResources().getStringArray(R.array.Actions);
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, actions));
	    ListView lv = getListView();
	    lv.setTextFilterEnabled(true);
	    lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
			}
	    	});
	    }	
	    
	    // TODO Finish method.  Not much will be going here though, because this app doesn't really need to update anything.
	
	/* Listener invokes the ACTION_CALL intent when the user wants to call the Helpdesk. */
	private class phoneButtonListener implements OnClickListener {
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(null); // TODO: Check whether or not this line works (provided null as context).
			builder.setMessage("Before calling the Helpdesk, make sure that you're ready to:\nAre you ready to proceed?")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			    	   public void onClick(DialogInterface dialog, int which) {
						// TODO Call the intent to call the Helpdesk number.
			    	   }
			       })
			       .setNegativeButton("No", new DialogInterface.OnClickListener() { // User is not ready to call, cancel the dialog.
			    	   public void onClick(DialogInterface dialog, int which) {
			    		   dialog.cancel();
			    	   }
			       });
			AlertDialog alert = builder.create(); // Creates the dialog.
		}
	}
	
	/* Listener invokes the e-mail intent when the user wants to e-mail the helpdesk. */
}
