package com.winterdev.garagebid;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        // add the listeners for the buttons
        View aboutButton = this.findViewById(R.id.button_about);
        aboutButton.setOnClickListener(this);
        View countButton = this.findViewById(R.id.button_count_event);
        countButton.setOnClickListener(this);
        View listEventButton = this.findViewById(R.id.button_list_event);
        listEventButton.setOnClickListener(this);
        
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

    /**
     * listen for button clicks
     * 
     */
    public void onClick(View view) {
    	Intent intent;
    	switch (view.getId()) {
    		case R.id.button_about:
    			intent = new Intent(this, AboutActivity.class);
    			this.startActivity(intent);
    			break;
    		case R.id.button_count_event:
    			intent = new Intent(this, CountEventActivity.class);
    			this.startActivity(intent);
    			break;
    		case R.id.button_list_event:
    			intent = new Intent(this, EventListViewActivity.class);
    			this.startActivity(intent);
    			break;
    	}
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
