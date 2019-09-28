package com.mongo.repository;

import com.mongo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Classname UserRepository
 * Description TODO
 * Date 2019/8/13 19:54
 * Created by Administrator
 */
public interface UserRepository extends MongoRepository<UserInfo,Long>{

}
