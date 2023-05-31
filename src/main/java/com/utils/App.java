package com.utils;

public enum App {

    Getir("com.getir.casestudy.dev","com.getir.casestudy.modules.splash.ui.SplashActivity"),
//    Getir("com.getir.casestudy.dev","modules.splash.ui.SplashActivity");
    Calculator(" com.google.android.calculator","com.android.calculator2.Calculator");


    public String appPackage;
    public String appActivity;


    App(String appPackage, String appActivity) {
        this.appPackage=appPackage;
        this.appActivity=appActivity;
    }
}
