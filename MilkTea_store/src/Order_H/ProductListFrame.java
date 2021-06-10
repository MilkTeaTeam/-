package Order_H;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ProductListFrame {

	JTable productListTable;
	JFrame productListGui = new JFrame("商城");

	public ProductListFrame(ShoppingCart shoppingCart, Prolist mall) {
		initComponents(shoppingCart, mall);
	}

	private void initComponents(final ShoppingCart shoppingCart, Prolist mall) {

		productListGui.setLayout(null); // 清除布局函数
		productListGui.setResizable(false); // 设置窗体大小不可变

		productListGui.setLayout(new BorderLayout()); // 新建BorderLayout布局

		// 中间
		JPanel panel2 = new JPanel(new FlowLayout());

		DefaultTableModel model = new DefaultTableModel() { // 表格数据不可改
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Vector<Vector<Object>> date = new Vector<Vector<Object>>();
		Vector<String> names = new Vector<String>();
		
		names.add("商品名");
                names.add("大小杯");
                names.add("商品类型");
		names.add("单价(元)");

		model.setDataVector(mall.getList(), names);

		final JTable productListTable = new JTable(model);// 创建一个表格，指定 所有行数据 和 表头
		setWindow.setTable(productListTable); // 设置表格

		JScrollPane ProductListScrollPane = new JScrollPane(productListTable);

		panel2.add(ProductListScrollPane);
		panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
		productListGui.add(panel2, BorderLayout.CENTER);

		// 标题
		JPanel panel1 = new JPanel(new GridLayout(2, 0));
		JLabel jl1 = new JLabel("商品列表");
		jl1.setFont(new Font("微软雅黑", Font.BOLD, 25)); // 设置字体、样式、大小
		JLabel jl2 = new JLabel("共 " + productListTable.getRowCount() + " 件宝贝");
		jl2.setFont(new Font("微软雅黑", Font.PLAIN, 19)); // 设置字体、样式、大小
		panel1.add(jl1);
		panel1.add(jl2);
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
		productListGui.add(panel1, BorderLayout.NORTH);

		// 版权归属
		JPanel panel3 = new JPanel(new GridLayout(2, 0));
		JButton jb1 = new JButton("添加到购物车");
		jb1.setFont(new java.awt.Font("黑体", 1, 20));
		JLabel jl3 = new JLabel("©2018集美大学 兰泽祥 吴修恩");
		jl3.setFont(new Font("微软雅黑", Font.PLAIN, 15)); // 设置字体、样式、大小
		jl3.setHorizontalAlignment(SwingConstants.CENTER); // 设置控件左右居中对齐
		panel3.add(jb1, JPanel.RIGHT_ALIGNMENT);
		panel3.add(jl3);
		productListGui.add(panel3, BorderLayout.SOUTH);

		// Display the window.
		productListGui.setSize(450, 750);
		productListGui.setVisible(false);
		// 设置窗口居中显示
		setWindow.setFrameNear(productListGui);

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// AddProduct();
				String inputValue = JOptionPane.showInputDialog("请输入添加的商品数量");
				int a = Integer.parseInt(inputValue);
				DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) productListTable.getModel();
				
				int row = productListTable.getSelectedRow();
				Vector<Object> v = new Vector<Object>();
				v.add(dtm.getValueAt(row, 0));
				v.add(dtm.getValueAt(row, 1));
				v.add(dtm.getValueAt(row, 3));
				v.add(a);
				double b = (Double) dtm.getValueAt(row, 3);
				double vSum = a * b;
				v.add(vSum);
				Prolist pro = new Prolist();
				
				ShoppingCart_Definition cart = shoppingCart.getShoppingCart_Definition();
				int index = cart.addProduct(pro.Transform(v));

                                mall.Judge(shoppingCart,cart,v,index);//商品加入购物车
				
				
				ShoppingCart.setShoppingCartCenterPanel(1);
			}
		});
	}

	public JTable getProductList() {
		return productListTable;
	}

	public void setProductList(JTable productList) {
		productListTable = productList;
	}

	public JFrame getShoppingCarGui() {
		return productListGui;
	}

	public void setShoppingCarGui(JFrame shoppingCarGui) {
		productListGui = shoppingCarGui;
	}

}
