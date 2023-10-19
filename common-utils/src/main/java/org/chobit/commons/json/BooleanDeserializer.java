package org.chobit.commons.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * 自定义Boolean类型异常处理器，处理Boolean类型值异常的问题
 *
 * @author robin
 */
public class BooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext cxt) throws IOException {
        String s = p.getText();
        if (String.valueOf(0).equals(s) || String.valueOf(false).equalsIgnoreCase(s)) {
            return false;
        }
        return String.valueOf(1).equals(s) || String.valueOf(true).equalsIgnoreCase(s);
    }
}
