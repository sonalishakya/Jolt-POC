package com.ondc.Jolt_POC.Service;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class Transform {
    public static void main(String[] args) throws IOException {
        // Load the JSON transformation spec (spec.json)
        Chainr chainr = Chainr.fromSpec(JsonUtils.filepathToList("src/main/resources/spec.json"));

        // Input JSON data (for demonstration purposes, this can also come from other sources like ElasticSearch)
        String inputJson = "{ \"userName\": \"John Doe\", \"userAction\": \"login\" }";

        // Parse the input JSON into a Map (Jolt uses Map/List/String structure to work with JSON)
        Map<String, Object> inputData = JsonUtils.jsonToMap(inputJson);

        // Apply the Jolt transformation
        Object transformedOutput = chainr.transform(inputData);

        // Output the transformed JSON
        System.out.println(JsonUtils.toJsonString(transformedOutput));
    }
}

