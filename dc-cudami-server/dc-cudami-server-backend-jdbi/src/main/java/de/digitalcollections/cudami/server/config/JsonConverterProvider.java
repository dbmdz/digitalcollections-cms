package de.digitalcollections.cudami.server.config;

import static org.jooq.tools.reflect.Reflect.wrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.Converter;
import org.jooq.ConverterProvider;
import org.jooq.JSON;
import org.jooq.JSONB;
import org.jooq.impl.AbstractConverter;
import org.jooq.impl.DefaultConverterProvider;
import org.jooq.tools.Convert;

public class JsonConverterProvider implements ConverterProvider {

  final ConverterProvider delegate = new DefaultConverterProvider();
  final ObjectMapper mapper;

  public JsonConverterProvider(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public <T, U> Converter<T, U> provide(Class<T> tType, Class<U> uType) {
    Class<?> tWrapper = wrapper(tType);
    // Our specialised implementation can convert from JSON (optionally, add JSONB, too)
    if (tWrapper == JSON.class || tWrapper == JSONB.class) {
      return new AbstractConverter<T, U>(tType, uType) {
        @Override
        public U from(T t) {
          return Convert.convert(t, uType);
        }

        @Override
        public T to(U u) {
          return Convert.convert(u, tType);
        }
      };
      //      return Converter.ofNullable(tType, uType,
      //              t -> {
      //                try {
      //                  return mapper.readValue(((SQLDataType.JSON.getType()) t).data(), uType);
      //                } catch (Exception e) {
      //                  throw new DataTypeException("JSON mapping error", e);
      //                }
      //              },
      //              u -> {
      //                try {
      //                  StringWriter w = new StringWriter();
      //                  JsonGenerator g = new JsonFactory().createGenerator(w);
      //                  mapper.writeValue(g, u);
      //                  return (T) JSON.valueOf(w.toString());
      //                } catch (Exception e) {
      //                  throw new DataTypeException("JSON mapping error", e);
      //                }
      //              }
      //      );
    } // Delegate all other type pairs to jOOQ's default
    else {
      return delegate.provide(tType, uType);
    }
  }
}
