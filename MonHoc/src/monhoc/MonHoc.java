/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;

class tenMonException extends Exception{
    
}

class nhomMonException extends Exception{
    
}

class soTinChiException extends Exception{
    
}

public class MonHoc {

    private int maMon;
    private String tenMon;
    private String nhomMon;
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinChi) throws tenMonException, nhomMonException, soTinChiException  {
        this.maMon = maMon;
        
        if(tenMon.equals("")) throw new tenMonException();
        else
        this.tenMon = tenMon;
        
        if(nhomMon.equalsIgnoreCase("Co ban") || nhomMon.equalsIgnoreCase("Co so nganh") ||nhomMon.equalsIgnoreCase("Chuyen nganh"))
        this.nhomMon = nhomMon;
        else throw new nhomMonException();
        
        if(soTinChi>0 && soTinChi<7)
        this.soTinChi = soTinChi;
        else throw new soTinChiException();
    }
    
    
    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNhomMon() {
        return nhomMon;
    }

    public void setNhomMon(String nhomMon) {
        this.nhomMon = nhomMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", nhomMon=" + nhomMon + ", soTinChi=" + soTinChi + '}';
    }
    
    
}
