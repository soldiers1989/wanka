package com.wk.cms.service.impl;

import com.wk.cms.dao.WorkerDao;
import com.wk.cms.service.WorkerService;
import com.wk.cms.util.FileUtil;
import com.wk.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 员工服务实现类
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerDao workerDao;

    /**
     * 员工上传文件总路径
     */
    @Value("${config.upload.worker}")
    private String workerSourcePath;

    @Override
    public String  add(Worker worker) {
        worker.addInit();
        Integer addRow = workerDao.add(worker);
        if(addRow>0){
            return worker.getId();
        }else {
            return "";
        }
    }

    @Override
    public Integer delete(String id) {
        return workerDao.delete(id);
    }

    @Override
    public Worker get(String id) {
        return workerDao.get(id);
    }

    @Override
    public Integer update(Worker worker) {
        return workerDao.update(worker);
    }

    @Override
    public List<Worker> search(Worker worker) {
        return workerDao.search(worker);
    }

    @Override
    public Integer searchCount(Worker worker) {
        return workerDao.searchCount(worker);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Override
    public String uploadImg(MultipartFile file, String userId,String id) {
        if(id == null || id.trim().length()==0 ) {
            id = UUID.randomUUID().toString();
        }
        return FileUtil.uploadImg(file,workerSourcePath,id);
    }




}
