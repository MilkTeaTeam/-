/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdemo;
import javax.swing.*;


/**
 *
 * @author Administrator
 */
public class MyThread extends Thread{
    JProgressBar prg;
    
    MyThread(){
        
    }
    
    MyThread(JProgressBar prg){
        this.prg=prg;
    }
    
    public void run(){
        try{
            while(true){
                Thread.sleep(20);
                int value=prg.getValue();
                value++;
                prg.setValue(value);
                if(prg.getValue()>=prg.getMaximum()){
                    break;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
