package net.f3322.wry333.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类 使用Druid连接池
 *
 */
public class JDBCUtils {

    public static DataSource ds;

    static {
        try {
            //新建一个配置文件对象
            Properties pro = new Properties();
            //用ClassLoader加载配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {

            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取DataSource
     * @return ds DataSource
     */
    public static  DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取Connection对象
     * @return con Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
