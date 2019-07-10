package io.pivotal.apps.mochibackend.model;

public class MochiConfig {

  private boolean isMochiIn;

  public MochiConfig(boolean isMochiIn) {

    this.isMochiIn = isMochiIn;
  }

  public boolean isMochiIn() {
    return isMochiIn;
  }

  public void setMochiIn(boolean mochiIn) {
    isMochiIn = mochiIn;
  }
}
