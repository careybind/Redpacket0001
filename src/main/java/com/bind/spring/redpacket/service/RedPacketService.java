package com.bind.spring.redpacket.service;

import com.bind.spring.redpacket.pojo.Redpacket;

public interface RedPacketService {
	/**
	 * 获取红包
	 * 
	 * @param id
	 *            ——编号
	 * @return 红包信息
	 */
	public Redpacket getRedPacket(Long id);

	/**
	 * 扣减红包
	 * 
	 * @param id——编号
	 * @return 影响条数.
	 */
	public int decreaseRedPacket(Long id);
}