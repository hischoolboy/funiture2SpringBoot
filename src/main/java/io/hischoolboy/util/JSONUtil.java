package io.hischoolboy.util;


import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchu on 2017/5/7.
 */
@Slf4j
public class JSONUtil {

    private static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;

    private static final ObjectReader READER;
    private static final ObjectWriter WRITER;

    static {
        final ObjectMapper mapper = getObjectMapper();
        READER = mapper.reader();
        WRITER = mapper.writer();
    }

    //FIXME
    public static String toJson(Object o) {
        return " ";
    }

    public static <T> List<T> toList(String json, Class<T> tClass) {
        return new ArrayList<T>();
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper().setNodeFactory(FACTORY)
                .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN)
                .enable(SerializationFeature.INDENT_OUTPUT);
    }
}
