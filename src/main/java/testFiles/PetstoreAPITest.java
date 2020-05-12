package testFiles;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import businessFiles.Pet;
import businessFiles.PetCategory;
import businessFiles.PetTags;
import io.restassured.http.Method;
import io.restassured.response.Response;
import supportFiles.GlobalConstants;
import supportFiles.LOG;
import supportFiles.RestAPIOperations;
import supportFiles.TestData;


public class PetstoreAPITest {
	RestAPIOperations rest;
	Pet pet;
	
	@Test (groups = { "petstore", "testPetstoreAddPet" })	
	public void testPetstoreAddPet() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_id = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet ID"));
			String pet_category = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Category");
			String pet_name = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Name");
			String pet_urls = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Urls");
			String pet_tags = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Tags");
			String pet_status = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Status");
			
			
			this.rest = new RestAPIOperations(endpoint);		
	   	 	this.rest.setDefaultRequestHeader();
	   	 	pet = new Pet();
	   	 	pet.setId(pet_id);
	   	 	pet.setCategory(new PetCategory(Integer.parseInt(pet_category.split(":")[0]), pet_category.split(":")[1]));
	   	 	pet.setName(pet_name);
	   	 	List<String> urlList = new ArrayList<String>();
	   	 	urlList.add(pet_urls);
	   	 	pet.setPhotoUrls(urlList);
	   	 	List<PetTags> tags = new ArrayList<PetTags>();
	   	 	tags.add(new PetTags(Integer.parseInt(pet_tags.split(":")[0]), pet_tags.split(":")[1]));
	   	 	pet.setTags(tags);
	   	 	pet.setStatus(pet_status);     
	   	 	JSONObject jsonObj = pet.getJsonRequest();
	   	 	this.rest.setDefaultRequestHeader();
	   	 	this.rest.setRequestBody(jsonObj);
	   	 	Response response = this.rest.makeRequest(Method.POST, index);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record for Pet ID: " + pet_id + " is added successfully");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	
	@Test (groups = { "petstore", "testPetstoreUpdatePet" })	
	public void testPetstoreUpdatePet() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_id = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet ID"));
			String pet_category = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Category");
			String pet_name = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Name");
			String pet_urls = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Urls");
			String pet_tags = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Tags");
			String pet_status = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Status");
			
			
			this.rest = new RestAPIOperations(endpoint);		
	   	 	this.rest.setDefaultRequestHeader();
	   	 	pet = new Pet();
	   	 	pet.setId(pet_id);
	   	 	pet.setCategory(new PetCategory(Integer.parseInt(pet_category.split(":")[0]), pet_category.split(":")[1]));
	   	 	pet.setName(pet_name);
	   	 	List<String> urlList = new ArrayList<String>();
	   	 	urlList.add(pet_urls);
	   	 	pet.setPhotoUrls(urlList);
	   	 	List<PetTags> tags = new ArrayList<PetTags>();
	   	 	tags.add(new PetTags(Integer.parseInt(pet_tags.split(":")[0]), pet_tags.split(":")[1]));
	   	 	pet.setTags(tags);
	   	 	pet.setStatus(pet_status);     
	   	 	JSONObject jsonObj = pet.getJsonRequest();
	   	 	this.rest.setDefaultRequestHeader();
	   	 	this.rest.setRequestBody(jsonObj);
	   	 	Response response = this.rest.makeRequest(Method.PUT, index);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record for Pet ID: " + pet_id + " is updated successfully");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	@Test (groups = { "petstore", "testPetstoreFindByStatus" })	
	public void testPetstoreFindByStatus() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_status = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Status"));
					
			this.rest = new RestAPIOperations(endpoint);	   	 		   	 	
			this.rest.setDefaultRequestHeader();
	   	 	Response response = this.rest.makeRequest(Method.GET, index + pet_status);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record found for status: [" + pet_status + "]");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	@Test (groups = { "petstore", "testPetstoreFindByID" })	
	public void testPetstoreFindByID() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_id = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet ID"));
					
			this.rest = new RestAPIOperations(endpoint);	   	 		   	 	
			this.rest.setDefaultRequestHeader();
	   	 	Response response = this.rest.makeRequest(Method.GET, index + pet_id);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record found for pet id: [" + pet_id + "]");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	
	@Test (groups = { "petstore", "testPetstorePostUpdate" })	
	public void testPetstorePostUpdate() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_id = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet ID"));
			String pet_category = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Category");
			String pet_name = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Name");
			String pet_urls = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Urls");
			String pet_tags = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Tags");
			String pet_status = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet Status");
			
			
			this.rest = new RestAPIOperations(endpoint);		
	   	 	this.rest.setDefaultRequestHeader();
	   	 	pet = new Pet();
	   	 	pet.setId(pet_id);
	   	 	pet.setCategory(new PetCategory(Integer.parseInt(pet_category.split(":")[0]), pet_category.split(":")[1]));
	   	 	pet.setName(pet_name);
	   	 	List<String> urlList = new ArrayList<String>();
	   	 	urlList.add(pet_urls);
	   	 	pet.setPhotoUrls(urlList);
	   	 	List<PetTags> tags = new ArrayList<PetTags>();
	   	 	tags.add(new PetTags(Integer.parseInt(pet_tags.split(":")[0]), pet_tags.split(":")[1]));
	   	 	pet.setTags(tags);
	   	 	pet.setStatus(pet_status);     
	   	 	JSONObject jsonObj = pet.getJsonRequest();
	   	 	this.rest.setDefaultRequestHeader();
	   	 	this.rest.setRequestBody(jsonObj);
	   	 	Response response = this.rest.makeRequest(Method.POST, index);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record for Pet ID: " + pet_id + " is updated successfully");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	@Test (groups = { "petstore", "testPetstoreDeleteRecord" })	
	public void testPetstoreDeleteRecord() throws Throwable{
		try {
			String endpoint = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Endpoint");
			String index = TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Index");
			int pet_id = Integer.parseInt(TestData.getData(GlobalConstants.inputExcelpath, GlobalConstants.inputExcelSheet, "testPetstoreAddPet", "Pet ID"));
			
			
			this.rest = new RestAPIOperations(endpoint);		
	   	 	this.rest.setDefaultRequestHeader();
	   	 	
	   	 	
	   	 	Response response = this.rest.makeRequest(Method.DELETE, index + pet_id);
	   	 	
	   	 	if (response.getStatusCode() == 200)
	   	 		LOG.report_PASS("Pet record for Pet ID: " + pet_id + " is deleted successfully");
			else
				LOG.report_FAIL("Response Code: " + response.getStatusCode() + ", Response Message: " + response.getStatusLine());
   	 		
		}catch(Exception e) {
			
			LOG.report_ERROR(e);
		}
		
	}
	
}


