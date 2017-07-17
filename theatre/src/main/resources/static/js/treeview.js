$(function () {
  $(".nav-tree a").click(toggleNode);
});

function toggleNode() {
  var parent = $(this).parent();
  var ul = parent.find("ul");
  ul.toggleClass("hide");

  var icon = parent.find("i");
  icon.toggleClass("fa-minus-square");
  icon.toggleClass("fa-plus-square");

  return false;
}