package com.mao.rocket.service;

import com.mao.rocket.model.ItemDao;
import com.mao.rocket.model.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qqy
 * @date 2020-05-20 14:42
 */
@Service
public class ItemService {
  @Autowired
  private ItemDao itemDao;

  public void addItem(Item item) {
    itemDao.create(item);
  }
}
