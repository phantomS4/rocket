package com.mao.rocket.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
