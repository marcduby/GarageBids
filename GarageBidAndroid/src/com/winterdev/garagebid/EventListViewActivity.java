package com.winterdev.garagebid;

import java.util.ArrayList;
import java.util.List;

import com.winterdev.garagebid.AboutActivity.PlaceholderFragment;
import com.winterdev.garagebid.domain.Event;
import com.winterdev.garagebid.service.EventService;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_listview);

		// display the list of event
		this.displayListView();
	}

	protected void displayListView() {
		// get the list if events
		List<Event> eventList = EventService.getAllEvents(this);
		
		// convert the event list into a list of strings
		List<String> stringList = new ArrayList<String>();
		for (Event event : eventList) {
			stringList.add(event.getStreet());
		}
		
		// create an array adapter for the list view to use
		final ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);
		
		// bind the array adapter to the list view
		ListView listView = (ListView)this.findViewById(R.id.event_listview);
		listView.setAdapter(stringAdapter);
	}
}
