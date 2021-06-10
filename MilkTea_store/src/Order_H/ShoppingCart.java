/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 小黄的天下
 */
public class ShoppingCart {
    JTable shoppingCartTable;//定义购物车布局
    Vector<Vector<Object>> date = new Vector<Vector<Object>>();//数据
    Vector<String> ColumnNames = new Vector<String>();//列名
    JLabel total;//购物车价格及量的说明
    JFrame emptyShoppingCar = new JFrame("购物车");
    JFrame ShoppingCar = new JFrame("购物车");
    ShoppingCart_Definition shopping = new ShoppingCart_Definition();
    static CardLayout card = new CardLayout();//定义个卡片布局
    static JPanel centerPanel=new JPanel(card);
    
    public ShoppingCart(){
       ShoppingCartFrame();     
    }
    
    public void ShoppingCartFrame(){
        ShoppingCar.setLayout(null); // 清除布局函数
	ShoppingCar.setResizable(false); // 设置窗体大小不可变
        ShoppingCar.setLayout(new BorderLayout()); // 新建BorderLayout布局(边界布局)
        
        //空的购物车
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));//流式布局
        ImageIcon icon = new ImageIcon("image/ia.jpg");//设置空购物车图片
        JLabel label = new JLabel(icon);//放入布局中
	panel_1.add(label);
        
        //非空购物车
        JPanel panel_2 = new JPanel(new FlowLayout(2));//2代表右对齐，空默认居中对齐
        DefaultTableModel model = new DefaultTableModel(){//数据表，用来控制JTable,设置数据表内的数值是否可修改
            public boolean isCellEditable(int row,int column){
                if(column == 3) return true;//返回true代表可以编辑单元格
                else return false;
            }
        };
        
        //定义Column动态数组
        ColumnNames.add("奶茶名");
        ColumnNames.add("杯具");
        ColumnNames.add("价格RMB");
        ColumnNames.add("数量");
        ColumnNames.add("总和");
        
        //定义表格
        model.setDataVector(date, ColumnNames);//第一个是数据向量，第二个是行索引（列的名称）
        shoppingCartTable = new JTable(model);//创建一个表格，指定所以行数据和表头
        setWindow.setTable(shoppingCartTable); // 设置表格
        
        //定义滚动条
        JScrollPane shoppingCarScrollPane = new JScrollPane(shoppingCartTable);//添加滚动条
        shoppingCarScrollPane.setBorder(null);//不显示滚动条
        
        //总算
        JPanel too = new JPanel(new GridLayout(1,0));//网格布局,表示一行，不限列
        total = new JLabel("惊！这 " + shoppingCartTable.getRowCount() + " 款奶茶的价格才："+ ShoppingCart_Definition.getTotal()+" RMB");
        total.setFont(new Font("微软雅黑", Font.PLAIN, 19)); // 设置字体、样式、大小
        JLabel soga = new JLabel("走过路过不容错过！！！");
        soga.setFont(new Font("微软雅黑", Font.PLAIN, 19));
            
        //按钮定义
        JButton jb1 = new JButton("删除商品");
        jb1.setFont(new java.awt.Font("黑体", 1, 20));
        JButton jb2 = new JButton("去结算");
        jb2.setFont(new java.awt.Font("黑体", 1, 20));
        
        //填充Panel
        too.add(jb1);
        too.add(jb2);
        JPanel to = new JPanel(new GridLayout(3,0));
        to.add(too);
        to.add(total);
        to.add(soga);
        panel_2.add(shoppingCarScrollPane);
        panel_2.add(to);
        panel_2.setBorder(new EmptyBorder(10,10,10,10));//empty指空白边界
        
        centerPanel.add(panel_1,"emptyShoppingCart");
	centerPanel.add(panel_2,"ShoppingCart");
        
        //判断空或非空布局
        if(shoppingCartTable.getRowCount() == 0){
            setShoppingCartCenterPanel(0);
        }else{
            setShoppingCartCenterPanel(1);
        }
        
        ShoppingCar.add(centerPanel,BorderLayout.CENTER);
        
        //标题
        JPanel toptitle = new JPanel(new GridLayout(1,0));
        JLabel jl_1 = new JLabel("我的奶茶也要用购物车来装！");
        jl_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
        toptitle.add(jl_1);
        toptitle.setBorder(new EmptyBorder(10,10,10,10));
        ShoppingCar.add(toptitle,BorderLayout.NORTH);
        
        JLabel jl_2 = new JLabel("丝袜奶茶总能不经意触动你的心！满满的爱赠与最好的你^_^",JLabel.CENTER);
        ShoppingCar.add(jl_2,BorderLayout.SOUTH);
        
        ShoppingCar.setSize(450, 750);
        ShoppingCar.setVisible(true);
        setWindow.setFrameNear(ShoppingCar);
        
        //对删除奶茶按钮的定义
        jb1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(shoppingCartTable.getRowCount() == 0){
                    setShoppingCartCenterPanel(0);
                    return;
                }
                DefaultTableModel dtm = (DefaultTableModel)shoppingCartTable.getModel();//获得表格的数据
                int row=shoppingCartTable.getSelectedRow();//被选中的行
                String s=(String)dtm.getValueAt(row, 0);//获得奶茶名字
                double n=Double.parseDouble(dtm.getValueAt(row, 4).toString());//获得删除奶茶的总价
                JOptionPane.showMessageDialog(null, s + " 删除成功！", "温馨提示",1);//定义弹窗
                dtm.removeRow(row);//删除对应行网格表奶茶数据
                shopping.getProduct().remove(row);//删除对应
                ShoppingCart_Definition.setTotal(ShoppingCart_Definition.getTotal()-n);//修改总价
                total.setText("惊！这 " + shoppingCartTable.getRowCount() + " 款奶茶的价格才："+ ShoppingCart_Definition.getTotal()+" RMB");//更新奶茶款数
                if( shoppingCartTable.getRowCount() == 0 ) {
        		setShoppingCartCenterPanel(0);
        	}
            }
        });
        
        //购物车结算按钮的定义
        jb2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(date.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "我找不到", "没了",0);
                    return;
		}
                 JOptionPane.showMessageDialog(null, "恭喜您，付款成功！一共消费了"+ShoppingCart_Definition.getTotal()+"RMB", "消费成功",0);
                 ShoppingCart_Definition.setTotal(0.0);
                 date.clear();//删除所有元素
                 shoppingCartTable.updateUI();//刷新界面
                 setShoppingCartCenterPanel(0);
            }
        });
        
        //数据表修改的定义  
        shoppingCartTable.getModel().addTableModelListener(new TableModelListener(){

            @Override
            public void tableChanged(TableModelEvent e) {
                int tcolumn = e.getColumn();
                int row = e.getFirstRow();
                
                if( tcolumn == 3 ){
                   double v4 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row,4)));
                    ShoppingCart_Definition.setTotal(ShoppingCart_Definition.getTotal()-v4);//去掉这款奶茶的总额
                    double v3 = 0;
                    try{
                        v3 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 3)));
                    }catch(NumberFormatException ex){//防止输入的不是数值
                        ex.printStackTrace();
                    }
                    double v2 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 2)));
                    shoppingCartTable.setValueAt(v2 * v3, row, 4);//设定值，总价的计算方法
                    v4 = Double.valueOf(String.valueOf(shoppingCartTable.getValueAt(row, 4)));
                    ShoppingCart_Definition.setTotal(ShoppingCart_Definition.getTotal()+v4);//再补充这款奶茶的总额
                    total.setText("惊！这 " + shoppingCartTable.getRowCount() + " 款奶茶的价格才："+ ShoppingCart_Definition.getTotal()+" RMB");
                    shopping.getProduct().get(row).setNum((int)v3);
                }
                
                
            }
            
        });
        
        
    }
    
    public static void setShoppingCartCenterPanel(int x) {//选择布局
	if( x == 0 ) {
		card.show(centerPanel,"emptyShoppingCart");
	}else {
		card.show(centerPanel,"ShoppingCart");
	}
    }
    
    public JTable getShoppingCartTable(){
        return shoppingCartTable;
    }
    
    public void setShoppingCartTable(JTable jt){
        this.shoppingCartTable = jt;
    }
    
    public JFrame getShoppingCar(){
        return ShoppingCar;
    }
    
    public void setShoppingCar(JFrame shoppingcar){
        ShoppingCar = shoppingcar;
    }
    
    public ShoppingCart_Definition getShoppingCart_Definition(){
        return shopping;
    }
    
    public void setShoppingCart_Definition(ShoppingCart_Definition sdefinition){
        this.shopping = sdefinition;
    }
    
    public JLabel getTotal(){
        return total;
    }
    
    public void setTotal(JLabel jl){
        this.total = jl;
    }
    
    public Vector<Vector<Object>> getDate(){
	return date;
    }
    
    public void setDate(Vector<Vector<Object>> date) {
	this.date = date;
    }
    
}
