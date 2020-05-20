package com.mao.rocket.controller;

import com.mao.rocket.model.vo.Item;
import com.mao.rocket.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qqy
 * @date 2020-05-17 21:45
 */
@Controller
public class MarketController extends BaseController {
  @Autowired
  private ItemService itemService;

  @GetMapping("/market")
  public String goMarket(ModelMap modelMap) {
    List<Item> items = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      items.add(getItem());
    }
    modelMap.put("items", items);
    return "market";
  }

  private Item getItem() {
    Item item = new Item();
    item.name = "白菜";
    item.price = 10;
    return item;
  }

  @ResponseBody
  @PostMapping("/market/addItem")
  public void addItem(@RequestBody Item item) {
    itemService.addItem(item);
  }

}
