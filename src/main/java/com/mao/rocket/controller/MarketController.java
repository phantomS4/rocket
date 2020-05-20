package com.mao.rocket.controller;

import com.mao.rocket.controller.mvc.CreateBillRequest;
import com.mao.rocket.controller.mvc.UpdateBillRequest;
import com.mao.rocket.model.vo.Item;
import com.mao.rocket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarketController extends BaseController {
  @Autowired
  private MarketService marketService;

  @GetMapping("/market")
  public String goMarket(ModelMap modelMap) {
    modelMap.put("items", marketService.getItems());
    return "market";
  }

  @ResponseBody
  @PostMapping("/market/addItem")
  public void addItem(@RequestBody Item item) {
    marketService.addItem(item);
  }

  @ResponseBody
  @PostMapping("/market/createBill")
  public void addCreateBill(@RequestBody CreateBillRequest request) {
    marketService.createBill(request.ids);
  }

  @ResponseBody
  @PostMapping("/market/updateBill")
  public void addCreateBill(@RequestBody UpdateBillRequest request) {
    marketService.updateBill(request.id);
  }

  @GetMapping("/bill")
  public String goBill(ModelMap modelMap) {
    modelMap.put("bills", marketService.getBills());
    return "bill";
  }

}
