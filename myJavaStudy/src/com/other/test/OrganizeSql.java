


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.swing.filechooser.FileSystemView;

/**
 * 配置平台整理脚本
 *
 *
 * @author huangxh
 * @since Created on 2021/5/6
 */
public class OrganizeSql {
    private static final ILogger LOGGER = JalorLoggerFactory.getLogger(OrganizeSql.class);

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Properties properties=getProperties("tbpmOrganize");
            String tables = properties.getProperty("table");
            String where = properties.getProperty("where");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pass = properties.getProperty("pass");
            // String parameters = properties.getProperty("Parameters");
            // String Preparing = properties.getProperty("Preparing");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            List<String> result = new ArrayList<>();
            String[] arrays = tables.split(",");
            // 多个表
            for (String table : arrays) {
                String deleteSql = getDeleteTableSql(conn, table, where);
                result.add(deleteSql);
                List<String> tableInsert = getInsertSql(conn, table, where);
                result.addAll(tableInsert);
            }

            writeData(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Properties getProperties(String resourceName) {
        if (!resourceName.contains(".")) {
            resourceName += ".properties";
        }

        Properties p = new Properties();
        InputStream is = OrganizeSql.class.getClassLoader().getResourceAsStream(resourceName);
        if (is != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                p.load(reader);
            } catch (IOException ex) {
                LOGGER.error( "Unexpected error", ex);
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    LOGGER.error( "Unexpected error", ex);
                }
            }
        }
        return p;
    }

    /**
     * 数据回写到文本
     *
     * @param datas
     */
    private static void writeData(List<String> datas) {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        String deskPath = com.getPath();

        BufferedWriter bw = null;
        try {
            File file =
                    new File(
                            deskPath
                                    + "\\"
                                    + URLEncoder.encode(
                                            DateUtil.format(new Date(), DatePattern.PURE_DATETIME_FORMAT), "UTF-8")
                                    + ".sql");
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            for (int i = 0; i < datas.size(); i++) {
                String data = datas.get(i);
                if (StringUtils.isNotEmpty(data) && data.contains("DELETE FROM")) {
                    bw.newLine();
                    bw.newLine();
                    bw.newLine();
                }
                if (StringUtils.isNotEmpty(data)) {
                    bw.write(data);
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回退脚本
     *
     * @param conn
     * @param tableName
     * @param where
     * @return
     * @throws Exception
     */
    private static String getDeleteTableSql(Connection conn, String tableName, String where) throws Exception {
        ResultSet rs = null;
        List<String> idList = new ArrayList<>();
        String sql = "select * from " + tableName + " " + where + ";";
        try (Statement statement = conn.createStatement()) {
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                idList.add(rs.getString("id"));
            }
            if (CollectionUtils.isEmpty(idList)) {
                return null;
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                LOGGER.error("SQLException>>", e);
            }
        }
        String idsStr = idList.stream().collect(Collectors.joining(","));
        String deleteTableSql = "DELETE FROM " + tableName + " WHERE id in(" + idsStr + ");";
        return deleteTableSql;
    }

    /**
     * 插入脚本
     *
     * @param conn
     * @param tableName
     * @param where
     * @return
     * @throws Exception
     */
    public static List<String> getInsertSql(Connection conn, String tableName, String where) throws Exception {
        ResultSet rSet = null;
        ResultSetMetaData rData = null;
        List<String> list = new ArrayList<>();
        String sqlString = "select * from " + tableName + " " + where;
        try (Statement statement = conn.createStatement()) {
            rSet = statement.executeQuery(sqlString);
            rData = rSet.getMetaData();
            List<String> columnList;
            List<String> valueList;
            while (rSet.next()) {
                String resultSql = null;
                columnList = new ArrayList<>();
                valueList = new ArrayList<>();
                for (int i = 1; i <= rData.getColumnCount(); i++) {
                    columnList.add(rData.getColumnName(i));
                    valueList.add(rSet.getString(i));
                }
                String columnStr = columnList.stream().collect(Collectors.joining(","));
                String valueStr =
                        valueList.stream()
                                .map(s -> s == null ? null : "\'" + s + "\'")
                                .collect(Collectors.joining(","));
                resultSql = "INSERT INTO " + tableName + " (" + columnStr + ") VALUES(" + valueStr + ");";
                list.add(resultSql);
            }
        } finally {
            try {
                if (rSet != null) {
                    rSet.close();
                }
            } catch (SQLException e) {
                LOGGER.error("SQLException>>", e);
            }
        }
        return list;
    }
}
