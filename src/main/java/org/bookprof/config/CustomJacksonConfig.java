package org.bookprof.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by kr on 09/07/15.
 */
@Configuration
public class CustomJacksonConfig {

  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter (){

    MappingJackson2HttpMessageConverter convert = new MappingJackson2HttpMessageConverter();

    SimpleModule testModule = new SimpleModule("MyModule", Version.unknownVersion());
    testModule.addSerializer(ObjectId.class, new ObjectIdSerializer());

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(testModule);

    convert.setObjectMapper(mapper);
    return convert;
  }

  private class ObjectIdSerializer extends com.fasterxml.jackson.databind.JsonSerializer<ObjectId> {
    @Override
    public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      jgen.writeString(value.toString());
    }
  }
}
