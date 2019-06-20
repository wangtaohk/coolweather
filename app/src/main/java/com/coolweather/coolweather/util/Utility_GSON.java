package com.coolweather.coolweather.util;

import android.text.TextUtils;

import com.coolweather.coolweather.db.City;
import com.coolweather.coolweather.db.County;
import com.coolweather.coolweather.db.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Utility_GSON {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(TextUtils.isEmpty(response)) {
            List<Province> provinceList = new Gson().fromJson(response, new TypeToken<List<Province>>() {}.getType());
            for (Province province : provinceList) {
               province.save();
            }
            return true;
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(TextUtils.isEmpty(response)){
            List<City> cityList =new Gson().fromJson(response,new TypeToken<List<City>>(){}.getType());
            for(City city:cityList){
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if(TextUtils.isEmpty(response)){
            List<County> countyList=new Gson().fromJson(response,new TypeToken<List<County>>(){}.getType());
            for(County county:countyList){
                county.setCityId(cityId);
                county.save();
            }
            return true;
        }
        return false;
    }
}
