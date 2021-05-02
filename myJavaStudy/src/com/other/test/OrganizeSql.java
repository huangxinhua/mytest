package com.imooc.huawei;

import cn.hutool.core.io.resource.ClassPathResource;
import org.springframework.util.StringUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 整理脚本
 *
 * @author huangxh
 * @since Created on 2021/4/30
 */
public class OrganizeSql {

    public static void main(String[] args){
        Connection conn = null;
        try{
//            String driver="com.mysql.cj.jdbc.Driver";
//            String url="jdbc:mysql://localhost:3306/dbgirl?"
//                    + "useUnicode=true&character&serverTimezone=UTC";
//            String user="root";
//            String pass="123456";
            ClassPathResource classPathResource = new ClassPathResource("pro.txt");
            InputStream in=classPathResource.getStream();
            Properties properties = new Properties();
            properties.load(in);
            String tables=properties.getProperty("table");
            String where=properties.getProperty("where");
            String driver=properties.getProperty("driver");
            String url=properties.getProperty("url");
            String user=properties.getProperty("user");
            String pass=properties.getProperty("pass");
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
            List<String> result=new ArrayList<>();
            String[] arrays=tables.split(",");
            //多个表
            for (String table : arrays) {
                String deleteSql=getDeleteTableSql(conn,table,where);
                result.add(deleteSql);
                List<String> tableInsert= getInsertSql(conn,table,where);
                result.addAll(tableInsert);
            }

            writeData(result);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
//            if (rs != null){
//                rs.close();
//            }
//            if (statement != null){
//                statement.close();
//            }
            if(conn !=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 数据回写到文本
     * @param datas
     */
    private static void writeData(List<String> datas){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        String deskPath = com.getPath();
        System.out.println( deskPath );

        File file = new File( deskPath + "\\" + "dbSql.txt" );
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter( new FileWriter(file) );
            for(int i = 0; i < datas.size(); i++ ) {
                String data=datas.get(i);
                if (data.contains("DELETE FROM")){
                    bw.newLine();
                    bw.newLine();
                    bw.newLine();
                }
                bw.write( data);
                bw.newLine();
            }
            bw.close();
            System.out.println( "done" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回退脚本
     * @param conn
     * @param tableName
     * @param where
     * @return
     * @throws Exception
     */
    private static String getDeleteTableSql(Connection conn, String tableName, String where)throws Exception{
        ResultSet rs = null;
        Statement statement = null;
        String deleteTableSql="";
        List<String> idList=new ArrayList<>();
            String sql="select * from "+tableName+" "+ where+";";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                idList.add(rs.getString("id"));
            }
            String idsStr= idList.stream().collect(Collectors.joining(","));
            deleteTableSql="DELETE FROM "+tableName +" WHERE id in("+idsStr+");";
        return deleteTableSql;
    }

    /**
     * 插入脚本
     * @param conn
     * @param tableName
     * @param where
     * @return
     * @throws Exception
     */
    public static List<String> getInsertSql(Connection conn, String tableName, String where)throws Exception{
        ResultSet rs = null;
        Statement statement = null;
        List<String> list = new ArrayList<>();
            String sqlString="select * from "+tableName+" "+where;
            Statement st = conn.createStatement();
            ResultSet rSet = st.executeQuery(sqlString);
            ResultSetMetaData rData = rSet.getMetaData();
            List<String> columnList;
            List<String> valueList;
            while (rSet.next()) {
                String resultSql=null;
                columnList=new ArrayList<>();
                valueList=new ArrayList<>();
                Map<Object,Object> obj = new HashMap<>();
                for (int i = 1; i <= rData.getColumnCount(); i++) {
                    obj.put(rData.getColumnName(i).toLowerCase(), rSet.getObject(i));
                    columnList.add(rData.getColumnName(i));
                    valueList.add(rSet.getString(i));
                }
                String columnStr=columnList.stream().collect(Collectors.joining(","));
                String valueStr=valueList.stream().map(s -> StringUtils.isEmpty(s)?s: "\'" + s + "\'").collect(Collectors.joining(","));
                resultSql="INSERT INTO "+tableName+" ("+columnStr +") VALUES("+valueStr+");";
                list.add(resultSql);
            }
        return list;
    }

}