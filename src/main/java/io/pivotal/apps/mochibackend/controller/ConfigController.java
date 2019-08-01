package io.pivotal.apps.mochibackend.controller;

import io.pivotal.apps.mochibackend.config.BackendConfig;
import io.pivotal.apps.mochibackend.model.MochiConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ConfigController {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE, d MMMM yyyy");
  private final BackendConfig backendConfig;

  public ConfigController(BackendConfig backendConfig) {
    this.backendConfig = backendConfig;
  }

  @GetMapping(path = "api/config")
  public ResponseEntity<MochiConfig> getConfig() throws ParseException {
    Date nextIn = backendConfig.getNextIn();
    if (CompareDates.areSameDate(nextIn, new Date()))
      return ResponseEntity.ok(new MochiConfig(true, null));
    return ResponseEntity.ok(new MochiConfig(
        backendConfig.isMochiIn(),
        nextIn == null ? null : DATE_FORMAT.format(nextIn)
    ));
  }
}
