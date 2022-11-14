package gui;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.Fabrik;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		BLFacade	blFacade =	(new Fabrik()).crearBL();
}
}
