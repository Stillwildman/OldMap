package com.map1;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class XmlParser extends Activity {
	
		Bundle planName = this.getIntent().getExtras();
		String planN = planName.getString("planN");
	
	public static PlanVO parse(String echoResult) {

		Log.i("Brack", "XmlParser.parse");
		
		PlanVO planVO = new PlanVO();
		
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();

			parser.setInput(new StringReader(echoResult));

			int eventType = parser.getEventType();

			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				
				case XmlPullParser.START_DOCUMENT:
					break;

				case XmlPullParser.START_TAG:
					String tagName = parser.getName();
					
					if (tagName.equals("plan")) {
							Log.i("Brack", "plan= " + parser.getAttributeValue(0));
							planVO.setPlan(parser.getAttributeValue(0));
								if(parser.getAttributeName(1).equals("planid")){
									Log.i("Brack", "planid= " + parser.getAttributeValue(1));
									planVO.setPid(parser.getAttributeValue(1));
								}
						}
					
					if (tagName.equals("spot")) {
							Log.i("Brack", "planItem= " + parser.getAttributeValue(0));
								if(parser.getAttributeName(0) != null){
									Log.i("Brack", "data-spot= " + parser.getAttributeValue(0));
									planVO.setSpot(parser.getAttributeValue(0));
								}
								if(parser.getAttributeName(1).equals("data-lat")){
									Log.i("Brack", "data-lat= " + parser.getAttributeValue(1));
									planVO.setLat(parser.getAttributeValue(1));
								}
								if(parser.getAttributeName(2).equals("data-lng")){
									Log.i("Brack", "data-lng= " + parser.getAttributeValue(2));
									planVO.setLng(parser.getAttributeValue(2));
								}
								if(parser.getAttributeName(3).equals("planid")){
									Log.i("Brack", "planid= " + parser.getAttributeValue(3));
									planVO.setSpotPid(parser.getAttributeValue(3));
								}
						}
					/*			
					if (tagName.equals("lat")) {
							Log.i("Brack", "lat= " + parser.getAttributeValue(0));
							planVO.setLat(parser.getAttributeValue(0));
						}
					if (tagName.equals("lng")) {
							Log.i("Brack", "lng= " + parser.getAttributeValue(0));
							planVO.setLng(parser.getAttributeValue(0));
						}
					 */
					break;
				case XmlPullParser.END_TAG:
					break;
				case XmlPullParser.END_DOCUMENT:
					break;
				}

				eventType = parser.next();
			}

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return planVO;
	}
}