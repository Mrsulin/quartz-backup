package com.quartz.controller;

import com.quartz.entity.EhUser;
import com.quartz.service.EhUserService;
import com.quartz.service.QuartzService;
import com.quartz.starter.Sjob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (EhUser)表控制层
 *
 * @author makejava
 * @since 2020-02-13 18:52:19
 */
@RestController
@RequestMapping("ehUser")
@Api(tags = "测试模块")
public class EhUserController {
    /**
     * 服务对象
     */
    @Resource
    private EhUserService ehUserService;

    @Autowired
    QuartzService quartzService;

    @GetMapping("/all")
    @ApiOperation(value = "测试接口")
    public List<EhUser> selectOne() {
        List<EhUser> ehUsers = ehUserService.queryAllByLimit(0, 2);
        return ehUsers;
    }


    @GetMapping("/start")
    @ApiOperation(value = "测试接口")
    public String start() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",1);
        quartzService.deleteJob("job", "test");
        quartzService.addJob(Sjob.class, "job", "test", "0 * * * * ?", map);

        map.put("name",2);
        quartzService.deleteJob("job2", "test");
        quartzService.addJob(Sjob.class, "job2", "test", "10 * * * * ?", map);

        map.put("name",3);
        quartzService.deleteJob("job3", "test2");
        quartzService.addJob(Sjob.class, "job3", "test2", "15 * * * * ?", map);
        return "success";
    }

}