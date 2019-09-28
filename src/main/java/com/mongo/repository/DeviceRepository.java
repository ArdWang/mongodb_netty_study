package com.mongo.repository;

import com.mongo.entity.AllData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Classname DeviceRepository
 * Description TODO
 * Date 8/14/19 10:51 AM
 * Created by rnd
 */
public interface DeviceRepository extends MongoRepository<AllData,Long>{

}
