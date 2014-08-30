package com.winterdev.garagebid;

import com.winterdev.garagebid.AboutActivity.PlaceholderFragment;
import com.winterdev.garagebid.service.EventService;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class CountEventActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_count);

		// get the event count
		int eventCount = this.getEventCount();
		
		// set the text string
		String displayString = "Number of events: " + eventCount;
		
		// get the text view and display
		TextView countView = (TextView)this.findViewById(R.id.text_event_count);
		countView.setText(displayString);
		
		// auto generated
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	protected int getEventCount() {
//		return 100;
		return EventService.getAllEvents(this).size();
	}
		
}
