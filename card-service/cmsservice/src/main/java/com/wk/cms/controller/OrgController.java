package com.wk.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.wk.bean.BaseResponse;
import com.wk.bean.Globel;
import com.wk.cms.service.OrgService;
import com.wk.entity.Org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 组织控制类
 */
@RequestMapping("/org")
@RestController
public class OrgController extends BaseController{

    @Autowired
    private OrgService orgService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse add(Org org){
        String id = orgService.add(org);
        return responseAdd(org,id,this.getClass());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public BaseResponse delete(String id){
        Integer affectRow = orgService.delete(id);
        return responseDelete(affectRow,id,this.getClass());
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse update(Org org){
        Integer affectRow = orgService.update(org);
        return responseUpdate(affectRow,org,this.getClass());
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public BaseResponse get(String id){
        Org org = orgService.get(id);
        return responseGet(org,this.getClass());
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse search(Org org){
        List<Org> orgs = orgService.search(org);
        int total = 0;
        if(org.getPage()==1){
            total = orgService.searchCount(org);
        }
        return responseSearch(orgs,total,org,this.getClass());
    }
}
