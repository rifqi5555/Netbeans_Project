/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class pertanyaan {
    public String id_pertanyaan;
    public String id_survei;
    public String section;
    
    public pertanyaan(){}

    public pertanyaan(String id_pertanyaan, String id_survei, String section) {
        this.id_pertanyaan = id_pertanyaan;
        this.id_survei = id_survei;
        this.section = section;
    }

    public void setId_pertanyaan(String id_pertanyaan) {
        try {
            if(id_pertanyaan.equals(null) || id_pertanyaan.equals("")){
                JOptionPane.showMessageDialog(null, "Id Pertanyaan wajib diisi");
                this.id_pertanyaan="-";
            } else {
                this.id_pertanyaan=id_pertanyaan;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

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

    public void setSection(String section) {
        try {
            if(section.equals(null) || section.equals("")){
                JOptionPane.showMessageDialog(null, "Section wajib diisi");
                this.section="-";
            } else {
                this.section=section;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public String getId_pertanyaan() {
        return id_pertanyaan;
    }

    public String getId_survei() {
        return id_survei;
    }

    public String getSection() {
        return section;
    }
    
    public String infoPertanyaan(){   
        String pesan ="\n ID Pertanyaan : " + getId_pertanyaan()+
                    "\n Untuk Survei : " + getId_survei()+
                    "\n Section : " + getSection();
        return pesan;
    }
    
    public void infoPertanyaanPopup(){
        String pesan = "ID Pertanyaan : " + getId_pertanyaan() + "\n"
                    + "ID Survei : " + getId_survei() + "\n"
                    + "Section : " + getSection();
        JOptionPane.showMessageDialog(null, pesan, "Data Pertanyaan",JOptionPane.INFORMATION_MESSAGE);
    } 
    
}
