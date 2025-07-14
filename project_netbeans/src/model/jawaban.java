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
public class jawaban extends pertanyaan{
    public String id_jawaban;
    public String text;
    
    public jawaban(){}

    public jawaban(String id_jawaban, String text) {
        this.id_jawaban = id_jawaban;
        this.text = text;
    }

    public void setId_jawaban(String id_jawaban) {
        try {
            if(id_jawaban.equals(null) || id_jawaban.equals("")){
                JOptionPane.showMessageDialog(null, "Id Jawaban wajib diisi");
                this.id_jawaban="-";
            } else {
                this.id_jawaban=id_jawaban;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setText(String text) {
        try {
            if(text.equals(null) || text.equals("")){
                JOptionPane.showMessageDialog(null, "Text wajib diisi");
                this.text="-";
            } else {
                this.text=text;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public String getId_jawaban() {
        return id_jawaban;
    }

    public String getText() {
        return text;
    }
    
    public String infoJawaban(){   
        String pesan = super.infoPertanyaan()+
                      "\n ID Jawaban : " + getId_jawaban()+
                      "\n Isi : " +  getText();
        return pesan;
    }
    
    public void infoJawabanPopup(){
        String pesan = "ID Jawaban : " + getId_jawaban() + "\n"
                     + "Isi : " + getText();
        JOptionPane.showMessageDialog(null, pesan, "Data Jawaban",JOptionPane.INFORMATION_MESSAGE);
    } 
}
