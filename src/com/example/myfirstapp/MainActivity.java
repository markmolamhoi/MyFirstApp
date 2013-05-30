package com.example.myfirstapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.detectDiskReads().detectDiskWrites().detectNetwork() // or
																			// .detectAll()
																			// for
																			// all
																			// detectable
																			// problems
					.penaltyLog().build());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Called when the user clicks the Send button
	 * 
	 * @throws MalformedURLException
	 */
	public void sendMessage(View view) throws MalformedURLException {

		// Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		// EditText editText = (EditText) findViewById(R.id.edit_message);
		// String message = editText.getText().toString();

		String TargetURL = "http://hio.azurewebsites.net/api/items";

		String lsPage = "";
		/*
		 * Method1 - Rest RestClient aa = new RestClient();
		 * 
		 * try { aa.Execute(RestClient.RequestMethod.GET,
		 * "http://hio.azurewebsites.net/api/items", null, null); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * intent.putExtra(EXTRA_MESSAGE, aa.response);
		 */

		lsPage = LIB.GetDataFromURL(TargetURL);

		intent.putExtra(EXTRA_MESSAGE, lsPage);

		startActivity(intent);
	}

}
