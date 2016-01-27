package com.phamquan.maydonhietdo;

/**
 * Created by Quan-PC on 21/1/2016.
 */
public class Control {

    private boolean initControl = false;
    private float [] benTrai;
    private float [] benPhai;
    private static String hoTen;

    public float[] getBenTrai(){
        return  benTrai;
    }

    public float[] getBenPhai(){
        return benPhai;
    }

    public void setBenTrai(float[] benTrai){
        this.benTrai = benTrai;
    }

    public void setBenPhai(float[] benPhai){
        this.benPhai = benPhai;
    }

    public boolean isInitControl(){
        return initControl;
    }

    public static String getHoTen(){
        return hoTen;
    }
}
