package com.async.demo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;


public class AsyncTaskDemo extends ListActivity {
	NotificationData notification;
	private static String[] items = { "Joseph", "George", "Mary", "Antony", "Albert",
			"Michel", "John", "Abraham", "Mark", "Savior", "Kristopher",
			"Thomas", "Williams", "Assisi", "Sebastian", "Aloysius", "Alex", "Daniel",
			"Anto", "Alexandar", "Brito", "Robert", "Jose",
			"Paul", "Peter"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//create object
		
		notification=new NotificationData(this);
		
		ListView lv = getListView();
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, new ArrayList()));

		new AddStringTask().execute();
	}

	class AddStringTask extends AsyncTask<Void, String, Void> {
		@Override
		protected Void doInBackground(Void... unused) {
			//for (String item : items) {
			for(int i=0;i<10;i++)
			{
				publishProgress(items[i]);
			}
				SystemClock.sleep(5000);
			//}

			return (null);
		}

		@Override
		protected void onProgressUpdate(String... item) {
			((ArrayAdapter) getListAdapter()).add(item[0]);
		}

		@Override
		protected void onPostExecute(Void unused) {
			setSelection(3);
			Toast.makeText(AsyncTaskDemo.this, "Done!", Toast.LENGTH_SHORT).show();
			notification.SetNotification(R.drawable.icon, "Notification Title", "Click to open", AsyncTaskDemo.class);
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    CheckedTextView check = (CheckedTextView)v;
	    check.setChecked(!check.isChecked());
	}

	
}