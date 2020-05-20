package com.mao.rocket.model;

import com.mao.rocket.model.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

  @Select("select * from user where id = #{id}")
  User getOne(Long id);

  @Select("select * from user where mobile=#{mobile} and type=#{type}")
  User getOneByMobile(@Param("mobile") String mobile, @Param("type") int type);

  @Insert("insert into user(name,mobile,type,password) values(#{name}, #{mobile}, #{type}, #{password})")
  void create(User user);

  @Update("update user set name=#{name}, mobile=#{mobile} where id=#{id}")
  void update(User user);

  @Select("select * from user LIMIT #{offset},#{limit}")
  List<User> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

}
