package supportFiles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class GlobalVariables
{

	public static Map<String ,TestConfigurations> configMap=new HashMap<String,TestConfigurations>() ;	
	
	
	public static Map<String, TestConfigurations> getConfigMap() {
		return configMap;
	}
	
	public static void setConfigMap(String thread, TestConfigurations tc){
		
		configMap.put(thread, tc);
		
	}

	public static synchronized  void setTestConfiguration(String testName, String moduleName){
		
		try{
			String threadName=moduleName+"_"+testName;
			Thread.currentThread().setName(threadName);
			TestConfigurations testConfig=new TestConfigurations(Thread.currentThread().getName());
			Logger log=Logger.getLogger(moduleName);	
			GlobalVariables.setConfigMap(Thread.currentThread().getName(), testConfig);
			String description=GlobalConstants.testToDescMap.get(testName);
			testConfig.setModuleName(moduleName);
			testConfig.startTestReport(GlobalConstants.moduleToReportMap.get(moduleName),description);			
			testConfig.setLogger(log);
			
		}catch(Exception e){			
			e.printStackTrace();
		}
	}
	
	public static String getTimestamp()
	{		
		String timeStamp = new SimpleDateFormat("MM.dd.yyyy__hh.mm.ssa").format(new Date());		
		return timeStamp;
	}

}
