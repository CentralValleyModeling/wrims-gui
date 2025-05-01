
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_calsim3 {
	
	public String projectPath = "src\\test\\test_wreslparser\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;	
	
	@Test(groups = { "WRESL_Calsim3" })
	public void firstCycle() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_calsim3_firstCycle";
		inputFilePath = "D:\\CALSIM30_041311_BO\\CONV\\Run\\mainCONV_30.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		
		/// get the model name of the first cycle
		String modelName = sd.getModelList().get(0);
		
		/// write model data to csv files
		WriteCSV.dataset(sd.getModelDataSetMap().get(modelName),csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}
	
	@Test(groups = { "WRESL_Calsim3" })
	public void calsim3_full_study() throws RecognitionException, IOException {
		
		csvFolderPath = "TestWreslWalker_calsim3_full_study";
		inputFilePath = "D:\\CALSIM30_041311_BO\\CONV\\Run\\mainCONV_30.wresl";
		logFilePath = csvFolderPath+".log";
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		
		/// temporary dataset, don't use this because the structure will be changed soon. 
		LogUtils.setLogFile(logFilePath);
		TempData td = new TempData();
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		LogUtils.closeLogFile();
		
		
		/// write to StudyDataSet
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
				
		/// write full study data to csv files
		WriteCSV.study(sd, csvFolderPath ) ;
	
		Assert.assertEquals(1, 0);	
		
	}	
}
