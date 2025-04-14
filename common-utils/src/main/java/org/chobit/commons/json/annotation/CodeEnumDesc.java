package org.chobit.commons.json.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.chobit.commons.contract.CodeDescEnum;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.chobit.commons.utils.EnumKit.enumOf2;

/**
 * 将code映射为描述字符串
 *
 * @author robin
 * @since 2025/4/14 7:51
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = CodeEnumDesc.CodeDescEnumSerializer.class)
@JacksonAnnotationsInside
public @interface CodeEnumDesc {


	Class<? extends Enum<? extends CodeDescEnum>> value();


	class CodeDescEnumSerializer extends JsonSerializer<Integer> implements ContextualSerializer {


		private Class<? extends Enum<? extends CodeDescEnum>> enumClass;


		@Override
		public void serialize(Integer code, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
				throws IOException {

			CodeDescEnum codeDescEnum = enumOf2(code, enumClass);
			if (null == codeDescEnum) {
				return;
			}

			jsonGenerator.writeString(codeDescEnum.getDesc());
		}


		@Override
		public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
				throws JsonMappingException {

			CodeEnumDesc annotation = property.getAnnotation(CodeEnumDesc.class);
			if (null != annotation) {
				this.enumClass = annotation.value();
				return this;
			}

			return provider.findValueSerializer(property.getType(), property);
		}
	}
}
