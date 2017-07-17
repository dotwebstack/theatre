package org.dotwebstack.controller;

import java.util.ArrayList;
import java.util.List;
import org.dotwebstack.data.Appearance;
import org.dotwebstack.data.impl.TableAppearance;
import org.dotwebstack.data.impl.TreeAppearance;
import org.dotwebstack.data.impl.TreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */
@Controller
public class MainController {

  @GetMapping("/{excluded:(?!webjars)(?!images)(?!styles)(?!js).*}/**")
  public String get(Model model) {
    List<Appearance> appearances = new ArrayList<>();
    appearances.add(new TableAppearance("myTable"));
    appearances.add(new TreeAppearance("myTree", getNodes()));
    appearances
        .add(new TableAppearance("myTable", new TreeAppearance("myInnerTree", new TreeNode(""))));
    model.addAttribute("appearances", appearances);

    return "main";
  }

  private TreeNode[] getNodes() {
    TreeNode root1 = new TreeNode("root1");
    TreeNode root2 = new TreeNode("root2");
    TreeNode root3 = new TreeNode("root3");
    TreeNode child1 = new TreeNode("child1");

    root1.addNode(child1);
    root1.addNode(new TreeNode("child2"));
    child1.addNode(new TreeNode("child3"));

    List<TreeNode> nodes = new ArrayList<>();
    nodes.add(root1);
    nodes.add(root2);
    nodes.add(root3);

    return nodes.toArray(new TreeNode[nodes.size()]);
  }

}
