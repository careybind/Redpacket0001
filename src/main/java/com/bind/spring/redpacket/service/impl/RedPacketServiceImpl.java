package com.bind.spring.redpacket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bind.spring.redpacket.dao.RedPacketDao;
import com.bind.spring.redpacket.pojo.Redpacket;
import com.bind.spring.redpacket.service.RedPacketService;

@Service
public class RedPacketServiceImpl implements RedPacketService {
	/**
	 * 配置了事务注解＠Transactional ， 让程序能够在事务中运行，以保证数据的一致性 ， 这里采用的是读／写提交的隔离级别 ， 之所以不采用更高的级别， 主要是提高数据库的并发能力，
	 * 而对于传播行为则采用 Propagation.REQUIRED，这样调用这个方法的时候，如果没有事务则会创建事务， 如果有事务则沿用当前事务。

	 */
	@Autowired
	private RedPacketDao redPacketDao;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Redpacket getRedPacket(Long id) {
		return redPacketDao.getRedPacket(id);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int decreaseRedPacket(Long id) {
		return redPacketDao.decreaseRedPacket(id);
	}
}
