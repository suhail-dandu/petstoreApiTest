package main;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import supportFiles.ExtentManager;
import supportFiles.GlobalConstants;
import supportFiles.GlobalVariables;
import supportFiles.GenerateTestNGFile;



public class Initiator {	
	
	public static void main(String[] args) {
		
		try{	
			BasicConfigurator.configure();				
			PropertyConfigurator.configure("log4j.properties");
			GlobalConstants.currentReportFolderName="Report";
			GlobalConstants.currentReportFolderPath= GlobalConstants.exec_report_path + GlobalConstants.currentReportFolderName;		
			new File(GlobalConstants.currentReportFolderPath).mkdir();		
			GlobalConstants.executionReportName=GlobalConstants.currentReportFolderPath + "/REPORT_"+GlobalVariables.getTimestamp() +".html";
			GlobalConstants.extent=ExtentManager.getReporter(GlobalConstants.executionReportName);
			
			String mavenExecutionTag = System.getProperty("executionTag");
			if(mavenExecutionTag == null)
				mavenExecutionTag = "petstore";
			
			GenerateTestNGFile.createTestNG(mavenExecutionTag);							
		
			GenerateTestNGFile.runTestNG(GlobalConstants.testng_xml_filename);		
		}catch(Throwable e){			
			
			System.out.println("###***Exception in Initiator***###: " + e.toString());
			e.printStackTrace();		
			
		}
	}	
		
}