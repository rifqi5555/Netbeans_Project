/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class survei extends user{
    public String id_survei;
    public String judul;
    public String deskripsi;
    public String status;
    public String waktu_mulai;
    public String waktu_selesai;
    public String waktu_tenggat;
    
    public survei(){}

    public void setId_survei(String id_survei) {
        try {
            if(id_survei.equals(null) || id_survei.equals("")){
                JOptionPane.showMessageDialog(null, "Id Survei wajib diisi");
                this.id_survei="-";
            } else {
                this.id_survei=id_survei;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setJudul(String judul) {
        try {
            if(judul.equals(null) || judul.equals("")){
                JOptionPane.showMessageDialog(null, "Judul wajib diisi");
                this.judul="-";
            } else {
                this.judul=judul;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setDeskripsi(String deskripsi) {
        try {
            if(deskripsi.equals(null) || deskripsi.equals("")){
                JOptionPane.showMessageDialog(null, "Deskripsi wajib diisi");
                this.deskripsi="-";
            } else {
                this.deskripsi=deskripsi;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setStatus(String status) {
        try {
            if(status.equals(null) || status.equals("")){
                JOptionPane.showMessageDialog(null, "Status wajib diisi");
                this.status="-";
            } else {
                this.status=status;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setWaktu_mulai(String waktu_mulai) {
        try {
            if (waktu_mulai == null || waktu_mulai.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Waktu Mulai wajib diisi");
                this.waktu_mulai = "-";
            } else {
                // Coba parsing tanggal dengan format tertentu (misalnya: dd-MM-yyyy)
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(false); // supaya format harus valid
                Date tgl = format.parse(waktu_mulai); // akan melempar Exception jika salah format

                this.waktu_mulai = waktu_mulai; // jika valid, simpan
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, "Format tanggal tidak valid (contoh: 06-06-2024)\n" + salah.getMessage());
            this.waktu_mulai = "-";
        }
    }

    public void setWaktu_selesai(String waktu_selesai) {
        try {
            if (waktu_selesai == null || waktu_selesai.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Waktu Selesai wajib diisi");
                this.waktu_selesai = "-";
            } else {
                // Coba parsing tanggal dengan format tertentu (misalnya: dd-MM-yyyy)
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(false); // supaya format harus valid
                Date tgl = format.parse(waktu_selesai); // akan melempar Exception jika salah format

                this.waktu_selesai = waktu_selesai; // jika valid, simpan
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, "Format tanggal tidak valid (contoh: 06-06-2024)\n" + salah.getMessage());
            this.waktu_selesai = "-";
        }
    }

    public void setWaktu_tenggat(String waktu_tenggat) {
        try {
            if (waktu_tenggat == null || waktu_tenggat.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Waktu Tenggat wajib diisi");
                this.waktu_tenggat = "-";
            } else {
                // Coba parsing tanggal dengan format tertentu (misalnya: dd-MM-yyyy)
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(false); // supaya format harus valid
                Date tgl = format.parse(waktu_tenggat); // akan melempar Exception jika salah format

                this.waktu_tenggat = waktu_tenggat; // jika valid, simpan
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, "Format tanggal tidak valid (contoh: 06-06-2024)\n" + salah.getMessage());
            this.waktu_tenggat = "-";
        }
    }

    public String getId_survei() {
        return id_survei;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public String getWaktu_selesai() {
        return waktu_selesai;
    }

    public String getWaktu_tenggat() {
        return waktu_tenggat;
    }
    
    public String infoSurvei(){   
        String pesan = super.infoUser()+
                    "\n Judul : " + getJudul()+ "("+getDeskripsi()+")" +
                    "\n Status : " + getStatus();
        return pesan;
    }
    
    public void infoSurveiPopup(){
        String pesan = "Id Survei : " + getId_survei() + "\n"
                    + "Judul : " + getJudul() + "\n"
                    + "Deskripsi : " + getDeskripsi() + "\n"
                    + "Status : " + getStatus() + "\n"
                    + "Waktu Mulai : " + getWaktu_mulai() + "\n"
                    + "Waktu Selesai : " + getWaktu_selesai() + "\n"
                    + "Waktu Tenggat : " + getWaktu_tenggat();
        JOptionPane.showMessageDialog(null, pesan, "Data Survei",JOptionPane.INFORMATION_MESSAGE);
    
    }
}
