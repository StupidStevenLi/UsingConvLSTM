package com.lgy.usingconvlstm.Controller;


import com.alibaba.fastjson.JSONObject;
import com.lgy.usingconvlstm.Entity.ModelArgs;
import com.lgy.usingconvlstm.Entity.ModelReq;
import com.lgy.usingconvlstm.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

@Controller
public class BasicController {

    private static final String HOST = "127.0.0.1";

    @Autowired
    private IService iService;

    @ResponseBody
    @RequestMapping(value = "/managerPage/addModelInfo")
    public ResponseEntity addConsumerInfo(@RequestBody ModelReq modelReq) throws IOException {
        if(iService.count()>0){
            return new ResponseEntity<>("已存在训练中的模型，暂不可添加模型训练", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ModelArgs modelArgs = iService.createModelArgs(modelReq);

        String message = JSONObject.toJSONString(modelArgs);
        Socket client = new Socket(HOST, 9999);
        client.setSoTimeout(600000);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write(message.getBytes("UTF-8"));
        outputStream.close();
        client.close();

        HashMap<String, Object> map = iService.createMap(modelArgs);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/arredy")
    public ResponseEntity arredy(@RequestParam String aid)  {
        iService.arredyUpdate(aid);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/managerPage/getAllInfo")
    public ResponseEntity getAllInfo()  {
        HashMap<String, Object> map = iService.getAllInfo();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/showResult/create")
    public ResponseEntity finish(){
        StringBuilder sb = null;
        try {
            sb = iService.createSb(HOST);
            List<String> urlslist = iService.convertList(sb);
            HashMap<String, Object> map = iService.getAllInfo();
            map.put("urls",urlslist);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("模型预测运行出现问题", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
