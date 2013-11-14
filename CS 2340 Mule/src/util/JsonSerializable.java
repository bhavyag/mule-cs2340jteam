package util;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;

public interface JsonSerializable {
    public JsonObject toJson(URL path) throws IOException;
    public Object fromJson(URL path) throws IOException;
}
