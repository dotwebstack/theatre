package org.dotwebstack.data.impl;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */
public class TreeAppearance extends AppearanceBase {

  private final TreeNode[] nodes;

  public TreeAppearance(String name, TreeNode... nodes) {
    super(name, "tree");
    this.nodes = nodes;
  }

  public TreeNode[] getNodes() {
    return nodes;
  }
}
