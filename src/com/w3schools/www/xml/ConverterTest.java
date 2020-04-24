package com.w3schools.www.xml;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.w3schools.www.xml.TempConvertStub.CelsiusToFahrenheit;
import com.w3schools.www.xml.TempConvertStub.CelsiusToFahrenheitResponse;

public class ConverterTest {

	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(System.in);
			
			TempConvertStub converter = new TempConvertStub("https://www.w3schools.com/xml/tempconvert.asmx?wsdl");
			
			CelsiusToFahrenheit cf = new CelsiusToFahrenheit();
			System.out.print("Celsius: ");
			String celsius = in.next();
			cf.setCelsius(celsius);
			
			CelsiusToFahrenheitResponse response = converter.celsiusToFahrenheit(cf);
			String result = response.getCelsiusToFahrenheitResult();

			System.out.println("Fahrenheit: " + result);
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
