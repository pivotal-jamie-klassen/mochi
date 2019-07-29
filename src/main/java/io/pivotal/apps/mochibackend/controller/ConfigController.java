package io.pivotal.apps.mochibackend.controller;

import io.pivotal.apps.mochibackend.model.MochiConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ConfigController {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE, d MMMM yyyy");
  @Value("${mochi.in}")
  private boolean isMochiIn;

  @Value("#{new java.text.SimpleDateFormat(\"yyyy-MM-dd\").parse(\"${mochi.nextIn}\")}")
  private Date nextIn;

  @Value("${mochi.knownNextIn}")
  private boolean knownNextIn;

  @GetMapping(path = "api/config")
  public ResponseEntity<MochiConfig> getConfig() {

    return ResponseEntity.ok(new MochiConfig(isMochiIn, knownNextIn ? DATE_FORMAT.format(nextIn) : null));
  }
}
