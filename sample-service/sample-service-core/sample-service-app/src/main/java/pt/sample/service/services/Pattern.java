package pt.sample.service.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Pattern<T>{

    private T metaData;

    public Pattern(T type) {
        if (type==null){
            throw new IllegalArgumentException("Message pattern type can not be null.");
        }
        this.metaData = type;
    }

    public T getMetaData() {
        return metaData;
    }

    public  String getParsedPattern() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(metaData);
    }
}