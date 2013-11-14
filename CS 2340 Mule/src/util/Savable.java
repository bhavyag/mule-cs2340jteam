package util;

import com.google.gson.JsonObject;

import java.io.IOException;

public interface Savable {
    public JsonObject toJson() throws IOException;
    public Object fromJson(JsonObject obj) throws IOException;
}
