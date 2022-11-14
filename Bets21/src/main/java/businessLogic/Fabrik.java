package businessLogic;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class Fabrik {

	public Fabrik() {
		
	}

	public BLFacade crearBL() {
	ConfigXML c=ConfigXML.getInstance();
	Locale.setDefault(new Locale(c.getLocale()));
	System.out.println("Locale: "+Locale.getDefault());
	MainGUI a=new MainGUI();
	a.setVisible(true);
	try {
		
		BLFacade appFacadeInterface;
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		if (c.isBusinessLogicLocal()) {
			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			appFacadeInterface=new BLFacadeImplementation(da);
			return appFacadeInterface;
		}
		else { //If remote
			 String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
			URL url = new URL(serviceName);
	        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
	        Service service = Service.create(url, qname);
	         appFacadeInterface = service.getPort(BLFacade.class);
		} 
		MainGUI.setBussinessLogic(appFacadeInterface);
	return appFacadeInterface;
	}catch (Exception e) {
		a.jLabelSelectOption.setText("Error: "+e.toString());
		a.jLabelSelectOption.setForeground(Color.RED);	
		System.out.println("Error in ApplicationLauncher: "+e.toString());
	}
 return null;
}

}
	
	
	
	

