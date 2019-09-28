package com.mongo;

//import com.mongo.network.run.TcpRun;
import com.mongo.network.run.TcpRun;
import com.mongo.utils.TTNStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoApplication.class, args);
		//开始运行
		//TTNStart.start();
		//此处运行界面
		TcpRun r = new TcpRun();
		r.run();

	}

}
