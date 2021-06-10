/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_K;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class DBCon1 {
    
    static Connection conn;
    
    //静态块里调用数据库连接方法
    static{
        JDBCon();
    }
    
    public DBCon1(){
        
    }
            
    
    //JDBC方式连接数据库的方法
    public static void JDBCon(){
        try{
            //加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //定义连接字符串
            String url="jdbc:sqlserver://localhost:1433; databaseName=StuDB";
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
    
    //验证账号密码的方法（登录）
    public static boolean checkLogin(String userId,String password){
        try{
            boolean flag=false;
            //创建会话对象
            Statement stmt=conn.createStatement();
            //创建SQL语句
            String sql="select * from users where userId='"+userId+"' and password='"+password+"'";
            //执行查询，返回结果集
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){ //转到第一条记录，返回boolean
                flag=true; //登录成功
            }else{
                flag=false; //登录失败
            }
            return flag;
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
            return false;
        }
    }
    
    //查询学生、课程、成绩信息的方法(二维的Vector)
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
//                String stuId=(String)rs.getObject(1);
//                String stuName=(String)rs.getObject(2);
//                String sex=(String)rs.getObject(3);
//                String birth=(String)rs.getObject(4);
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
    
    //更新数据的方法（包括增、删、改数据）
    public static boolean updateData(String sql){
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            //执行更新，返回受影响的行数
            int count=stmt.executeUpdate(sql);
            if(count>0){
                return true;  
            }else{
                return false;
            }
           
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
            return false;
        }
        
    }
    
     //根据学号查询学生姓名，根据课程编号查询课程名称
    public static String queryName(String tableName,String id){
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            String sql="";
            if(tableName.equals("Student")){
                sql="select * from Student where stuId='"+id+"'";     
            }else{
                sql="select * from Course where courseId='"+id+"'";  
            }
            //执行查询，返回结果集
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                String name=rs.getString(2);
                return name;
            }else{
                return null;
            }
        }catch(SQLException ex){
            System.out.println("数据访问异常");
            ex.printStackTrace();
            return null;
        }
    }
}
