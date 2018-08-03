package com.bitoffice.service.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class mongoDB {
public static void main(String[] args) {
		
		MongoClient mongoClient = null;
		
		try {
			mongoClient = new MongoClient("192.168.0.48", 27017);
			
			System.out.println("MongoDB 연결 성공");
			
			WriteConcern w = new WriteConcern(1, 2000);
			mongoClient.setWriteConcern(w);
			
			DB db = mongoClient.getDB("user");
			
			DBCollection collection = db.getCollection("user");
			
			
			/*//user 테이블에 데이터 삽입
			DBObject doc = new BasicDBObject();
			doc.put("employeeNo", "employeeNo");
			doc.put("employeeName", "employeeName");
			collection.insert(doc);*/
			
			//user 테이블의 모든 데이터 가져오기
			/*DBCursor cursor = collection.find();
			while(cursor.hasNext()) {
				//커서의 이름 중에 _id인 컬럼 값만 출력
				System.out.println(cursor.next().get("_id"));
			}*/
			
			//특정 조건에 맞는 데이터 출력
			DBObject o = new BasicDBObject();
			o.put("employeeNo", "employeeNo");
			DBCursor cursor = collection.find(o);
			while(cursor.hasNext()) {
				System.out.println(cursor.next().toString());
			}
			
			/*//업데이트
			DBObject origin = new BasicDBObject("id", "user");
			DBObject set = new BasicDBObject("$set", new BasicDBObject("password", "taktak"));
			collection.update(origin, set);
			
			//모든 데이터 삭제
			collection.remove(new BasicDBObject());
			
			//선택 데이터 삭제
			collection.remove(new BasicDBObject("id", "탁석원"));*/
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
