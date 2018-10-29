package com.wk.cms.controller;

import com.wk.bean.BaseResponse;
import com.wk.cms.service.ModelService;
import com.wk.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模块信息控制类
 */
@RestController
@RequestMapping("/model")
public class ModelController extends  BaseController {
    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse  add(@RequestBody Model model){
        String id = modelService.add(model);
        return responseAdd(model,id,this.getClass());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public BaseResponse delete(String id){
        Integer affectRow = modelService.delete(id);
        return responseDelete(affectRow,id,this.getClass());
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse update(@RequestBody Model model){
        Integer affectRow = modelService.update(model);
        return responseUpdate(affectRow,model,this.getClass());
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public BaseResponse get(String id){
        Model model = modelService.get(id);
        return responseGet(model,this.getClass());
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public BaseResponse search(Model model){
        List<Model> models = modelService.search(model);
        Integer total = 0;
        if(model.getPage()==1){
            total = modelService.searchCount(model);
        }
        return responseSearch(models,total,model, this.getClass());
    }
}
