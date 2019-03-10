package com.course.cases;

import com.course.Database.InsertDataBase;
import com.course.Database.SelectDataBase;
import com.course.config.TestConfig;
import com.course.config.complex;
import com.course.model.InterfaceName;
import com.course.model.bindingWithShopTypeCase;
import com.course.model.uBindingCase;
import com.course.utils.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;


public class bindingWithShopTypeTest {

    @BeforeTest(description = "测试前的准备工作，获取HttpClient对象")
    public void beforeTest() {
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.bindUrl = ConfigFile.getUrl(InterfaceName.BIND);
        TestConfig.bindingWithShopTypeUrl = ConfigFile.getUrl(InterfaceName.BINDINGWITHSHOPTYPE);
        //TestConfig.bindingWithShopTypeUrl = ConfigFile.getUrlRelease(InterfaceName.BINDINGWITHSHOPTYPE);
        TestConfig.ubinding = ConfigFile.getUrl(InterfaceName.UBINDING);


    }

    @Test(description = "1.1绑定接口(根据店铺类型)")
    public void bindingWithShopTypeTest() throws IOException {

        //下边的代码为接口的测试代码
        bindingWithShopTypeCase bindingWithShopTypeCase = new bindingWithShopTypeCase();
        getResult(bindingWithShopTypeCase);

    }

    private String getResult(bindingWithShopTypeCase bindingWithShopTypeCase)throws IOException{

        HttpPost post = new HttpPost(TestConfig.bindingWithShopTypeUrl);
        JSONObject param = new JSONObject();

        //数据插入数据库中
        bindingWithShopTypeCase b=new bindingWithShopTypeCase();
        InsertDataBase insertDataBase = new InsertDataBase();
        b.setShopType(0);
        b.setDeviceId(12345);
        insertDataBase.insert(b);

        /***
        bindingWithShopTypeCase.setShopType(0);
        bindingWithShopTypeCase.setDeviceId(12345);
         */
        //将数据从数据库中取出
        int dID = 0;
        int gST = 0;
        ArrayList<bindingWithShopTypeCase> arrayList = new SelectDataBase().getList();
        for (bindingWithShopTypeCase BWSTC:arrayList){
             dID = BWSTC.getDeviceId();
             gST = BWSTC.getShopType();
            System.out.println(BWSTC.getDeviceId()+""+BWSTC.getShopType());
        }

        param.put("deviceId",dID);
        param.put("shopType",gST);

        //设置请求头信息，设置Header
        post.setHeader("content-type","application/json");
        //post.setHeader("content-type","content-type=application/json");
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

        //解除绑定操作
        //uBindingTest.uBindingTest(result);

        //解析json
        uBindingCase uBindingCase = complex.complexCase(result);

        return result;
    }


}
