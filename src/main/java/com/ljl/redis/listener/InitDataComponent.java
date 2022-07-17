package com.ljl.redis.listener;

import com.ljl.redis.mapper.SysUserMapper;
import com.ljl.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class InitDataComponent {
    @Resource
    SysUserMapper sysUserMapper;

    @Autowired
    RedisUtil redisUtil;


    //=========第五步  添加redis启动类，启动时去读取数据库到缓存
    @PostConstruct//启动调用方法注解
    public void InitData(){
        System.out.println("------------项目启动加载redis缓存---------------");


        redisUtil.set("sysUser",sysUserMapper.selectList(null));

        System.out.println("------------启动redis缓存结束---------------");
    }

}
