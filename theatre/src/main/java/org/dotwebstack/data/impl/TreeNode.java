package org.dotwebstack.data.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rick Fleuren on 7/17/2017.
 */
public class TreeNode {

  private final String name;
  private List<TreeNode> children;

  public TreeNode(String name) {
    this.name = name;
  }

  public TreeNode(String name, List<TreeNode> children) {
    this.name = name;
    this.children = children;
  }

  public String getName() {
    return name;
  }

  public List<TreeNode> getChildren() {
    return children;
  }

  public boolean getHasChildren() {
    return children != null && children.size() > 0;
  }

  public void addNode(TreeNode node) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(node);
  }
}
