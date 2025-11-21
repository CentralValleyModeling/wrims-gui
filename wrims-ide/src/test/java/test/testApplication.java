package test;

import java.io.IOException;
import gov.ca.water.wrims.gui.ide.debugger.ContactDebugger;

public class testApplication {
	
	public static void main(String arg[]) throws IOException{
		int requestPort=Integer.parseInt(arg[0]);
		int eventPort=Integer.parseInt(arg[1]);
		ContactDebugger run=new ContactDebugger(requestPort, eventPort);
	}
}
