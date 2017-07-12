package org.dotwebstack.data.impl;

import org.dotwebstack.data.Appearance;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */
public abstract class AppearanceBase implements Appearance {

  private String name;
  private String appearance;

  protected AppearanceBase(String name, String appearance) {
    this.name = name;
    this.appearance = appearance;
  }

  public String getName() {
    return name;
  }

  public String getAppearance() {
    return appearance;
  }
}
