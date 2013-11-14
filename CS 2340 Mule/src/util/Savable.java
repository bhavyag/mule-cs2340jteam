package util;

public interface Savable {
    public String toDataString();
    public Object fromDataString(String dataString);
}
