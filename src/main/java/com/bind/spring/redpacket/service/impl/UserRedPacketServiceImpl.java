package com.bind.spring.redpacket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bind.spring.redpacket.dao.RedPacketDao;
import com.bind.spring.redpacket.dao.UserRedPacketDao;
import com.bind.spring.redpacket.pojo.Redpacket;
import com.bind.spring.redpacket.pojo.UserRedpacket;
import com.bind.spring.redpacket.service.UserRedPacketService;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {
	// private Logger logger =
	// LoggerFactory.getLogger(UserRedPacketServiceImpl.class);
	@Autowired
	private UserRedPacketDao userRedPacketDao;
	@Autowired
	private RedPacketDao redPacketDao;
	// 失败
	private static final int FAILED = 0;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grapRedPacket(Long redpacketId, Long userId) {
		// 获取红包信息
		Redpacket redPacket = redPacketDao.getRedPacket(redpacketId);
		int leftRedPacket = redPacket.getStock();
		// 当前小红包库存大于0
		if (leftRedPacket > 0) {
			redPacketDao.decreaseRedPacket(redpacketId);
			// logger.info("剩余Stock数量:{}", leftRedPacket);
			// 生成抢红包信息
			UserRedpacket userRedPacket = new UserRedpacket();
			userRedPacket.setRedpacketId(redpacketId);
			userRedPacket.setUserId(userId);
			userRedPacket.setAmount(redPacket.getUnitAmout());
			userRedPacket.setNote("redpacket- " + redpacketId);
			// 插入抢红包信息
			int result = userRedPacketDao.grapRedPacket(userRedPacket);
			return result;
		}
		// logger.info("没有红包啦.....剩余Stock数量:{}", leftRedPacket);
		// 失败返回
		return FAILED;
	}
}