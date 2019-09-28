# mongodb_netty_study
学习mongodb架构物联网数据存储

### MongoDB的搭建与启动

以下的搭建与安装请跳转到
https://www.runoob.com/mongodb/mongodb-tutorial.html

### 创建项目

可以创建 Web或者Java运行项目 

导入两个重要的包

```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>

		<dependency>
			<groupId>io.netty</groupId>
			<artifactId>netty-all</artifactId>
			<version>4.1.32.Final</version>
		</dependency>

```

### mongodb的查询

```
//首先是连接
MongoClient mongoClient = new MongoClient(MONGO_HOST,MONGO_PORT);
DB db = mongoClient.getDB("mongodb");
DBCollection con = db.getCollection("device_tb");

//主要的查询
BasicDBObject query = new BasicDBObject();
query.put("ip", ip);
DBCursor cursor = con.find(query).sort(new BasicDBObject("_id", -1)).limit(1);
DBObject result=cursor.next();

```

其它的mongodb的运用请查看

https://www.runoob.com/mongodb/mongodb-tutorial.html
