package com.oudmaijer.drools.fraud.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Stephan on 19-06-14.
 */
public class RuleParam {

    public static final String MINIMAL_SELLER_RATING = "MINIMAL_SELLER_RATING";

    private Map<String, String> param = new ConcurrentHashMap<String, String>() {{
        put(MINIMAL_SELLER_RATING, "8");
    }};

    public Object get(String key) {
        return param.get(key);
    }

    public Integer getInt(String key) {
        return Integer.parseInt(param.get(key));
    }
}
