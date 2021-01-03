package org.jbsmit.blackboardRestClient.model;

import java.util.Map;

public class GradingFormulaV2 {
    private String formula;

    private Map<String, String> aliases;


    public String getFormula() {
        return formula;
    }

    public GradingFormulaV2 setFormula(String formula) {
        this.formula = formula;
        return this;
    }

    public Map<String, String> getAliases() {
        return aliases;
    }

    public GradingFormulaV2 setAliases(Map<String, String> aliases) {
        this.aliases = aliases;
        return this;
    }
}

