package com.lgy.usingconvlstm.Mappers;

import com.lgy.usingconvlstm.Entity.ModelArgs;
import com.lgy.usingconvlstm.Entity.ModelResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Mapper {

    int insertTrain(@Param("ksid") int kernelStructure, @Param("filters") int filters,@Param("optimizer") String optimizer,@Param("epochs") int epochs);

    ModelArgs getModelArgs();

    int update(@Param("aid") String aid);

    int count();
}
