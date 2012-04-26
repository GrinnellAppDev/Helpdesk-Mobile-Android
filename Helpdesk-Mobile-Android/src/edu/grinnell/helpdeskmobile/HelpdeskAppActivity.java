package edu.grinnell.helpdeskmobile;

import edu.grinnell.helpdeskmobile.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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

				switch (position) {

				// call helpdesk
				case 0:
					try {
						Intent callIntent = new Intent(Intent.ACTION_CALL);
						callIntent.setData(Uri.parse("tel:+16412694400"));
						startActivity(callIntent);
					} catch (Exception e) {
						Log.e("Helpdesk Mobile", "Failed to invoke call", e);
					}
					break;

					// TODO: text helpdesk
				case 1:
					Intent textIntent = new Intent(Intent.ACTION_VIEW);
					textIntent.setType("vnd.android-dir/mms-sms");
					textIntent.putExtra("address", "16419904687");
				//	smsIntent.putExtra("sms_body","Body of Message");
					startActivity(textIntent);

					break;

					// TODO: email helpdesk
				case 2:
					Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);  

					String aEmailList[] = { "helpdesk@grinnell.edu" };  
					// String aEmailCCList[] = { "user3@fakehost.com","user4@fakehost.com"};  
					// String aEmailBCCList[] = { "user5@fakehost.com" };  

					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);  
					// emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);  
					// emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);  

					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My subject");  

					emailIntent.setType("plain/text");  
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "My message body.");  
					
					startActivity(Intent.createChooser(emailIntent, "Send your email in:"));  
					// startActivity(emailIntent);
					break;

					// TODO: chat with helpdesk
				case 3:
					Context context3 = getApplicationContext();
					CharSequence text3 = "meebo chat with TC placeholder";
					int duration3 = Toast.LENGTH_SHORT;
					Toast toast3 = Toast.makeText(context3, text3, duration3);
					toast3.show();
					break;
				}
			}
		});
	}	

	// old attempt at doing action listeners
	// TODO Finish method.  Not much will be going here though, because this app doesn't really need to update anything.

	/* Listener invokes the ACTION_CALL intent when the user wants to call the Helpdesk. */
	/*private class phoneButtonListener implements OnClickListener {
		public void onClick(View v) {


			try {
				Intent intent = new Intent();
				intent.setData(Uri.parse("tel:6412694400"));
				startActivity(intent);
			} catch (Exception e) {
				Log.e("SampleApp", "Failed to invoke call", e);
			}



			/*AlertDialog.Builder builder = new AlertDialog.Builder(null); // TODO: Check whether or not this line works (provided null as context).
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
			AlertDialog alert = builder.create(); // Creates the dialog.*/
	//	}
}

/* Listener invokes the e-mail intent when the user wants to e-mail the helpdesk. */
//}
