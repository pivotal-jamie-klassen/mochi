package io.pivotal.apps.mochibackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BackendConfig {

  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  private Date nextIn;
  private boolean isMochiIn;

  public BackendConfig(@Value("${mochi.in}") boolean isMochiIn, @Value("${mochi.nextIn:}") String nextIn) throws ParseException {
    this.isMochiIn = isMochiIn;
    this.nextIn = nextIn.isEmpty() ? null : DATE_FORMAT.parse(nextIn);
  }

  public boolean isMochiIn() {
    return isMochiIn;
  }

  public Date getNextIn() {
    return nextIn;
  }
}
