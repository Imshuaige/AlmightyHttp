package com.lrl;

import com.lrl.constant.RequestConstant;
import com.lrl.req.ManageRequest;
import org.junit.Test;

import java.util.HashMap;

public class ReqTest {

    @Test
    public void test() {
        HashMap<String,String> param = new HashMap<>();
        param.put("testKey1","testVal1");
        param.put("testKey2","testVal2");
        param.put("testKey3","testVal3");
        ManageRequest.excuteStrategy(RequestConstant.FORM_POST,"http://localhost:8080/workflow/update.htm",param);
    }
}
