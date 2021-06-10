/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 小黄的天下
 */
public class Prolist {//获得奶茶的信息
    
    Product pro;
    Vector<Vector<Object>> list = new Vector<Vector<Object>>();
    
    //将表格中的数据转换成vector
    public Product Transform(Vector<Object> v){
        
        String name = (String)v.get(0);
        String size = (String)v.get(1);
        float price = Float.parseFloat(v.get(2).toString());
        int num = Integer.parseInt(v.get(3).toString());
        pro = new Product(name,size,price,num);
        return pro;
        
    }
    
    //添加进购物车
    public void Judge(ShoppingCart SC,ShoppingCart_Definition SD,Vector<Object> v,int JP){
        if(JP != -1){//购物车已有的商品
            DefaultTableModel dm = (DefaultTableModel)SC.shoppingCartTable.getModel();//获得购物车的数据
            dm.setValueAt(SD.getProduct().get(JP).getNum(),JP , 3);//修改数量
            double total = SD.getProduct().get(JP).getNum()*SD.getProduct().get(JP).getPrice();
            dm.setValueAt(total, JP, 4);//修改价格
        }else{//购物车加入新的商品
            SC.getDate().add(v);//加入购物车
            SC.getShoppingCartTable().updateUI();//刷新
            ShoppingCart_Definition.setTotal( ShoppingCart_Definition.getTotal());
        }
        SC.getTotal().setText("惊！这 " + SC.getShoppingCartTable().getRowCount() + " 款奶茶的价格才："+ ShoppingCart_Definition.getTotal()+" RMB");
        ShoppingCart.setShoppingCartCenterPanel(1);
    }
    
    public Product getPro() {
	return pro;
    }

    public void setPro(Product pro) {
	this.pro = pro;
    }
    
    public Vector<Vector<Object>> getList(){
        return list;
    }
    
    public void setList(Vector<Vector<Object>> list){
        this.list = list;
    }

}
