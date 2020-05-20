package com.mao.rocket.model;

import com.mao.rocket.model.vo.Bill;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BillDao {

  @Insert("insert into bill(user_id,amount,items) values(#{userId}, #{amount}, #{items})")
  void create(Bill bill);

  @Select("select * from bill where user_id=#{userId}")
  @Results({@Result(property = "userId", column = "user_id")})
  List<Bill> getByUserId(Long userId);

  @Select("select * from bill limit #{offset},#{limit}")
  @Results({@Result(property = "userId", column = "user_id")})
  List<Bill> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

  @Update("update bill set status=#{status} where id=#{id}")
  void update(@Param("id") Long id, @Param("status") String status);
}
