package com.oudmaijer.drools.fraud;

import com.oudmaijer.drools.fraud.model.Address;
import com.oudmaijer.drools.fraud.model.Blacklist;
import com.oudmaijer.drools.fraud.model.RuleParam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FraudRepository {

    // Stuff that we will retrieve from the database. Here now for testing.
    private static RuleParam ruleParam = new RuleParam();
    private static Blacklist blacklist = new Blacklist();

    static {
        blacklist.addBlacklist(Blacklist.ADDRESSES, new ArrayList() {{
            add(new Address("3452RK", 53));
        }});
    }

    public RuleParam getRuleParam() {
        return ruleParam;
    }

    public Blacklist getBlacklist() {
        return blacklist;
    }
}
