package com.pega.pilot.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.pilot.model.MappingRule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileLoader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static List<MappingRule> loadMappingRules(String path) throws IOException {
        return OBJECT_MAPPER.readValue(new File(path), new TypeReference<List<MappingRule>>() {});
    }
}
