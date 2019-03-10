package com.course.config;

import com.course.model.dataCase;
import com.course.model.uBindingCase;

import com.google.gson.Gson;
import net.sf.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


/**
 * 解析稍微复杂json字符串
 * @paramjson
 */
public class complex {
    public static uBindingCase complexCase(String json){
//        JSONObject jsonObject= JSONObject.fromObject(json);
////        uBindingCase uBindingCase = (uBindingCase) JSONObject.toBean(jsonObject, uBindingCase.class);
//        Map<String, Class> map = new HashMap<String, Class>();
//        map.put("dataCase", dataCase.class);
//        uBindingCase uBindingCase = (uBindingCase) JSONObject.toBean(jsonObject, uBindingCase.class, map);
//        System.out.println(uBindingCase.getDataCase().getFsshopstauts());
//        System.out.println(uBindingCase.getDataCase().getFsshopstauts());

        Gson gson = new Gson();
        uBindingCase uBindingCase = gson.fromJson(json, com.course.model.uBindingCase.class);
        return uBindingCase;
    }


}
