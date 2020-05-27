// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.documents;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;
import com.azure.search.documents.indexes.models.SearchField;
import com.azure.search.documents.indexes.models.SearchFieldDataType;
import com.azure.search.documents.indexes.models.SearchIndex;
import com.azure.search.documents.indexes.models.SynonymMap;

import java.util.Arrays;
import java.util.Collections;

/**
 * This example shows how to create an index with a synonym map
 * See https://docs.microsoft.com/en-us/azure/search/search-get-started-portal
 */
public class SynonymMapsCreateExample {

    /**
     * From the Azure portal, get your Azure Cognitive Search service URL and API key,
     * and set the values of these environment variables:
     */
    private static final String ENDPOINT = Configuration.getGlobalConfiguration().get("AZURE_COGNITIVE_SEARCH_ENDPOINT");
    private static final String API_ADMIN_KEY = Configuration.getGlobalConfiguration().get("AZURE_COGNITIVE_SEARCH_ADMIN_KEY");

    public static void main(String[] args) {
        SearchServiceClient serviceClient = new SearchServiceClientBuilder()
            .endpoint(ENDPOINT)
            .credential(new AzureKeyCredential(API_ADMIN_KEY))
            .buildClient();

        String synonymMapName = "desc-synonymmap";

        System.out.println("Create synonym map...\n");
        createSynonymMap(serviceClient, synonymMapName);

        System.out.println("Create index and assign synonym to it...\n");
        assignSynonymMapToIndex(synonymMapName);

        System.out.println("Complete....\n");

        // Clean up resources
        serviceClient.deleteSynonymMap(synonymMapName);
    }

    private static void createSynonymMap(SearchServiceClient serviceClient, String synonymMapName) {
        SynonymMap synonymMap = new SynonymMap()
            .setName(synonymMapName)
            .setSynonyms("hotel, motel\ninternet,wifi\nfive star=>luxury\neconomy,inexpensive=>budget");
        serviceClient.createSynonymMap(synonymMap);
    }

    private static void assignSynonymMapToIndex(String synonymMapName) {
        SearchIndex index = new SearchIndex()
            .setName("hotels")
            .setFields(Arrays.asList(
                new SearchField()
                    .setName("HotelId")
                    .setType(SearchFieldDataType.STRING)
                    .setKey(true),
                new SearchField()
                    .setName("HotelName")
                    .setType(SearchFieldDataType.STRING)
                    .setSynonymMaps(Collections.singletonList(synonymMapName))
            ));
    }
}