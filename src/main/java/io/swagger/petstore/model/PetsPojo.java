package io.swagger.petstore.model;


import java.util.HashMap;
import java.util.List;

public class PetsPojo {

    private int id;
    private HashMap <?, ?> category;
    private String name;
    private List<String> photoUrl;
    private List <HashMap<?,?>> tags;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<?, ?> getCategory() {
        return category;
    }

    public void setCategory(HashMap<?, ?> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<HashMap<?, ?>> getTags() {
        return tags;
    }

    public void setTags(List<HashMap<?, ?>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
