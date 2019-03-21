package com.bind.spring.redpacket.dao;

import com.bind.spring.redpacket.pojo.Redpacket;

public interface RedPacketDao {
	//查询红包
	public Redpacket getRedPacket(Long id);
	//扣减红包
	public int decreaseRedPacket(Long id);
}
