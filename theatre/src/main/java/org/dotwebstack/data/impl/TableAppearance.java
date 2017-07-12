package org.dotwebstack.data.impl;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */
public class TableAppearance extends AppearanceBase {

  private TreeAppearance tree;

  public TableAppearance(String name) {
    super(name, "table");
  }

  public TableAppearance(String name, TreeAppearance tree) {
    super(name, "table");
  }

  public TreeAppearance getTree() {
    return tree;
  }
}
