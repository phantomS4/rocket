package com.mao.rocket.model.vo;

import com.mao.rocket.controller.mvc.BillInfo;
import com.mao.rocket.utils.JsonUtils;

import java.util.List;

public class Bill {
  public long id;
  public long userId;
  public double amount;
  public String status;
  public String items;

  public static Bill from(List<BillInfo> billInfos, long userId) {
    Bill bill = new Bill();
    bill.userId = userId;
    bill.items = JsonUtils.toString(billInfos);
    for (BillInfo billInfo : billInfos) {
      bill.amount += billInfo.item.price * billInfo.weight;
    }
    return bill;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }
}
