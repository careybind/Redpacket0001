package com.bind.spring.redpacket.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bind.spring.redpacket.service.UserRedPacketService;

@Controller 
@RequestMapping("/userRedPacket") 
public class UserRedPacketController { 
	@Autowired 
	private UserRedPacketService userRedPacketService; 
	@RequestMapping(value = "/grapRedPacket") 
	@ResponseBody 
	public Map<String, Object> grapRedPacket(Long redpacketId, Long userId) {
		// 抢红包 
		int result = userRedPacketService.grapRedPacket(redpacketId, userId); 
		Map<String, Object> retMap = new HashMap<String, Object>(); 
		boolean flag = result > 0; 
		retMap.put("success", flag); 
		retMap.put("message", flag ? "抢红包成功" : "抢红包失败"); 
		return retMap; 
	}	
	@RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/grap.jsp
        return "grap";
    }
}

