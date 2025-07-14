/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mrifqiihsani;
import frame.FrameApp;
import model.survei;
import model.jawaban;
/**
 *
 * @author User
 */
public class MRIfqiIhsani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FrameApp frame = new FrameApp();
        frame.setVisible(true);
        
        survei objSurvei = new survei();
        objSurvei.setId_user("U001");
        objSurvei.setName("Rifqi");
        objSurvei.setRole("Admin");
        objSurvei.setJudul("Survei Kepuasan");
        objSurvei.setDeskripsi("Survei Kepuasan Layanan");
        objSurvei.setStatus("Aktif");
        System.out.println("Info Survei");
        System.out.println(objSurvei.infoSurvei());
        
        jawaban objJawaban = new jawaban();
        objJawaban.setId_pertanyaan("P001");
        objJawaban.setId_survei("S001");
        objJawaban.setSection("Bagian A");
        objJawaban.setId_jawaban("J001");
        objJawaban.setText("Sangat Puas");
        System.out.println("Info Hasil Survei");
        System.out.println(objJawaban.infoJawaban());
    }
    
}
