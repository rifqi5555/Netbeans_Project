package crud;
import com.mysql.jdbc.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class crud {
    // --- Variabel Koneksi dan Status ---
    private Connection Koneksidb;
    private String username="root";
    private String password="";
    private String dbname="db_pertambangan";
    private String urlKoneksi="jdbc:mysql://localhost/"+dbname;
    
    // Properti Duplikasi
    public String CEK_NAMA, CEK_STATUS, CEK_TELP=null;
    public boolean duplikasi=false;
    
    // --- Konstruktor (Koneksi Database) ---
    public crud(){
        try {
            Driver dbdriver = new com.mysql.jdbc.Driver(); 
            DriverManager.registerDriver(dbdriver);
            Koneksidb=(Connection) DriverManager.getConnection(urlKoneksi,username,password);
            System.out.print("Database Terkoneksi");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    // =================================================================
    //                    A. OPERASI CRUD DAN TAMPIL DATA KARYAWAN
    // =================================================================

    // [METODE simpanKaryawan(), ubahKaryawan(), hapusKaryawan() SAMA DENGAN SEBELUMNYA]
    // ... (kode untuk simpanKaryawan, ubahKaryawan, hapusKaryawan) ...
    
    public void simpanKaryawan(String id, String nama, String jabatan, String alamat, String telp, String password){
        try {
            String sqlsimpan = "INSERT INTO Karyawan (ID_Karyawan, Nama_Karyawan, Jabatan, Alamat_Karyawan, No_Telp_Karyawan, Password) "
                             + "VALUE (?, ?, ?, ?, ?, ?)";
            String sqlcari = "SELECT * FROM Karyawan WHERE ID_Karyawan = ?";
            
            PreparedStatement cari = Koneksidb.prepareStatement(sqlcari);
            cari.setString(1, id);
            ResultSet data = cari.executeQuery();
            
            if (data.next()){
                JOptionPane.showMessageDialog(null, "ID Karyawan sudah terdaftar!");
                this.duplikasi=true;
                this.CEK_NAMA = data.getString("Nama_Karyawan");
                this.CEK_STATUS = data.getString("Jabatan");
                this.CEK_TELP = data.getString("No_Telp_Karyawan");
            } else {
                this.duplikasi=false;
                this.CEK_NAMA=null; this.CEK_STATUS=null; this.CEK_TELP=null; 
                PreparedStatement perintah = Koneksidb.prepareStatement(sqlsimpan);
                perintah.setString(1, id);
                perintah.setString(2, nama);
                perintah.setString(3, jabatan);
                perintah.setString(4, alamat);
                perintah.setString(5, telp);
                perintah.setString(6, password);
                perintah.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Karyawan berhasil disimpan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void ubahKaryawan(String id, String nama, String jabatan, String alamat, String telp, String password){
        try {
            String sqlubah = "UPDATE Karyawan SET Nama_Karyawan=?, Jabatan=?, Alamat_Karyawan=?, No_Telp_Karyawan=?, Password=? WHERE ID_Karyawan=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlubah);
            perintah.setString(1, nama);
            perintah.setString(2, jabatan);
            perintah.setString(3, alamat);
            perintah.setString(4, telp);
            perintah.setString(5, password);
            perintah.setString(6, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Karyawan berhasil diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapusKaryawan(String id){
        try {
            String sqlhapus = "DELETE FROM Karyawan WHERE ID_Karyawan=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlhapus);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Karyawan berhasil dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Menampilkan data Karyawan dari database ke dalam JTable.
     */
    public void tampilDataKaryawan(JTable komponentabel, String SQL){
        try {
            PreparedStatement perintah = Koneksidb.prepareStatement(SQL);
            ResultSet data = perintah.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            int jumlahkolom = meta.getColumnCount();
            DefaultTableModel modeltabel = new DefaultTableModel();
            
            // Kolom Tabel (disesuaikan dengan skema Karyawan)
            modeltabel.addColumn("ID Karyawan");
            modeltabel.addColumn("Nama");
            modeltabel.addColumn("Jabatan");
            modeltabel.addColumn("Alamat");
            modeltabel.addColumn("No Telp");
            modeltabel.addColumn("Password"); 
            
            while(data.next()){
                Object[] row = new Object[jumlahkolom];
                for(int i=1; i<=jumlahkolom; i++){
                    row[i-1]=data.getObject(i);
                }
                modeltabel.addRow(row);
            }
            komponentabel.setModel(modeltabel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Tampil Data Karyawan: " + e.getMessage());
        }
    }
    
    // =================================================================
    //                    B. OPERASI CRUD DAN TAMPIL DATA KONSUMEN
    // =================================================================

    // [METODE simpanKonsumen(), ubahKonsumen(), hapusKonsumen() SAMA DENGAN SEBELUMNYA]
    // ... (kode untuk simpanKonsumen, ubahKonsumen, hapusKonsumen) ...
    
    public void simpanKonsumen(String id, String namaPerusahaan, String alamat, String telp){
        try {
            String sqlsimpan = "INSERT INTO Konsumen (ID_Konsumen, Nama_Perusahaan, Alamat_Perusahaan, No_Telp_Perusahaan) "
                             + "VALUE (?, ?, ?, ?)";
            String sqlcari = "SELECT * FROM Konsumen WHERE ID_Konsumen = ?";
            
            PreparedStatement cari = Koneksidb.prepareStatement(sqlcari);
            cari.setString(1, id);
            ResultSet data = cari.executeQuery();
            
            if (data.next()){
                JOptionPane.showMessageDialog(null, "ID Konsumen sudah terdaftar!");
                this.duplikasi=true;
                this.CEK_NAMA = data.getString("Nama_Perusahaan");
                this.CEK_STATUS = data.getString("Alamat_Perusahaan"); 
                this.CEK_TELP = data.getString("No_Telp_Perusahaan");
            } else {
                this.duplikasi=false;
                this.CEK_NAMA=null; this.CEK_STATUS=null; this.CEK_TELP=null; 
                PreparedStatement perintah = Koneksidb.prepareStatement(sqlsimpan);
                perintah.setString(1, id);
                perintah.setString(2, namaPerusahaan);
                perintah.setString(3, alamat);
                perintah.setString(4, telp);
                perintah.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Konsumen berhasil disimpan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void ubahKonsumen(String id, String namaPerusahaan, String alamat, String telp){
        try {
            String sqlubah = "UPDATE Konsumen SET Nama_Perusahaan=?, Alamat_Perusahaan=?, No_Telp_Perusahaan=? WHERE ID_Konsumen=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlubah);
            perintah.setString(1, namaPerusahaan);
            perintah.setString(2, alamat);
            perintah.setString(3, telp);
            perintah.setString(4, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Konsumen berhasil diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapusKonsumen(String id){
        try {
            String sqlhapus = "DELETE FROM Konsumen WHERE ID_Konsumen=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlhapus);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Konsumen berhasil dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Menampilkan data Konsumen dari database ke dalam JTable.
     */
    public void tampilDataKonsumen(JTable komponentabel, String SQL){
        try {
            PreparedStatement perintah = Koneksidb.prepareStatement(SQL);
            ResultSet data = perintah.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            int jumlahkolom = meta.getColumnCount();
            DefaultTableModel modeltabel = new DefaultTableModel();
            
            // Kolom Tabel (disesuaikan dengan skema Konsumen)
            modeltabel.addColumn("ID Konsumen");
            modeltabel.addColumn("Nama Perusahaan");
            modeltabel.addColumn("Alamat Perusahaan");
            modeltabel.addColumn("No Telp Perusahaan");
            
            while(data.next()){
                Object[] row = new Object[jumlahkolom];
                for(int i=1; i<=jumlahkolom; i++){
                    row[i-1]=data.getObject(i);
                }
                modeltabel.addRow(row);
            }
            komponentabel.setModel(modeltabel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Tampil Data Konsumen: " + e.getMessage());
        }
    }

    // =================================================================
    //                    C. OPERASI CRUD DAN TAMPIL DATA PEMESANAN
    // =================================================================
    
    // [METODE simpanPemesanan(), ubahPemesanan(), hapusPemesanan() SAMA DENGAN SEBELUMNYA]
    // ... (kode untuk simpanPemesanan, ubahPemesanan, hapusPemesanan) ...
    
    public void simpanPemesanan(String id, String tglPemesanan, String idKonsumen, String idKaryawan, String notes){
        try {
            String sqlsimpan = "INSERT INTO Pemesanan (ID_Pemesanan, Tanggal_Pemesanan, ID_Konsumen, ID_Karyawan, Notes) "
                             + "VALUE (?, ?, ?, ?, ?)";
            String sqlcari = "SELECT * FROM Pemesanan WHERE ID_Pemesanan = ?";
            
            PreparedStatement cari = Koneksidb.prepareStatement(sqlcari);
            cari.setString(1, id);
            ResultSet data = cari.executeQuery();
            
            if (data.next()){
                JOptionPane.showMessageDialog(null, "ID Pemesanan sudah terdaftar!");
                this.duplikasi=true;
                this.CEK_NAMA = data.getString("ID_Konsumen");
                this.CEK_STATUS = data.getString("Tanggal_Pemesanan"); 
                this.CEK_TELP = data.getString("ID_Karyawan");
            } else {
                this.duplikasi=false;
                this.CEK_NAMA=null; this.CEK_STATUS=null; this.CEK_TELP=null; 
                PreparedStatement perintah = Koneksidb.prepareStatement(sqlsimpan);
                perintah.setString(1, id);
                perintah.setString(2, tglPemesanan);
                perintah.setString(3, idKonsumen);
                perintah.setString(4, idKaryawan);
                perintah.setString(5, notes);
                perintah.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Pemesanan berhasil disimpan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void ubahPemesanan(String id, String tglPemesanan, String idKonsumen, String idKaryawan, String notes){
        try {
            String sqlubah = "UPDATE Pemesanan SET Tanggal_Pemesanan=?, ID_Konsumen=?, ID_Karyawan=?, Notes=? WHERE ID_Pemesanan=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlubah);
            perintah.setString(1, tglPemesanan);
            perintah.setString(2, idKonsumen);
            perintah.setString(3, idKaryawan);
            perintah.setString(4, notes);
            perintah.setString(5, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemesanan berhasil diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapusPemesanan(String id){
        try {
            String sqlhapus = "DELETE FROM Pemesanan WHERE ID_Pemesanan=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlhapus);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemesanan berhasil dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Menampilkan data Pemesanan dari database ke dalam JTable.
     */
    public void tampilDataPemesanan(JTable komponentabel, String SQL){
        try {
            PreparedStatement perintah = Koneksidb.prepareStatement(SQL);
            ResultSet data = perintah.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            int jumlahkolom = meta.getColumnCount();
            DefaultTableModel modeltabel = new DefaultTableModel();
            
            // Kolom Tabel (disesuaikan dengan skema Pemesanan)
            modeltabel.addColumn("ID Pemesanan");
            modeltabel.addColumn("Tanggal");
            modeltabel.addColumn("ID Konsumen");
            modeltabel.addColumn("ID Karyawan");
            modeltabel.addColumn("Notes");
            
            while(data.next()){
                Object[] row = new Object[jumlahkolom];
                for(int i=1; i<=jumlahkolom; i++){
                    row[i-1]=data.getObject(i);
                }
                modeltabel.addRow(row);
            }
            komponentabel.setModel(modeltabel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Tampil Data Pemesanan: " + e.getMessage());
        }
    }

    // =================================================================
    //                    D. OPERASI CRUD DAN TAMPIL DATA PRODUKSI
    // =================================================================
    
    // [METODE simpanProduksi(), ubahProduksi(), hapusProduksi() SAMA DENGAN SEBELUMNYA]
    // ... (kode untuk simpanProduksi, ubahProduksi, hapusProduksi) ...
    
    public void simpanProduksi(String id, String idPemesanan, String tglProduksi, String idWilayah, String idProduk, String jumlah){
        try {
            String sqlsimpan = "INSERT INTO Produksi (ID_Produksi, ID_Pemesanan, Tanggal_Produksi, ID_Wilayah, ID_Produk, Jumlah_Produksi) "
                             + "VALUE (?, ?, ?, ?, ?, ?)";
            String sqlcari = "SELECT * FROM Produksi WHERE ID_Produksi = ?";
            
            PreparedStatement cari = Koneksidb.prepareStatement(sqlcari);
            cari.setString(1, id);
            ResultSet data = cari.executeQuery();
            
            if (data.next()){
                JOptionPane.showMessageDialog(null, "ID Produksi sudah terdaftar!");
                this.duplikasi=true;
                this.CEK_NAMA = data.getString("ID_Pemesanan");
                this.CEK_STATUS = data.getString("Tanggal_Produksi"); 
                this.CEK_TELP = data.getString("ID_Produk");
            } else {
                this.duplikasi=false;
                this.CEK_NAMA=null; this.CEK_STATUS=null; this.CEK_TELP=null; 
                PreparedStatement perintah = Koneksidb.prepareStatement(sqlsimpan);
                perintah.setString(1, id);
                perintah.setString(2, idPemesanan);
                perintah.setString(3, tglProduksi);
                perintah.setString(4, idWilayah);
                perintah.setString(5, idProduk);
                perintah.setString(6, jumlah);
                perintah.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Produksi berhasil disimpan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void ubahProduksi(String id, String idPemesanan, String tglProduksi, String idWilayah, String idProduk, String jumlah){
        try {
            String sqlubah = "UPDATE Produksi SET ID_Pemesanan=?, Tanggal_Produksi=?, ID_Wilayah=?, ID_Produk=?, Jumlah_Produksi=? WHERE ID_Produksi=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlubah);
            perintah.setString(1, idPemesanan);
            perintah.setString(2, tglProduksi);
            perintah.setString(3, idWilayah);
            perintah.setString(4, idProduk);
            perintah.setString(5, jumlah);
            perintah.setString(6, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Produksi berhasil diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapusProduksi(String id){
        try {
            String sqlhapus = "DELETE FROM Produksi WHERE ID_Produksi=?";        
            PreparedStatement perintah = Koneksidb.prepareStatement(sqlhapus);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Produksi berhasil dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Menampilkan data Produksi dari database ke dalam JTable.
     */
    public void tampilDataProduksi(JTable komponentabel, String SQL){
        try {
            PreparedStatement perintah = Koneksidb.prepareStatement(SQL);
            ResultSet data = perintah.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            int jumlahkolom = meta.getColumnCount();
            DefaultTableModel modeltabel = new DefaultTableModel();
            
            // Kolom Tabel (disesuaikan dengan skema Produksi)
            modeltabel.addColumn("ID Produksi");
            modeltabel.addColumn("ID Pemesanan");
            modeltabel.addColumn("Tanggal Produksi");
            modeltabel.addColumn("ID Wilayah");
            modeltabel.addColumn("ID Produk");
            modeltabel.addColumn("Jumlah");
            
            while(data.next()){
                Object[] row = new Object[jumlahkolom];
                for(int i=1; i<=jumlahkolom; i++){
                    row[i-1]=data.getObject(i);
                }
                modeltabel.addRow(row);
            }
            komponentabel.setModel(modeltabel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Tampil Data Produksi: " + e.getMessage());
        }
    }
}