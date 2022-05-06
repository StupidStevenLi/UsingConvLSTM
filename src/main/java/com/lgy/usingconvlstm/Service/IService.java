package com.lgy.usingconvlstm.Service;

import com.lgy.usingconvlstm.Entity.ModelArgs;
import com.lgy.usingconvlstm.Entity.ModelReq;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface IService {

    ModelArgs createModelArgs(ModelReq modelReq);

    HashMap<String, Object> createMap(ModelArgs modelArgs);

    HashMap<String, Object> getAllInfo();

    void arredyUpdate(String aid);

    List<String> convertList(StringBuilder sb);

    int count();

    StringBuilder createSb(String host) throws IOException;
}
