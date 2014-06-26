package com.oudmaijer.drools.fraud.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephan on 19-06-14.
 */
@XmlRootElement
public class Errors {

    private java.util.List<String> messages = new ArrayList<String>();

    public void add(String error) {
        messages.add(error);
    }

    @XmlElement(name="error")
    public List<String> getErrors() {
        return messages;
    }

    public void setErrors(List<String> errors) {
        this.messages = errors;
    }
}
