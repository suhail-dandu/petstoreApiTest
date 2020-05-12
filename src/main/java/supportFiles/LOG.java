package supportFiles;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

public class LOG {
	
	
	public static void report_PASS(String logMessage){		
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
			testConfig.getLogger().info(logMessage);
			testConfig.getReporter().pass(logMessage);
		}catch(Exception e){				
				e.printStackTrace();
			}
	}
	
	public static void report_FAIL(String errorMessage){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
			testConfig.getLogger().fatal(errorMessage);		
			testConfig.getReporter().fail(errorMessage);	
		
			Assert.fail(errorMessage);		
		
		}catch(Exception e){
			Assert.fail(errorMessage);
			e.printStackTrace();
		}
		
	}
	
	public static void reportFailAndContinue(String errorMessage){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		try {
			testConfig.getLogger().fatal(errorMessage);
			testConfig.getReporter().fail(errorMessage);			
			new SoftAssert().fail(errorMessage);
		}catch(Exception e){
			new SoftAssert().fail(errorMessage);
			e.printStackTrace();
		}
		
		
	}
	public static void report_FAIL(Throwable e){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
			testConfig.getLogger().fatal(e);
			testConfig.getReporter().fail(e);		
			Assert.fail(e.getMessage());
		}catch(Exception ex){
			Assert.fail(e.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void reportFailAndContinue(Throwable e){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
			testConfig.getLogger().fatal(e);		
			testConfig.getReporter().fail(e);
			new SoftAssert().fail(e.getMessage());
		}catch(Exception ex){			
			new SoftAssert().fail(e.getMessage());
			ex.printStackTrace();
		}
		
	}
	
	public static void report_INFO(String logMessage){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		try{
			testConfig.getLogger().info(logMessage);
			testConfig.getReporter().info(logMessage);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}
	
	public static void report_WARNING(String warningMessage){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
		
			testConfig.getReporter().warning(warningMessage);
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}
	
	public static void report_ERROR(Throwable e) {
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		testConfig.getLogger().fatal(e);
		try{
			testConfig.getLogger().fatal(e);		
			testConfig.getReporter().error(e);	
				
		
			Assert.fail(e.getMessage());
		
		}catch(Exception exception){
			Assert.fail(e.getMessage());
			exception.printStackTrace();
			
		}
		
	}
	public static void report_ERROR(String errorMessage){
		TestConfigurations testConfig= GlobalVariables.getConfigMap().get(Thread.currentThread().getName());
		
		try{
			testConfig.getLogger().fatal(errorMessage);
			testConfig.getReporter().error(errorMessage);
		
			Assert.fail(errorMessage);
		
		}catch(Exception exception){
			Assert.fail(errorMessage);
			exception.printStackTrace();
			
		}
			
	}
		

}
