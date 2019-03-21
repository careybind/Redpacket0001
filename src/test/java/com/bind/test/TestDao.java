package com.bind.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bind.spring.redpacket.RedpacketApp;
import com.bind.spring.redpacket.dao.RedPacketDao;
import com.bind.spring.redpacket.pojo.Redpacket;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes=RedpacketApp.class)
public class TestDao {
	@Autowired
	private RedPacketDao redPacketDao;
	
	@Test
	public void Testget(){
		System.out.println("--------------------------开始------------------------------");
		try{
			Redpacket r = redPacketDao.getRedPacket(1l);
			System.out.println(r);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("--------------------------结束------------------------------");
	}
}
