package supportFiles;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;


public class TestConfigurations {	
	public String testConfigs = null;	
	public String thread= null;
	public ExtentTest report;
	public String moduleName=null;
	public Map<String, String> testData= new HashMap<String, String>();
	public Logger log=null;
	
	
	public Logger getLogger() {
		return this.log;
	}

	public void setLogger(Logger log) {
		this.log = log;
	}
	
	public Map<String,String> getTestData(){
		
		return this.testData;
	}
	
	
	public String getThread() {
		return Thread.currentThread().getName();
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	
	
	public TestConfigurations (String thread){		
		this.thread=thread;	
		
	}
	

	
	public void startTestReport(ExtentTest test,String testDescription){
		String threadName=Thread.currentThread().getName();		
		String testName=null;
		
		int index=threadName.indexOf('_');
		testName=threadName.substring(index+1);
		
		this.report= ExtentTestManager.startNode(test,testName,testDescription);
		GlobalConstants.testReportMap.put(testName, this.report);
		
	}
	

	public static void stopTestReport(){
		
		ExtentTestManager.endTest();
	}
	
	public ExtentTest getReporter(){
		String threadName=Thread.currentThread().getName();		
		String testName=null;
		
		int index=threadName.indexOf('_');
		testName=threadName.substring(index+1);
			
		return GlobalConstants.testReportMap.get(testName);
	}
	
	public void setModuleName(String moduleName){
		
		this.moduleName=moduleName;
	}
	
	public String getModuleName(){
		
		return moduleName;
	}
}
