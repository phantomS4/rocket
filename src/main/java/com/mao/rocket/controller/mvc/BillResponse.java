package com.mao.rocket.controller.mvc;

import com.mao.rocket.model.vo.Item;

import java.util.List;

public class BillResponse {
  public long id;
  public String userName;
  public long amount;
  public String status;
  public List<Item> items;
}
