import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by doetken on 26.10.2016.
 */
public class DBVerbindung {

    private Properties properties = new Properties();
    private static String url = "";
    private static String user = "";
    private static String pass = "";
    private static Connection con;

    public DBVerbindung() throws SQLException {
        konfigEinlesen();
        con = DriverManager.getConnection(url, user, pass);

    }

    private static void konfigEinlesen() {
        Properties prop = new Properties();
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("src/konfig.properties"));
            prop.load(bfr);
            bfr.close();
            url = prop.getProperty("db_url");
            user = prop.getProperty("db_user");
            pass = prop.getProperty("db_pass");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void schließen() throws SQLException {
        con.close();
    }
}
