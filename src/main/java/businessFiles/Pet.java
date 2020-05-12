package businessFiles;
import businessFiles.PetTags;
import businessFiles.PetCategory;
import java.util.List;
import org.json.simple.JSONObject;


public class Pet {
	int id;
	PetCategory category;
	String name;
	List<String> photoUrls;
	List<PetTags> tags;
	String status;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory getCategory() {
		return category;
	}
	public void setCategory(PetCategory category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<PetTags> getTags() {
		return tags;
	}
	public void setTags(List<PetTags> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public JSONObject getJsonRequest() {
		JSONObject petJSONrequest = new JSONObject();
		petJSONrequest.put("id", this.id);
		petJSONrequest.put("category", this.category);
		petJSONrequest.put("name", this.name);
		petJSONrequest.put("photoUrls", this.photoUrls);
		petJSONrequest.put("tags", this.tags);
		petJSONrequest.put("status", this.status);
		
		return petJSONrequest;
	}
	
}
