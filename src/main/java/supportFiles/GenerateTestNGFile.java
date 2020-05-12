package supportFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;



public class GenerateTestNGFile {

	
	private static int threadCount=1;
	private static XmlSuite suite;
	private static XmlTest test;
	private static XmlClass testClass;
	private static ArrayList<XmlClass> classes;
		
	public static void createTestNG(String groupName) throws Throwable{
		
		
		List<String> testClasses=getTestClasses();
		
		suite = new XmlSuite ();
		test=new XmlTest(suite);
		suite.setName(GlobalConstants.projectName);
		suite.setParallel("methods");
		suite.setThreadCount(threadCount);
		suite.setListeners(addListeners());
		classes = new ArrayList<XmlClass>();        
        testClass = new XmlClass();
        
        test.setPreserveOrder("true");
        test.setName("Petstore");
        
        for(String className:testClasses){    
        	
        	classes.add(new XmlClass("testFiles."+className));
        }
        test.setXmlClasses(classes);
        //test.addIncludedGroup(groupNames[0]);
        
        
        test.addIncludedGroup(groupName);	
        
        GenerateTestNGFile.createTestNGFile(GlobalConstants.testng_xml_path); 
	}
	public static List<String> getTestClasses(){
		List<String> testFiles=new ArrayList<String>();
		try{
		File folder = new File(GlobalConstants.projectDirectoryPath+"/src/main/java/testFiles");
		File[] listOfFiles = folder.listFiles();
		

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        
		        testFiles.add(listOfFiles[i].getName().split("\\.")[0]);
		      } 
		    }
		System.out.println("Total Classes: "+testFiles.size());
		
		}catch (Throwable e){
			e.printStackTrace();
		}
		return testFiles;
	}
	protected static ArrayList<String> addListeners(){
		ArrayList<String> listeners = new ArrayList<String>();
		listeners.add("supportFiles.TestListener");
		return listeners;
	}
	public static void runTestNG(String filename){
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add(GlobalConstants.testng_xml_filename);runner.setTestSuites(suitefiles);
		runner.run();
	}
	public static void createTestNGFile(String filepath) throws IOException{
		File file = new File(filepath);
		FileWriter writer = new FileWriter(file);
		writer.write(suite.toXml());
		writer.close();	
	}
	
}
