package com.mao.rocket.model;

import com.mao.rocket.model.vo.Item;
import com.mao.rocket.model.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemDao {

  @Select("select * from item where id = #{id}")
  Item getOne(Long id);

  @Select("select * from item where name=#{name}")
  User getOneByName(@Param("name") String mobile);

  @Insert("insert into item(name,price,image) values(#{name}, #{price}, #{image})")
  void create(Item item);

  @Update("update user set name=#{name}, price=#{price}, image=#{image} where id=#{id}")
  void update(Item item);

  @Select("select * from item LIMIT #{offset},#{limit}")
  List<Item> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

}
