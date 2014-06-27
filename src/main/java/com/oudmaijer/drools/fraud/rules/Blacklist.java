package com.oudmaijer.drools.fraud.rules;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Stephan on 19-06-14.
 */
public class Blacklist {

    public static final String ADDRESSES = "addresses";

    public List<Object> getAddresses() {
        return get(ADDRESSES);
    }

    public void setAddresses(List<Object> addresses) {

    }

    private Map<String, List<Object>> lists = new ConcurrentHashMap<String, List<Object>>();

    public void addBlacklist(String key, List<Object> items) {
        lists.put(key, items);
    }

    public List get(String key) {
        return lists.get(key);
    }
}
