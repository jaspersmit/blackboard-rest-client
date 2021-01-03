package org.jbsmit.blackboardRestClient.model;

import java.util.List;

public class GradeSchema {
    /*
     * The id associated with this grade schema.
     */
    private String id;

    /*
     * The externalId associated with this grade schema.
     */
    private String externalId;

    /*
     * The title of this grade schema.
     */
    private String title;

    /*
     * The description of this grade schema.
     */
    private String description;

    /*
     * The scale type of this grade schema.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Percent |  |
     * | Score |  |
     * | Tabular |  |
     * | Text |  |
     * | CompleteIncomplete |  |
     *
     */
    private ScaleType scaleType;

    /*
     * The list of grade symbols for this grade schema. Only returned for Tabular scaleType schemas.
     */
    private List<GradeSymbol> symbols;


    public enum ScaleType {
        Percent,
        Score,
        Tabular,
        Text,
        CompleteIncomplete
    }

    public String getId() {
        return id;
    }

    public GradeSchema setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public GradeSchema setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GradeSchema setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GradeSchema setDescription(String description) {
        this.description = description;
        return this;
    }

    public ScaleType getScaleType() {
        return scaleType;
    }

    public GradeSchema setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public List<GradeSymbol> getSymbols() {
        return symbols;
    }

    public GradeSchema setSymbols(List<GradeSymbol> symbols) {
        this.symbols = symbols;
        return this;
    }
}

