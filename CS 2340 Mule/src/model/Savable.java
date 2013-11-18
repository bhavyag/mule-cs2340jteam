package model;

public interface Savable {
    public String toJson();
    public Object fromJson(String jsonString);
}
