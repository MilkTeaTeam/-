package Order_H;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class MenuGui {
	public MenuGui() {
		initmenuGui();
    }
	//菜单GUI
	public void initmenuGui() {

		Prolist mall=new Prolist();//新建商城
                mall.setList(DBicon.queryProductData("Select * from Drink"));                
		
		
		final ShoppingCart shoppingcartgui= new ShoppingCart();//新建购物车界面
		final ProductListFrame productlistgui=new ProductListFrame(shoppingcartgui,mall);//新建商品列表界面
		
		
		JFrame menu = new JFrame("菜单导航");
		
		menu.setLayout(null); // 清除布局函数
		menu.setResizable(false); // 设置窗体大小不可变
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menu.setLayout(new BorderLayout()); // 新建BorderLayout布局

		// 欢迎语
		JPanel panel1 = new JPanel(new FlowLayout());
		JLabel jl1 = new JLabel("欢迎您来到集美购物商场");
		jl1.setFont(new Font("微软雅黑", Font.BOLD, 30)); // 设置字体、样式、大小
		panel1.add(jl1);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		menu.add(panel1, BorderLayout.NORTH);

		// 菜单按钮
		JPanel panel2 = new JPanel(new GridLayout(5, 1));
		JButton jb1 = new JButton("商品列表");
		jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	productlistgui.getShoppingCarGui().setVisible(true);
            }
        });
		
		JButton jb2 = new JButton("查找商品");
		
		JButton jb3 = new JButton("查看购物车");
		jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            		shoppingcartgui.getShoppingCar().setVisible(true);
            }
        });
		
		JButton jb4 = new JButton("查看订单");
		
		JButton jb5 = new JButton("退出商场");
		jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

		int w = 10;
		int h = 50;
		jb1.setPreferredSize(new Dimension(w, h));
		jb2.setPreferredSize(new Dimension(w, h));
		jb3.setPreferredSize(new Dimension(w, h));
		jb4.setPreferredSize(new Dimension(w, h));
		jb5.setPreferredSize(new Dimension(w, h));

		jb1.setFont(new java.awt.Font("黑体", 1, 20));
		jb2.setFont(new java.awt.Font("黑体", 1, 20));
		jb3.setFont(new java.awt.Font("黑体", 1, 20));
		jb4.setFont(new java.awt.Font("黑体", 1, 20));
		jb5.setFont(new java.awt.Font("黑体", 1, 20));

		panel2.add(jb1);
		panel2.add(jb2);
		panel2.add(jb3);
		panel2.add(jb4);
		panel2.add(jb5);

		panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
		menu.add(panel2);

		// Display the window.
		menu.pack();
		menu.setVisible(true);
		// 设置窗口居中显示
		setWindow.setFrameCenter(menu);
	}

        public static void main(String[] args){
            new MenuGui();
        }
        
}
