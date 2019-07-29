package io.pivotal.apps.mochibackend.model;

public class MochiConfig {

  private boolean isMochiIn;
  private String nextIn;

  public MochiConfig(boolean isMochiIn, String nextIn) {

    this.isMochiIn = isMochiIn;
    this.nextIn = nextIn;
  }

  public boolean isMochiIn() {
    return isMochiIn;
  }

  public void setMochiIn(boolean mochiIn) {
    isMochiIn = mochiIn;
  }

  public String getNextIn() {
    return nextIn;
  }

  public void setNextIn(String nextIn) {
    this.nextIn = nextIn;
  }
}
