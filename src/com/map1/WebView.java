package com.map1;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.webkit.WebViewClient;
/*
public class WebView extends Activity implements LocationListener {
	private static final String MAP_URL = "http://gmaps-samples.googlecode.com/svn/trunk/articles-android-webmap/simple-android-map.html";
	private WebView webView;

	@Override
	/** Called when the activity is first created. **/

/*
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map2);
		setupWebView();
		getLocation();
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	/** Sets up the WebView object and loads URL of the page **/

/*
	private void setupWebView() {
		final String centerURL = "javascript:centerAt(" + 
								mostRecentLocation.getLatitude() + "," +
								mostRecentLocation.getLongitude() + ")";
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnable(true);
		//Wait for the page to load then send the location information
		
		webView.setWebViewClient(new WebViewClient() 
		
		{
			@Override
			public void onPageFinished(WebView view, String url) {
				webView.loadUrl(centerURL);
			}
		});
				
		webView.loadUrl(MAP_URL);
		
		//Allows JavaScript Calls to access application resources
		
		webView.addJavascriptInterface(new JavaScriptInterface(),"android");
	}
	
	/** Sets up the interface for getting access  to Latitude and Longitude data from device **/

/*
	
	private class JavaScriptInterface {
		public double getLatitude() {
			return mostRecentLocation.getLatitude();
		}
		public double getLongitude() {
			return mostRecentLocation.getLongitude();
		}
	}
	
	private void getLocation() {
		LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		
		String provider = locationManager.getBestProvider(criteria,true);
		
		//In order to make suer the device is getting the location, request updates.
		
		locationManager.requestLocationUpdates(provider,1,0,this);
		mostRecentLocation = locationManager.getLastKnownLocation(provider);
	}
}
*/