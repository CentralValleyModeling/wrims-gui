package main;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;

import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyParser;


public class StudyCheckerForWresl {
	
	
	public static void main(String[] args) throws RecognitionException, IOException {

		String f;
		
		if (args.length > 0 ){
			f = args[0];
		} else {
			f = "D:\\cvwrsm\\trunk\\wrims_v2\\converter\\src\\test\\TestWreslWalker_mainFile2.wresl";
		}
		
		//System.out.println("main file: "+f);

		LogUtils.setLogFile("studyChecker.log");
		StudyParser.processMainFileIntoStudyConfig(f);
		//StudyParser.parseSubFiles(sc);
		

		
		LogUtils.closeLogFile();
		

	}

}
