treeview = new Object();

$(function () {
  treeview.restoreData();
  $(".nav-tree a").click(treeview.toggleNode);
});

treeview.toggleNode = function () {
  var li = $(this).parent();
  li.toggleClass("tree-collapsed")
  var ul = li.find("ul");
  ul.toggleClass("hide");

  var icon = li.find("i");
  icon.toggleClass("fa-minus-square");
  icon.toggleClass("fa-plus-square");

  treeview.saveData();

  return false;
}

treeview.getKey = function getId(id) {
  return "navtree_html_" + id;
}

treeview.saveData = function () {
  if (!sessionStorage) {
    return;
  }

  $(".nav-tree").each(function () {
    var id = $(this).attr("id");
    if (!id) {
      return;
    }

    var data = {
      id: id,
      html: $(this).html()
    };

    sessionStorage.setItem(treeview.getKey(id), JSON.stringify(data));
  });
};

treeview.restoreData = function () {
  if (!sessionStorage) {
    return;
  }

  $(".nav-tree").each(function () {
    var id = $(this).attr("id");
    if (!id) {
      return;
    }

    var key = treeview.getKey(id);
    var data = sessionStorage.getItem(key);
    if (!data) {
      return null;
    }
    $(this).html(JSON.parse(data).html);
    sessionStorage.removeItem(key);
  });
};