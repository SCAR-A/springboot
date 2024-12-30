package com.example.springboot.models.common.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @date 2020/3/9 10:46
 */
@SuppressWarnings("unused")
public class LongJsonDeserializer extends JsonDeserializer<Long> {

    private static final Logger logger = LoggerFactory.getLogger(LongJsonDeserializer.class);

    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        try {
            return value == null || value.length() == 0 ? null : Long.valueOf(value);
        } catch (NumberFormatException e) {
            logger.error("LongJsonDeserializer.deserialize failed:{},cause:{}", e.getMessage(), e.getCause());
            throw new RuntimeException("LongJsonDeserializer.deserialize failed");
        }
    }
}
