package com.course.cases;

import com.course.config.MD5Purity;
import com.course.config.TestConfig;

import com.course.config.complex;
import com.course.model.uBindingCase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class uBindingTest {


    @Test(description = "2.0解除绑定操作")
    public static void uBindingTest(String jsonStr) throws IOException {
        //解析json
        uBindingCase uBindingCase = complex.complexCase(jsonStr);

        //准备参数

        String Errmsg = "该店已经绑定!";

        if ( uBindingCase.getErrmsg().equals(Errmsg)) {
            System.out.println("该店已经绑定");
        }else {
            int deviceId = 12345;
            String OldFstoken = uBindingCase.getDataCase().getFstoken();
            //Fstoken加密
            String NewFstoken = MD5Purity.MD5Purity(OldFstoken+deviceId);
            String Fsseed = uBindingCase.getDataCase().getFsseed();
            HttpPost post = new HttpPost(TestConfig.ubinding);
            JSONObject param = new JSONObject();
            //添加数据
            param.put("fsseed", Fsseed);
            param.put("fstoken",NewFstoken);

            //设置请求头信息，设置Header
            post.setHeader("content-type","application/json");
            //将参数信息添加到方法中
            StringEntity entity = new StringEntity(param.toString());
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            //声明一个对象来进行响应结果的存储
            String result;
            //执行post方法
            HttpResponse response =  TestConfig.defaultHttpClient.execute(post);
            //获取响应结果
            result = EntityUtils.toString(response.getEntity(),"UTF-8");

            System.out.println(result);
        }

    }
}
