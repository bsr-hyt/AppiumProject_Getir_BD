package com.utils;

public enum Device {

    //Buaraya kadar istediğin kadar cihaz yükleyebilirsin.
    Redmi_8("B1673511013", "8", "GM8 go", "Android"),
    Pixel2("emulator-5554","11","Pixel_2","Android");

    public String udid;
    public String version;
    public String deviceName;
    public String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }
}
