package com.mao.rocket.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static String toString(Object o) {
    try {
      return OBJECT_MAPPER.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static <T> T from(String str, Class<T> clazz) {
    try {
      return OBJECT_MAPPER.readValue(str, clazz);
    } catch (Exception e) {
      return null;
    }
  }

  public static <M> M from(String value, TypeReference<M> clazz) {
    try {
      return OBJECT_MAPPER.readValue(value, clazz);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
