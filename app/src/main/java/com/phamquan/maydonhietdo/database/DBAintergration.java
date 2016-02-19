package com.phamquan.maydonhietdo.database;


public class DBAintergration {

    //kiem tra da kham chua
    private static boolean daCoHoSo = false;
    //kiem tra du lieu da duoc luu hay chua
    private static boolean dataSaved = false;

    public static String floatToString(float[] arr){

        String chuoiMoi = new String();

        for(int i= 0; i<arr.length; i++){
            chuoiMoi+= arr[i]+ "u";
        }
        return chuoiMoi;
    }

    public static float[] stringToFloat(String s) {

        int j = 0;
        float[] arr = new float[12];
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < s.length(); i++){
            char att = s.charAt(i);
            if(att=='u'){
                arr[j] = Float.parseFloat(sb.toString());
                j++;
                sb = new StringBuffer();
            } else {
                sb = sb.append(att);
            }
        }
        return arr;
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
