package com.phamquan.maydonhietdo.database;


import android.graphics.Color;

import java.util.Vector;

public class Helper {

    //kiem tra da kham chua
    private static boolean daCoHoSo = false;
    //kiem tra du lieu da duoc luu hay chua
    private static boolean dataSaved = false;

    public static String floatToString(float[] arr){


        StringBuilder chuoiMoi = new StringBuilder();

        for(int i= 0; i<arr.length; i++){
            chuoiMoi.append(String.valueOf(arr[i]));
            chuoiMoi.append("\t");
        }
        return (new String(chuoiMoi));
    }

    public static float[] stringToFloat(String s) {

        float[] arr = new float[24];
        String[] splits = s.split("\t");

        for(int i = 0; i < s.length(); i++){
            try{
                arr[i] = Float.parseFloat(splits[i]);
            }catch (Exception e){

            }
        }
        return arr;
    }

    public static Vector applyRule(float[] tayTrai, float[] tayPhai, float[] chanTrai, float[] chanPhai){
        float maxHaiTay, minHaiTay, maxHaiChan, minHaiChan;
        float maxTayTrai, minTayTrai, maxTayPhai, minTayPhai;
        float maxChanTrai, minChanTrai, maxChanPhai, minChanPhai;

        float[] phanTramTrai = new float[12];
        float[] phanTramPhai = new float[12];
        float[] phanTramTrungBinh = new float[12];

        maxTayTrai = getMax(tayTrai);
        maxTayPhai = getMax(tayPhai);
        maxHaiTay = Math.max(maxTayTrai, maxTayPhai);

        maxChanTrai = getMax(chanTrai);
        maxChanPhai = getMax(chanPhai);
        maxHaiChan = Math.max(maxChanTrai, maxChanPhai);

        minTayTrai = getMin(tayTrai);
        minTayPhai = getMin(tayPhai);
        minHaiTay = Math.min(minTayTrai, minTayPhai);

        minChanTrai = getMin(chanTrai);
        minChanPhai = getMin(chanPhai);
        minHaiChan = Math.min(minChanTrai, minChanPhai);

        float percentTayTrai;
        float percentChanTrai;
        float percentTayPhai;
        float percentChanPhai;
        float percentTay;
        float percentChan;

        float maxMinHaiTay = maxHaiTay - minHaiTay;
        float maxMinHaiChan = maxHaiChan - minHaiChan;

        int j = 6;

        for (int i = 0; i < 6; i++) {
        /*
        * 3*(nhietDoTayTrai + nhietDoTayPhai - nhietDoMaxOTay - nhietDoMinOTay)
        * /(nhietDoMax - nhietDoMin)
        * */
            percentTayTrai = 300 * (tayTrai[i] + tayPhai[i] - maxTayTrai - minTayTrai) / maxMinHaiTay;
            percentChanTrai = 300 * (chanTrai[i] + chanPhai[i] - maxChanTrai - minChanTrai) / maxMinHaiChan;

            percentTayPhai = 300 * (tayTrai[i] + tayPhai[i] - maxTayPhai - minTayPhai) / maxMinHaiTay;
            percentChanPhai = 300 * (chanTrai[i] + chanPhai[i] - maxChanPhai - minChanPhai) / maxMinHaiChan;

            percentTay = 300 * (tayTrai[i] + tayPhai[i] - maxHaiTay - minHaiTay) / maxMinHaiTay;
            percentChan = 300 * (chanTrai[i] + chanPhai[i] - maxHaiChan - minHaiChan) / maxMinHaiTay;

            percentTayTrai = (float) Math.round(percentTayTrai * 100) / 100;
            percentChanTrai = (float) Math.round(percentChanTrai * 100) / 100;
            percentTayPhai = (float) Math.round(percentTayPhai * 100) / 100;
            percentChanPhai = (float) Math.round(percentChanPhai * 100) / 100;
            percentTay = (float) Math.round(percentTay * 100) / 100;
            percentChan = (float) Math.round(percentChan * 100) / 100;

            phanTramTrai[i] = percentTayTrai;
            phanTramTrai[j] = percentChanTrai;

            phanTramPhai[i] = percentTayPhai;
            phanTramPhai[j] = percentChanPhai;

            phanTramTrungBinh[i] = percentTay;
            phanTramTrungBinh[j] = percentChan;
            ++j;

            phanTramPhai[5]*=0.75;
            phanTramTrai[5]*=0.75;
            phanTramTrungBinh[5]*=0.75;

            phanTramPhai[10]*=1.25;
            phanTramTrai[10]*=1.25;
            phanTramTrungBinh[10]*=1.25;
        }

        Vector phanTram = new Vector();
        phanTram.addElement(phanTramTrai);
        phanTram.addElement(phanTramPhai);
        phanTram.addElement(phanTramTrungBinh);
        return phanTram ;
    }

    public static float getMin(float[] arrFloat) {

        float min = arrFloat[0];

        for (int i = 0; i < arrFloat.length; i++) {
            if (arrFloat[i] < min) {
                min = arrFloat[i];
            }
        }
        return min;
    }

    public static float getMax(float[] arrFloat) {

        float max = arrFloat[0];
        for (int i = 0; i < arrFloat.length; i++) {
            if (arrFloat[i] > max) {
                max = arrFloat[i];
            }
        }
        return max;
    }


    public static int getColor(float barValue){

        barValue = Math.abs(barValue);

        if(barValue <50){
            return Color.GREEN;
        } else if(barValue >=50 && barValue<=100){
            return Color.BLUE;
        } else if(barValue >100 &&barValue<=200){
            return Color.YELLOW;
        }
        return Color.RED;
    }

    public static void setDaCoHoSo(boolean boo){
        daCoHoSo = boo;
    }

    public static void setDataSaved(boolean boo){
        dataSaved = boo;
    }

    public static boolean isDataSaved() {
        return dataSaved;
    }

    public static boolean isDaCoHoSo() {
        return daCoHoSo;
    }
}
