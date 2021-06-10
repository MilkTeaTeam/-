/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

/**
 *
 * @author 小黄的天下
 */
public class Product {//商品定义
    
    private String name;//名字
    private float price;//价格
    private String sizetype;//尺寸大小
    private int num = 0;//数量
    
    public int getNum(){
     return num;   
    }
    
    public void setNum(int num){
     this.num=num;   
    }
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public float getPrice() {
	return price;
    }
    
    public void setPrice(float price) {
	this.price = price;
    }
    
    public String getSizetype(){
        return sizetype;
    }
    
    public void setSizetype(String sizetype){
        this.sizetype = sizetype;
    }
    
    public Product(){
    
    }
    
    public Product(String name,String sizetype,float price,int num) {
	this.name=name;
	this.price=price;
        this.sizetype=sizetype;
        this.num = num;
    }

}
