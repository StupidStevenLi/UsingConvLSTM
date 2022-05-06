package com.lgy.usingconvlstm.Service;

import com.alibaba.fastjson.JSON;
import com.lgy.usingconvlstm.Entity.ModelArgs;
import com.lgy.usingconvlstm.Entity.ModelReq;
import com.lgy.usingconvlstm.Entity.ModelResponse;
import com.lgy.usingconvlstm.Mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class IServiceImpl implements IService{
    @Autowired
    private Mapper mapper;

    @Override
    public ModelArgs createModelArgs(ModelReq modelReq) {
        String optimizer = "Adam";
        if(modelReq.getOptimizer()==1){
            optimizer = "Adam";
        }else{
            if(modelReq.getOptimizer()==0){
                optimizer = "Adel";
            }
        }
        mapper.insertTrain(modelReq.getKernelStructure(),modelReq.getFilters(),optimizer,modelReq.getEpochs());
        return mapper.getModelArgs();
    }

    @Override
    public HashMap<String, Object> createMap(ModelArgs modelArgs) {
        String kernelStructure = modelArgs.getK1()+"*"+modelArgs.getK1()+"-"+modelArgs.getK2()+"*"+modelArgs.getK2()+"-"+modelArgs.getK3()+"*"+modelArgs.getK3()+"3*3*3";
        String state = "正在训练";
        if(modelArgs.getState().equals("0")){
            state = "正在训练";
        }else{
            if(modelArgs.getState().equals("1")) {
                state = "训练完成";
            }
        }
        ModelResponse modelResponse = new ModelResponse(modelArgs.getAid(),modelArgs.getBatchSize(),modelArgs.getFilters(),kernelStructure,modelArgs.getLoss(),modelArgs.getOptimizer(),modelArgs.getEpochs(),state);
        List<ModelResponse> list = new ArrayList<>();
        list.add(modelResponse);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    @Override
    public HashMap<String, Object> getAllInfo() {
        ModelArgs modelArgs = mapper.getModelArgs();
        return createMap(modelArgs);
    }

    @Override
    public void arredyUpdate(String aid) {
        mapper.update(aid);
    }

    @Override
    public List<String> convertList(StringBuilder sb) {
        List<String> urlslist = JSON.parseArray(sb.toString(),String.class);
        for(int i=0;i<urlslist.size();i++){
            String e = "./img/" + urlslist.get(i);
            urlslist.remove(i);
            urlslist.add(i,e);
        }
        return urlslist;
    }

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public StringBuilder createSb(String host) throws IOException {
        String message = "create";
        Socket client = new Socket(host, 8888);
        client.setSoTimeout(600000);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write(message.getBytes("UTF-8"));

        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        client.shutdownOutput();

        InputStream inputStream = client.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        inputStream.close();
        outputStream.close();
        client.close();
        return sb;
    }
}
