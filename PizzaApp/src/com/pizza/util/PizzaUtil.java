package com.pizza.util;

import java.util.HashMap;
import java.util.Map;

public class PizzaUtil {
	static Map<String, String> objMap = new HashMap<String, String>();
    public static Map<String, String> head()
    {
    	    objMap.put("Mushroom", "Mushroom");
    	    objMap.put("Capsicum", "Capsicum");
    	    objMap.put("Jalapeno", "Jalapeno");
    	    objMap.put("Paneer", "Paneer");
    	    return objMap;
    }
}
