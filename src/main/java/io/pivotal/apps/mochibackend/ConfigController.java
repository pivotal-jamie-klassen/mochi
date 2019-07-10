package io.pivotal.apps.mochibackend;

import io.pivotal.apps.mochibackend.model.MochiConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  @Value("${mochi.in}")
  private boolean isMochiIn;

  @GetMapping(path = "api/config")
  public ResponseEntity<MochiConfig> getConfig() {
    return ResponseEntity.ok(new MochiConfig(isMochiIn));
  }
}
