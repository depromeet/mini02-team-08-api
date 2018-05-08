package com.depromeet.donkey.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class LocalDateTimeToInstant {
  public static Instant toInstant(LocalDateTime localDateTime) {
    return localDateTime != null ? localDateTime.atZone(ZoneId.of("GMT+9")).toInstant() : null;
  }
}
