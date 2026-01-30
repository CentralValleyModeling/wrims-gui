package gov.ca.water.wrims.gui.ide.debugger.msr;

import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import gov.ca.water.wrims.gui.ide.tools.FileProcess;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.eclipse.debug.core.ILaunchConfiguration;

public class MSRUtil {
	
	public static int[] loadMSDuration(String fileName, ILaunchConfiguration config){
		ArrayList<Integer> durations=new ArrayList<Integer>();
		
		String fileAbsPath;
		if (new File(fileName).isAbsolute()){
			fileAbsPath = fileName;
		}else{
			fileAbsPath = FileProcess.procRelativePath(fileName, config);
		}
		
		File file=new File(fileAbsPath);
		if (file.exists()){
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
						
				String line=br.readLine();
				if (line==null) return new int[]{12};
				
				boolean isEnd=false;
				while ((line = br.readLine()) != null && !isEnd) {
					line=line.trim().toLowerCase();
					if (line.equals("")){
						isEnd=true;
					}else{
						int duration=Integer.parseInt(line);
						durations.add(duration);
					}
				}
				fr.close();
				
				int[] durationArray = new int[durations.size()];
				for (int i = 0; i < durationArray.length; i++) {
				    durationArray[i] = durations.get(i);
				}
				return durationArray;
			} catch (Exception e) {
				WPPException.handleException(e);
				return new int[]{12};
			}
		}else{
			return new int[]{12};
		}
	}
	
	public static int[] loadMSDuration(String fileName, String launchFilePath){
		ArrayList<Integer> durations=new ArrayList<Integer>();
		
		String fileAbsPath;
		if (new File(fileName).isAbsolute()){
			fileAbsPath = fileName;
		}else{
			fileAbsPath = FileProcess.procRelativePath(fileName, launchFilePath);
		}
		
		File file=new File(fileAbsPath);
		if (file.exists()){
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
						
				String line=br.readLine();
				if (line==null) return new int[]{12};
				
				boolean isEnd=false;
				while ((line = br.readLine()) != null && !isEnd) {
					line=line.trim().toLowerCase();
					if (line.equals("")){
						isEnd=true;
					}else{
						int duration=Integer.parseInt(line);
						durations.add(duration);
					}
				}
				fr.close();
				
				int[] durationArray = new int[durations.size()];
				for (int i = 0; i < durationArray.length; i++) {
				    durationArray[i] = durations.get(i);
				}
				return durationArray;
			} catch (Exception e) {
				WPPException.handleException(e);
				return new int[]{12};
			}
		}else{
			return new int[]{12};
		}
	}
}
