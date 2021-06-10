/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrator
 * JavaBean
 */
public class Student {
    private String stuId;
    private String stuName;
    private String sex;
    private String birth;
    
    public Student(){
        
    }

    public Student(String stuId, String stuName, String sex, String birth) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.birth = birth;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    
}
