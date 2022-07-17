package com.ljl.redis.conllection;

import com.ljl.redis.domain.SysUser;
import com.ljl.redis.mapper.SysUserMapper;
import com.ljl.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisConllection {
    @Resource
    SysUserMapper sysUserMapper;
    @Autowired
    RedisUtil redisUtil;


    //-----------------第六步正常使用redis方法
    @RequestMapping("redis1")
    public List<SysUser> redis1(){


        return (List<SysUser>) redisUtil.get("sysUser");
    }

}
