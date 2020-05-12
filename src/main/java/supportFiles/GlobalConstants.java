package supportFiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class GlobalConstants {
	
	//*** FRAMEWORK PARAMETERS
	public static final String projectDirectoryPath=System.getProperty("user.dir");
	public static ExtentReports extent;
	public static String projectName = "Petstore Rest API Test";

	//*** ALL THE RESOURCES PATHS ****		
	public static final String inputExcelpath = projectDirectoryPath+"/InputParameters.xlsx";
	public static final String inputExcelSheet = "input";
	public static final String testng_xml_path = projectDirectoryPath+"/testit.xml";
	public static final String exec_report_path=projectDirectoryPath+"/reportLogs/";	
	public static final String testng_xml_filename = "testit.xml";	
	
	
	//*** EXTENT REPORT RELATED PARAMETERS
	public static String executionReportName;
	public static String currentReportFolderPath;
	public static String currentReportFolderName;
	public static final String extentConfigFilePath=projectDirectoryPath+"/extent-config.xml";
	public static Map<String,String> testToDescMap= new HashMap<String,String>();
	public static Map<String,String> moduleToDescMap= new HashMap<String,String>();
	public static Map<String, Vector<String>> moduleToTestsMap= new HashMap<String, Vector<String>>();
	public static Map<String,ExtentTest> testReportMap= new HashMap<String, ExtentTest>();
	public static Map<String,ExtentTest> moduleToReportMap= new HashMap<String, ExtentTest>();
	
	
}
