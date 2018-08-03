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
			
			System.out.println("MongoDB ���� ����");
			
			WriteConcern w = new WriteConcern(1, 2000);
			mongoClient.setWriteConcern(w);
			
			DB db = mongoClient.getDB("user");
			
			DBCollection collection = db.getCollection("user");
			
			
			/*//user ���̺� ������ ����
			DBObject doc = new BasicDBObject();
			doc.put("employeeNo", "employeeNo");
			doc.put("employeeName", "employeeName");
			collection.insert(doc);*/
			
			//user ���̺��� ��� ������ ��������
			/*DBCursor cursor = collection.find();
			while(cursor.hasNext()) {
				//Ŀ���� �̸� �߿� _id�� �÷� ���� ���
				System.out.println(cursor.next().get("_id"));
			}*/
			
			//Ư�� ���ǿ� �´� ������ ���
			DBObject o = new BasicDBObject();
			o.put("employeeNo", "employeeNo");
			DBCursor cursor = collection.find(o);
			while(cursor.hasNext()) {
				System.out.println(cursor.next().toString());
			}
			
			/*//������Ʈ
			DBObject origin = new BasicDBObject("id", "user");
			DBObject set = new BasicDBObject("$set", new BasicDBObject("password", "taktak"));
			collection.update(origin, set);
			
			//��� ������ ����
			collection.remove(new BasicDBObject());
			
			//���� ������ ����
			collection.remove(new BasicDBObject("id", "Ź����"));*/
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
