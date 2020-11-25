/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;

import java.util.ArrayList;


public class DB {
    static ArrayList<MonHoc> listMonHoc=new ArrayList<>();
    public static void main(String[] args) {
        for(int i=0;i<listMonHoc.size();i++) System.out.println(listMonHoc.get(i));
    }
}
