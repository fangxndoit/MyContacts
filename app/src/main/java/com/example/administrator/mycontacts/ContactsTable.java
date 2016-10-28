package com.example.administrator.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ContactsTable {
    //数据表明常量
    private final  static String TABLENAME="contactsTable";
    //声明数据库对象
    private MyDB db;
    public ContactsTable(Context context){
        //创建MyDB对象，contex很重要
        db=new MyDB(context);
        //如果数据表不存在就新建数据表
        if(!db.isTableExits(TABLENAME)){
            String createTableSql="CREATE TABLE IF NOT EXISTS "+TABLENAME+"(id_DB integer "+
                    "primary key AUTOINCREMENT,"+
                    User.NAME+" VARCHAR,"+
                    User.MOBILE+" VARCHAR,"+
                    User.QQ+" VARCHAR,"+
                    User.DANWEI+" VARCHAR,"+
                    User.ADDRESS+" VARCHAR)";
            db.createTable(createTableSql);
        }
    }
    //增加数据
    public boolean addDate(User user){
        //创建ContentValues对象用于保存数据
        ContentValues values= new ContentValues();
        values.put(User.NAME,User.getNAME());
        values.put(User.MOBILE,User.getMOBILE());
        values.put(User.DANWEI,User.getDANWEI());
        values.put(User.QQ,User.getQQ());
        values.put(User.ADDRESS,User.getADDRESS());
        //保存数据
        return  db.save(TABLENAME,values);
    }
}
