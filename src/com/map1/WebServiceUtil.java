package com.map1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class WebServiceUtil {
	static final String ServiceName = "http://go.rritw.com/WebXml.com.cn/";
	static final String ServiceURL = "http://go.rritw.com/webservice.webxml.com.cn/WebServices/WeatherWS.asmx";
	
	public static List<String> getProvinceList() {
		//TODO Auto-generated method stub
		String methodName = "getRegionProvince";
		HttpTransportSE ht = new HttpTransportSE(ServiceURL);
		ht.debug = true;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		SoapObject SO = new SoapObject(ServiceName, methodName);
		envelope.bodyOut = SO;
		envelope.dotNet = true;
		
		try {
			//Using Web Service
			ht.call(ServiceName + methodName, envelope);
			
			if (envelope.getResponse() != null) {
			//Get the server return SOAP
				SoapObject result = (SoapObject) envelope.bodyIn;
				SoapObject detail = (SoapObject) result.getProperty(methodName + "Result");
			//Resolve the SOAP's information from server
				return parseProvinceOrCity(detail);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(XmlPullParserException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<String> parseProvinceOrCity(SoapObject detail) {
		//TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < detail.getPropertyCount(); i++) {
			//Resolve every provinces
			result.add(detail.getProperty(i).toString().split(",")[0]);
		}
		return result;
	}
}
