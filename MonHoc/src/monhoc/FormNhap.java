/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class FormNhap extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    TextField tf1,tf2,tf3;
    JButton button;
    JPanel p;
    
    static int maMonAuto=1000;
    
    
    public FormNhap() throws FileNotFoundException {

        setLayout(new FlowLayout());
        
        p=new JPanel(new GridLayout(3, 3));
        
        l1=new JLabel("Nhap Ten Mon: ");
        tf1=new TextField(20);
        l2=new JLabel("tên ko được để trống");
        
        l3=new JLabel("Nhap Nhom Mon: ");
        tf2=new TextField(20);
        l4=new JLabel("nhóm môn phải là co ban, co so nganh, chuyen nganh");
        
        l5=new JLabel("Nhap So Tin Chi: ");
        tf3=new TextField(20);
        l6=new JLabel("số tín chỉ >0 và <7");
        
        l7= new JLabel();
        p.add(l1);
        p.add(tf1);
        p.add(l2);
        p.add(l3);
        p.add(tf2);
        p.add(l4);
        p.add(l5);
        p.add(tf3);
        p.add(l6);
        add(p);
        button=new JButton("Luu FIle");
        add(button);
        add(l7);
        
        tf1.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                if(tf1.getText().equals("")){
                    l2.setText("tên ko được để trống");
                }
                else l2.setText("");
            }
        });
        
        tf2.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                if(tf2.getText().equalsIgnoreCase("co ban") || tf2.getText().equals("co so nganh") ||tf2.getText().equals("chuyen nganh"))
                    l4.setText("");
                else l4.setText("nhóm môn phải là co ban, co so nganh, chuyen nganh");
            }
        });
        
        tf3.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                int temp=Integer.parseInt(tf3.getText());
                if(tf3.getText().equals("")) l6.setText("số tín chỉ >0 và <7");
                
                else if(temp>0 && temp<7) l6.setText("");
                
                else l6.setText("số tín chỉ >0 và <7");
            }
        });
        
        File f=new File("MH.TXT");
        PrintStream ps=new PrintStream(f);
        
        
        button.addActionListener(new ActionListener() {
            
            
          
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    MonHoc mh=new MonHoc(maMonAuto++,tf1.getText(),tf2.getText(),Integer.parseInt(tf3.getText()));
                    DB.listMonHoc.add(mh);
                    
                    for(int i=0;i<DB.listMonHoc.size();i++)System.out.println(DB.listMonHoc.get(i));
                    ps.append(mh.getMaMon()+"\n");
                    ps.append(mh.getTenMon()+"\n");
                    ps.append(mh.getNhomMon()+"\n");
                    ps.append(""+mh.getSoTinChi()+"\n");
                    
                    
                    l7.setText("luu file thanh cong: "+f.getAbsolutePath());
                }
                catch(tenMonException ex){
                    
                }
                catch(nhomMonException ex){
                    
                }
                catch(soTinChiException ex){
                    
                } 
                
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        FormNhap fn=null;
        try {
            fn = new FormNhap();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        fn.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fn.setVisible(true);
        fn.setSize(1500, 1500);
    }
    
    
}
