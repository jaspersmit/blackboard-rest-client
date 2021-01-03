package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;

public class GradeSymbol {
    /*
     * The text of this grade symbol.
     */
    private String text;

    /*
     * The absoluteValue of this grade symbol.
     */
    private BigDecimal absoluteValue;

    /*
     * The lowerBound of this grade symbol.
     */
    private BigDecimal lowerBound;

    /*
     * The upperBound of this grade symbol.
     */
    private BigDecimal upperBound;


    public String getText() {
        return text;
    }

    public GradeSymbol setText(String text) {
        this.text = text;
        return this;
    }

    public BigDecimal getAbsoluteValue() {
        return absoluteValue;
    }

    public GradeSymbol setAbsoluteValue(BigDecimal absoluteValue) {
        this.absoluteValue = absoluteValue;
        return this;
    }

    public BigDecimal getLowerBound() {
        return lowerBound;
    }

    public GradeSymbol setLowerBound(BigDecimal lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }

    public BigDecimal getUpperBound() {
        return upperBound;
    }

    public GradeSymbol setUpperBound(BigDecimal upperBound) {
        this.upperBound = upperBound;
        return this;
    }
}

