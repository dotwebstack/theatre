package org.dotwebstack.controller;

import java.util.ArrayList;
import java.util.List;
import org.dotwebstack.data.Appearance;
import org.dotwebstack.data.impl.TableAppearance;
import org.dotwebstack.data.impl.TreeAppearance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */
@Controller
public class MainController {

  @GetMapping("/{excluded:(?!webjars)(?!images)(?!css)(?!js).*}/**")
  public String get(Model model) {
    List<Appearance> appearances = new ArrayList<>();
    appearances.add(new TableAppearance("myTable"));
    appearances.add(new TreeAppearance("myTree"));
    appearances.add(new TableAppearance("myTable", new TreeAppearance("myInnerTree")));
    model.addAttribute("appearances", appearances);

    return "main";
  }

}
