package model;

public interface Savable {
    public String toDataString();
    public Object fromDataString(String dataString);
}
