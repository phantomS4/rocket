package com.mao.rocket.controller.mvc;

import java.util.List;

public class BillResponse {
  public long id;
  public String userName;
  public double amount;
  public String status;
  public List<BillInfo> items;
}
