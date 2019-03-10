package com.course.utils;

import com.course.model.InterfaceName;


import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application",Locale.CHINA);

    //调用测试环境
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        if(name == InterfaceName.BIND){
            uri = bundle.getString("bind.uri");
        }
        if (name == InterfaceName.BINDINGWITHSHOPTYPE){
            uri = bundle.getString("bindingWithShopType.uri");
        }
        if(name == InterfaceName.UBINDING){
            uri = bundle.getString("ubinding.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
    //调用正式环境
    public static String getUrlRelease(InterfaceName name){
        String address = bundle.getString("release.url");
        String uri = "";
        String ReleaseUrl;
        if(name == InterfaceName.BIND){
            uri = bundle.getString("bind.uri");
        }
        if (name == InterfaceName.BINDINGWITHSHOPTYPE){
            uri = bundle.getString("bindingWithShopType.uri");
        }
        if(name == InterfaceName.UBINDING){
            uri = bundle.getString("ubinding.uri");
        }
        ReleaseUrl = address + uri;
        return ReleaseUrl;
    }
}
