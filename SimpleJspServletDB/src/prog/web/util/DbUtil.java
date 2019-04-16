package prog.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
    
    public static java.sql.Date dateUtilToDateSql(Date data) {
        return new java.sql.Date(data.getTime());
    }
    
    public static String geraHash(String descricao) throws NoSuchAlgorithmException {
       String hash = "";
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(descricao.getBytes(),0,descricao.length());
       hash = new BigInteger(1,m.digest()).toString(16);
       System.out.println("MD5: "+hash);
       return hash;
    }
    
    public static Date stringToDate(String date) throws ParseException {
        return stringToDate(date, "yyyy-MM-dd");
    }
    
    public static Date stringToDate(String date, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return new java.sql.Date(simpleDateFormat.parse(date).getTime());
    }
}
