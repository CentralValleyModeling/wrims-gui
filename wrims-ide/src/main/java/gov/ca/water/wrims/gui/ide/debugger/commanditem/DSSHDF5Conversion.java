package gov.ca.water.wrims.gui.ide.debugger.commanditem;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import gov.ca.water.wrims.gui.ide.debugger.model.WPPDebugTarget;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class DSSHDF5Conversion extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WPPDebugTarget target = DebugCorePlugin.target;
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
		    Object firstEle = ssel.getFirstElement();
		    IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(firstEle,
		    		IFile.class);
		    if (ifile != null) {
		    	final String path = ifile.getRawLocation().toOSString();
		    	if (path.endsWith(".launch")){
					convertLaunch(path);
				}else if (path.endsWith(".config")){
					convertConfig(path);
				}
		    }
		}
		return null;
	}
	
	public void convertLaunch(String fn){
		try {
			String conversionFileName="DssHDF5Converter_Launch.bat";
			FileWriter conversionFile = new FileWriter(conversionFileName);
			PrintWriter out = new PrintWriter(conversionFile);
			out.println("@echo off");
			out.println();
			out.println("set path=lib;%path%");
			out.println("set temp_wrims2=jre\\bin");
			out.println();
			out.println("jre\\bin\\java -Xmx4096m -Xss1024K -XX:+CreateMinidumpOnCrash -Duser.timezone=Etc/GMT+8 -Djava.library.path=\"lib\" -cp \"lib\\external;lib\\*\" wrimsv2.hdf5.DSSHDF5Converter -launch="+fn);
			out.close();
			Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "start", "/w", conversionFileName}, 
					null, null); 
		} catch (IOException e) {
			WPPException.handleException(e);
		}
	}
	
	public void convertConfig(String fn){
		try {
			String conversionFileName="DssHDF5Converter_Config.bat";
			FileWriter conversionFile = new FileWriter(conversionFileName);
			PrintWriter out = new PrintWriter(conversionFile);
			out.println("@echo off");
			out.println();
			out.println("set path=lib;%path%");
			out.println("set temp_wrims2=jre\\bin");
			out.println();
			out.println("jre\\bin\\java -Xmx4096m -Xss1024K -XX:+CreateMinidumpOnCrash -Duser.timezone=Etc/GMT+8 -Djava.library.path=\"lib\" -cp \"lib\\external;lib\\*\" wrimsv2.hdf5.DSSHDF5Converter -config="+fn);
			out.close();
			Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "start", "/w", conversionFileName}, 
					null, null); 
		} catch (IOException e) {
			WPPException.handleException(e);
		}
	}
}
