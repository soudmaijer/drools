package com.oudmaijer.drools.fraud.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephan on 19-06-14.
 */
public class Errors<T> {

    private java.util.List<T> errors = new ArrayList<T>();

    public void add(T error) {
        errors.add(error);
    }

    public List<T> getErrors() {
        return errors;
    }

    public void setErrors(List<T> errors) {
        this.errors = errors;
    }
}
