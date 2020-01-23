/**
 * Project Name:employee_system
 * File Name:JDBCUtil.java
 * Package Name:com.sxz.utils
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package com.sxz.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Description: JDBC工具类 <br/>
 * 
 * @author songXZ
 * @version
 * @see
 */
public class JDBCUtil {

    private static String driver = null;

    private static String url = null;

    private static String username = null;

    private static String password = null;

    /**
     * 获取驱动
     */
    static {
        try {
            Properties prop = new Properties();
            InputStream inStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(inStream);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // try {
        // Class.forName("com.mysql.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        // e.printStackTrace();
        // }
    }

    /**
     * 
     * Description: 获取连接<br/>
     *
     * @author songXZ
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    /**
     * 
     * Description: 关闭连接<br/>
     *
     * @author songXZ
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ----------------封装SQL操作----------------------------------------------------------
    // 1.查询返回List集合
    public static <T> List<T> getList(Class<T> cls, String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取处理对象
            ps = conn.prepareStatement(sql);
            // 循环参数
            for (int i = 1; i <= obj.length; i++) {
                ps.setObject(i, obj[i - 1]);
            }
            // 执行SQL语句
            rs = ps.executeQuery();
            // 获取ResultSet对象的列的编号、类型和属性
            ResultSetMetaData date = rs.getMetaData();
            // 获取列数
            int columnNum = date.getColumnCount();
            // 获取所有属性对象
            Field[] fields = cls.getDeclaredFields();
            // 创建集合对象，存储查询数据
            List<T> list = new ArrayList<T>();
            // 遍历结果集
            while (rs.next()) {
                // 创建类类型实例
                T t = cls.newInstance();
                for (int i = 1; i <= columnNum; i++) {
                    // 获取每一列的值
                    Object value = rs.getObject(i);
                    // 获取每一列的列名
                    String columnName = date.getColumnName(i);
                    // 遍历所有属性对象
                    for (Field field : fields) {
                        // 打破封装，忽略对修饰符的检测
                        field.setAccessible(true);
                        // 获取属性名
                        String name = field.getName();
                        // 方式二，
                        if (name.equals(columnName)) {
                            BeanUtils.copyProperty(t, name, value);
                        }
                        // 方式一，较麻烦
                        // if (name.equals(columnName)) {
                        // // 获取列类型
                        // String string = date.getColumnTypeName(i);
                        // // 如果列类型是date转换为字符串表现形式
                        // // 数据库中日期类型对应于Java实体中采用字符串形式存在
                        // SimpleDateFormat sdf = new
                        // SimpleDateFormat("yyyy-MM-dd");
                        // String d = sdf.format(value);
                        // // 赋值，将数据库中查询的字段赋值给对应名称的属性
                        // field.set(t, d);
                        // } else {
                        // field.set(t, value);
                        // }
                    }
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCUtil.close(conn, ps, rs);
        }
        // return list;
        return null;
    }

    // 2.增、删、改
    public static boolean getDML(String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= obj.length; i++) {
                ps.setObject(i, obj[i - 1]);
            }
            int update = ps.executeUpdate();
            if (update > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }

        return false;

    }

    // 3.查询返回单个对象
    public static <T> T getOneObject(Class<T> cls, String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取处理对象
            ps = conn.prepareStatement(sql);
            // 循环参数
            for (int i = 1; i <= obj.length; i++) {
                ps.setObject(i, obj[i - 1]);
            }
            // 执行SQL语句
            rs = ps.executeQuery();
            // 获取ResultSet对象的列的编号、类型和属性
            ResultSetMetaData date = rs.getMetaData();
            // 获取列数
            int columnNum = date.getColumnCount();
            // 获取所有属性对象
            Field[] fields = cls.getDeclaredFields();
            // 遍历结果集
            if (rs.next()) {
                // 创建类类型实例
                T t = cls.newInstance();
                for (int i = 1; i <= columnNum; i++) {
                    // 获取每一列的值
                    Object value = rs.getObject(i);
                    // 获取每一列的列名
                    String columnName = date.getColumnName(i);
                    // 遍历所有属性对象
                    for (Field field : fields) {
                        // 打破封装，忽略对修饰符的检测
                        field.setAccessible(true);
                        // 获取属性名
                        String name = field.getName();
                        // 方式二，
                        if (name.equals(columnName)) {
                            BeanUtils.copyProperty(t, name, value);
                        }
                    }
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCUtil.close(conn, ps, rs);
        }

        return null;

    }

    // 4.查询总记录数
    public static Integer getCount(String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = getConnection();
            // 获取处理对象
            ps = conn.prepareStatement(sql);
            // 循环参数
            for (int i = 1; i <= obj.length; i++) {
                ps.setObject(i, obj[i - 1]);
            }
            // 执行SQL语句
            rs = ps.executeQuery();
            // 遍历结果集
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCUtil.close(conn, ps, rs);
        }

        return null;

    }

}
