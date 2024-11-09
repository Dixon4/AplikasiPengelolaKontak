import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:kontak.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:kontak.db";  // url untuk mengakses database
            conn = DriverManager.getConnection(url);
            System.out.println("Koneksi ke database berhasil!");  // Logging untuk koneksi
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal.");
            e.printStackTrace();
        }
            return conn;
    }
    
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS kontak ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nama TEXT NOT NULL, "
                   + "nomor_telepon TEXT NOT NULL, "
                   + "kategori TEXT NOT NULL);";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
