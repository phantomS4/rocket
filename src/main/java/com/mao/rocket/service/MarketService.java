package com.mao.rocket.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mao.rocket.controller.mvc.BillResponse;
import com.mao.rocket.filter.context.UserContext;
import com.mao.rocket.model.BillDao;
import com.mao.rocket.model.ItemDao;
import com.mao.rocket.model.UserDao;
import com.mao.rocket.model.vo.Bill;
import com.mao.rocket.model.vo.Item;
import com.mao.rocket.model.vo.User;
import com.mao.rocket.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
  @Autowired
  private ItemDao itemDao;

  @Autowired
  private BillDao billDao;

  @Autowired
  private UserDao userDao;

  public void addItem(Item item) {
    itemDao.create(item);
  }

  public List<Item> getItems() {
    return itemDao.list(Integer.MAX_VALUE, 0);
  }

  public void createBill(List<Long> itemIds) {
    List<Item> items = new ArrayList<>();
    for (Long id : itemIds) {
      items.add(itemDao.getOne(id));
    }
    Bill bill = Bill.from(items, UserContext.USER.get().id);
    billDao.create(bill);
    System.out.println("bill:" + JsonUtils.toString(bill));
  }

  public void updateBill(long id) {
    billDao.update(id, "FINISH");
  }

  public List<BillResponse> getBills() {
    List<Bill> bills = billDao.list(100, 0);
    List<BillResponse> responses = new ArrayList<>();
    for (Bill bill : bills) {
      User user = userDao.getOne(bill.userId);
      BillResponse response = new BillResponse();
      response.id = bill.id;
      response.userName = user != null ? user.name : null;
      response.status = bill.status.equals("PROCESSING") ? "进行中" : "完成";
      response.items = JsonUtils.from(bill.items, new TypeReference<List<Item>>(){});
      response.amount = bill.amount;
      responses.add(response);
    }
    return responses;
  }
}
