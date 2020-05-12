package supportFiles;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener,IInvokedMethodListener {
	
	Set<String> set= new HashSet<String>();
	Logger log;

	
	@Override
	public synchronized void beforeInvocation(IInvokedMethod method, ITestResult listner) {		
		GlobalVariables.getConfigMap().get(Thread.currentThread().getName());		
	}


	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {}

	@Override
	public void onTestStart(ITestResult listner) {
		
		String testName=listner.getName();
		String currentClassName= listner.getTestClass().toString().split("testFiles.")[1].split("]")[0];
		
		if(set.add(currentClassName)){			
			
			if(!GlobalConstants.moduleToReportMap.containsKey(currentClassName)){
				ExtentTest parent=ExtentTestManager.startModule(currentClassName,GlobalConstants.moduleToDescMap.get(currentClassName));
				GlobalConstants.moduleToReportMap.put(currentClassName, parent);
			}
				
		}
		
		
		GlobalVariables.setTestConfiguration(testName,currentClassName);	
		/********** Initializing Log4j Here *************/	
		
		
		log=Logger.getLogger(TestListener.class);
		
		log.info("Test ["+testName+"] has started");
		
		/**************************************************/
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult listner) {
		
		log.fatal("Test ["+listner.getName()+"] has failed",listner.getThrowable());
		
	}

	@Override
	public void onTestFailure(ITestResult listner) {	
		
		
		if(listner.getThrowable()!=null && !(listner.getThrowable().toString().contains("java.lang.AssertionError")))
			LOG.report_ERROR(listner.getThrowable());
		else if (listner.getThrowable().toString().contains("java.lang.AssertionError"))
			listner.getThrowable().printStackTrace();	
	
		
		log.fatal("Test ["+listner.getName()+"] has failed",listner.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult listner) {	
		
		TestConfigurations.stopTestReport();
		log.info("Test ["+listner.getName()+"] has skipped");
	}

	@Override
	public void onTestSuccess(ITestResult listner) {	
		log.info("Test ["+listner.getName()+"] has PASSED");		
	}


	@Override
	public void onFinish(ITestContext arg0) {}


	@Override
	public void onStart(ITestContext arg0) {}	

}
