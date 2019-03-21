package com.bind.spring.redpacket.pojo;

import java.io.Serializable;
import java.security.Timestamp;

import lombok.Data;
import lombok.ToString;
@Data
public class Redpacket implements Serializable {

	private static final long serialVersionUID = -8013668307947264625L;
	
	private Long  id; // 红包编号
	
	private Long userId; // 发红包的用户
	
	private Double amount;//红包金额
	
	private Timestamp sendTime;//发红包时间
	
	private Integer total;//红包总数
	
	private Double unitAmout; //单个红包的总数
	
	private Integer stock;//甚于红包的个数
	
	private Integer version ;
	
	private String note;

	@Override
	public String toString() {
		return "Redpacket [id=" + id + ", userId=" + userId + ", amount=" + amount + ", sendTime=" + sendTime
				+ ", total=" + total + ", unitAmout=" + unitAmout + ", stock=" + stock + ", version=" + version
				+ ", note=" + note + "]";
	}
	
}
