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

    public static Vector applyRule(float[] tayTrai, float[] tayPhai, float[] chanTrai, float[] chanPhai) {
        float[] phanTramTrai = new float[12];
        float[] phanTramPhai = new float[12];
        float[] phanTramTrungBinh = new float[12];
        float maxTayTrai = getMax(tayTrai);
        float maxTayPhai = getMax(tayPhai);
        float maxHaiTay = Math.max(maxTayTrai, maxTayPhai);
        float maxChanTrai = getMax(chanTrai);
        float maxChanPhai = getMax(chanPhai);
        float maxHaiChan = Math.max(maxChanTrai, maxChanPhai);
        float minTayTrai = getMin(tayTrai);
        float minTayPhai = getMin(tayPhai);
        float minHaiTay = Math.min(minTayTrai, minTayPhai);
        float minChanTrai = getMin(chanTrai);
        float minChanPhai = getMin(chanPhai);
        float minHaiChan = Math.min(minChanTrai, minChanPhai);
        float maxMinHaiTay = maxHaiTay - minHaiTay;
        float maxMinHaiChan = maxHaiChan - minHaiChan;
        int j = 6;
        for (int i = 0; i < 6; i++) {
            float percentChanTrai = (300.0f * (((chanTrai[i] + chanPhai[i]) - maxChanTrai) - minChanTrai)) / maxMinHaiChan;
            float percentTayPhai = (300.0f * (((tayTrai[i] + tayPhai[i]) - maxTayPhai) - minTayPhai)) / maxMinHaiTay;
            float percentChanPhai = (300.0f * (((chanTrai[i] + chanPhai[i]) - maxChanPhai) - minChanPhai)) / maxMinHaiChan;
            float percentTay = (300.0f * (((tayTrai[i] + tayPhai[i]) - maxHaiTay) - minHaiTay)) / maxMinHaiTay;
            float percentChan = (300.0f * (((chanTrai[i] + chanPhai[i]) - maxHaiChan) - minHaiChan)) / maxMinHaiTay;
            float percentTayTrai = ((float) Math.round(100.0f * ((300.0f * (((tayTrai[i] + tayPhai[i]) - maxTayTrai) - minTayTrai)) / maxMinHaiTay))) / 100.0f;
            percentChanTrai = ((float) Math.round(100.0f * percentChanTrai)) / 100.0f;
            percentTayPhai = ((float) Math.round(100.0f * percentTayPhai)) / 100.0f;
            percentChanPhai = ((float) Math.round(100.0f * percentChanPhai)) / 100.0f;
            percentTay = ((float) Math.round(100.0f * percentTay)) / 100.0f;
            percentChan = ((float) Math.round(100.0f * percentChan)) / 100.0f;
            phanTramTrai[i] = percentTayTrai;
            phanTramTrai[j] = percentChanTrai;
            phanTramPhai[i] = percentTayPhai;
            phanTramPhai[j] = percentChanPhai;
            phanTramTrungBinh[i] = percentTay;
            phanTramTrungBinh[j] = percentChan;
            j++;
            phanTramPhai[5] = (float) (((double) phanTramPhai[5]) + (0.25d * ((double) Math.abs(phanTramPhai[5]))));
            phanTramTrai[5] = (float) (((double) phanTramTrai[5]) + (0.25d * ((double) Math.abs(phanTramTrai[5]))));
            phanTramTrungBinh[5] = (float) (((double) phanTramTrungBinh[5]) + (0.25d * ((double) Math.abs(phanTramTrungBinh[5]))));
            phanTramPhai[10] = (float) (((double) phanTramPhai[10]) - (0.25d * ((double) Math.abs(phanTramPhai[10]))));
            phanTramTrai[10] = (float) (((double) phanTramTrai[10]) - (0.25d * ((double) Math.abs(phanTramPhai[10]))));
            phanTramTrungBinh[10] = (float) (((double) phanTramTrungBinh[10]) - (0.25d * ((double) Math.abs(phanTramPhai[10]))));
        }
        Vector phanTram = new Vector();
        phanTram.addElement(phanTramTrai);
        phanTram.addElement(phanTramPhai);
        phanTram.addElement(phanTramTrungBinh);
        return phanTram;
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
