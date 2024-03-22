package org.chobit.commons.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.chobit.commons.contract.CodeDescEnum;
import org.chobit.commons.json.annotation.CodeDescSerialize;

import java.io.IOException;

import static org.chobit.commons.constans.Symbol.DASHED;

/**
 * CodeDescEnum
 *
 * @author rui.zhang
 */
public class CodeDescEnumSerializer extends JsonSerializer<CodeDescEnum> implements ContextualSerializer {

    /**
     * 是否展示code
     */
    private boolean showCode = false;

    /**
     * 是否展示desc
     */
    private boolean showDesc = false;


    @Override
    public void serialize(CodeDescEnum value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object v = this.serialize(value);
        jsonGenerator.writeObject(v);
    }


    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        CodeDescSerialize serialize = property.getAnnotation(CodeDescSerialize.class);
        this.showCode = serialize.showCode();
        this.showDesc = serialize.showDesc();

        return this;
    }


    private Object serialize(CodeDescEnum value) {
        if (null == value) {
            return null;
        }
        if (showCode && showDesc) {
            return value.getCode() + DASHED + value.getDesc();
        }
        if (showCode) {
            return value.getCode();
        }
        if (showDesc) {
            return value.getDesc();
        }

        return value;
    }
}
