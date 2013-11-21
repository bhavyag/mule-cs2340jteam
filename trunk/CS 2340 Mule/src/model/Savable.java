package model;

import org.json.simple.parser.ParseException;

public interface Savable {
    public String toJson();
    public Object fromJson(String jsonString) throws ParseException;
}
