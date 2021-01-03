package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.DataSource;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class DataSourcesApi {
    /*
     * Get Data Sources
     *
     * Returns a list of data sources.
     *
     * The 'system.datasource.manager.VIEW' entitlement is needed.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<DataSource>> getDataSources() {
        return RestCallBuilder
            .start(new TypeToken<List<DataSource>>() {})
            .get()
            .url("/learn/api/public/v1/dataSources")
            .build();
    }

    /*
     * Create Data Source
     *
     * Creates a data source.
     *
     * The 'system.datasource.manager.VIEW' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<DataSource> createDataSource(CreateDataSourceBody input) {
        return RestCallBuilder
            .start(new TypeToken<DataSource>() {})
            .post()
            .url("/learn/api/public/v1/dataSources")
            .body(input)
            .build();
    }

    public static class CreateDataSourceBody {
        /*
         * An externally-defined unique ID for the data source.
         *
         * Formerly known as 'batchUid'.
         */
        private String externalId;

        /*
         * The description of the data source.
         */
        private String description;

        public static CreateDataSourceBody create() {
            return new CreateDataSourceBody();
        }

        public CreateDataSourceBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateDataSourceBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }

    /*
     * Get Data Source
     *
     * Loads a data source.
     *
     * The 'system.datasource.manager.VIEW' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<DataSource> getDataSource(String dataSourceId) {
        return RestCallBuilder
            .start(new TypeToken<DataSource>() {})
            .get()
            .url("/learn/api/public/v1/dataSources/{dataSourceId}")
            .pathParam("dataSourceId", dataSourceId)
            .build();
    }

    /*
     * Delete Data Source
     *
     * Deletes a data source.
     *
     * The 'system.datasource.manager.VIEW' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Void> deleteDataSource(String dataSourceId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/dataSources/{dataSourceId}")
            .pathParam("dataSourceId", dataSourceId)
            .build();
    }

    /*
     * Update Data Source
     *
     * Updates a data source.
     *
     * The 'system.datasource.manager.VIEW' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<DataSource> updateDataSource(String dataSourceId, UpdateDataSourceBody input) {
        return RestCallBuilder
            .start(new TypeToken<DataSource>() {})
            .patch()
            .url("/learn/api/public/v1/dataSources/{dataSourceId}")
            .pathParam("dataSourceId", dataSourceId)
            .body(input)
            .build();
    }

    public static class UpdateDataSourceBody {
        /*
         * An externally-defined unique ID for the data source.
         *
         * Formerly known as 'batchUid'.
         */
        private String externalId;

        /*
         * The description of the data source.
         */
        private String description;

        public static UpdateDataSourceBody create() {
            return new UpdateDataSourceBody();
        }

        public UpdateDataSourceBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateDataSourceBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }
}
