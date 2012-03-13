package com.android.helpdeskmobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class HelpdeskAppActivity extends Activity {
	/* Global variables for the activity go here. */

	/* Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	}
	
	private class phoneButtonListener implements OnClickListener {
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Before calling the Helpdesk, make sure that you're ready to:\nAre you ready to proceed?")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			    	   public void onClick(DialogInterface dialog, int which) {
						// TODO Call the intent to call the Helpdesk number.
			    	   }
			       })
			       .setNegativeButton("No", new DialogInterface.OnClickListener() { // User is not ready to call, cancel the dialog.
			    	   public void onClick(DialogInterface dialog, int which)
			    		   dialog.cancel();
			    	   }
			       });
			AlertDialog alert = builder.create(); // Creates the dialog.
		}
	}
}
