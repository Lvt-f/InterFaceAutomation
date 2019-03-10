package com.course.model;

public class bindingWithShopTypeCase {

/*"deviceId":"123123123",设备号
  "shopType":1 #0:普通门店 1:美小易 2：美收银 3：windows  4:口碑*/
    private int deviceId;
    private int shopType;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getShopType() {
        return shopType;
    }

    public void setShopType(int shopType) {
        this.shopType = shopType;
    }
}
