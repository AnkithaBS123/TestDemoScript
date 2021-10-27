$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/demo.feature");
formatter.feature({
  "line": 1,
  "name": "Test Script Demo",
  "description": "",
  "id": "test-script-demo",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5124610400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Automating Demo Shop",
  "description": "",
  "id": "test-script-demo;automating-demo-shop",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I add four different products to my wishlist",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I view my wishlist table",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I find total four selected items in my wishlist",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I search for lowest price item to my cart",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I am to verify the item in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "demoStepDefinition.i_add_four_different_products_to_my_wishlist()"
});
formatter.result({
  "duration": 6105337100,
  "status": "passed"
});
formatter.match({
  "location": "demoStepDefinition.i_view_my_wishlist_table()"
});
formatter.result({
  "duration": 473215199,
  "status": "passed"
});
formatter.match({
  "location": "demoStepDefinition.i_find_total_four_selected_items_in_my_wishlist()"
});
formatter.result({
  "duration": 1778747200,
  "status": "passed"
});
formatter.match({
  "location": "demoStepDefinition.i_search_for_lowest_price_item_to_my_cart()"
});
formatter.result({
  "duration": 1212319599,
  "status": "passed"
});
formatter.match({
  "location": "demoStepDefinition.i_am_to_verify_the_item_in_my_cart()"
});
formatter.result({
  "duration": 1266278300,
  "status": "passed"
});
formatter.after({
  "duration": 836925400,
  "status": "passed"
});
});