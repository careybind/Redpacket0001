package com.bind.spring.redpacket.pojo;

import java.security.Timestamp;

import lombok.Data;
/***
 * 
 * @ClassName UserPacket
 *
 * @Description 用户红包
 *
 * @author carey
 *
 * @date: 2019年3月20日 下午3:22:07 
 *
 */
@Data
public class UserRedpacket {
	private Long id;// 用户红包id
	
	private Long redpacketId;// 红包id
	
	private Double amount;
	
	private Timestamp grabTime;
	
	private String note;
	
	private Long userId;
}
