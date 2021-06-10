/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author 小黄的天下
 */
public class DBicon {
    
    static Connection conn;
    
    static{
        ConDB();
    }
    
    public DBicon(){
        
    }
    
    //JDBC方式连接数据库的方法
    public static void ConDB(){
        try{
            //加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //定义连接字符串
            String url="jdbc:sqlserver://localhost:1433; databaseName=milk";///
            //创建连接
            conn=DriverManager.getConnection(url,"sa", "88888888");
        }catch(ClassNotFoundException ex){
            System.out.println("驱动程序找不到异常");
            ex.printStackTrace();
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
        }
    }
    
    //访问数据表，读取数据
    public static Vector<Vector<Object>> queryProductData(String sql){
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            //执行查询，返回结果集
            ResultSet rs=stmt.executeQuery(sql);
//          二维的Vector
            Vector<Vector<Object>> data=new Vector<Vector<Object>>();
            //获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取结果集里的字段个数
            int count=rsmd.getColumnCount();
            
            while(rs.next()){
                //定义保存一行数据的Vector
                Vector line=new Vector();
                for(int i=1;i<=count;i++){
                    line.add(rs.getObject(i));
                }
                data.add(line);  
            }
            return data;
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
            return null;
        }
    }
    
    //访问数据表，读取数据
    public static Vector<Vector> queryData(String sql){
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            //执行查询，返回结果集
            ResultSet rs=stmt.executeQuery(sql);
//          二维的Vector
            Vector<Vector> data=new Vector<Vector>();
            //获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取结果集里的字段个数
            int count=rsmd.getColumnCount();
            
            while(rs.next()){
                //定义保存一行数据的Vector
                Vector line=new Vector();
                for(int i=1;i<=count;i++){
                    line.add(rs.getObject(i));
                }
                data.add(line);  
            }
            return data;
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
            return null;
        }
    }
    
}
