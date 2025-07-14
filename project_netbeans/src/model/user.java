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
public class user {
    public String id_user;
    public String name;
    public String username;
    public String password;
    public String role;
    
    public user(){}

    public void setId_user(String id_user) {
        try {
            if(id_user.equals(null) || id_user.equals("")){
                JOptionPane.showMessageDialog(null, "Id User wajib diisi");
                this.id_user="-";
            } else {
                this.id_user=id_user;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setName(String name) {
        try {
            if(name.equals(null) || name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama wajib diisi");
                this.name="-";
            } else {
                this.name=name;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setUsername(String username) {
        try {
            if(username.equals(null) || username.equals("")){
                JOptionPane.showMessageDialog(null, "Username wajib diisi");
                this.username="-";
            } else {
                this.username=username;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setPassword(String password) {
        try {
            if(password.equals(null) || password.equals("")){
                JOptionPane.showMessageDialog(null, "Password wajib diisi");
                this.password="-";
            } else {
                this.password=password;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public void setRole(String role) {
        try {
            if(role.equals(null) || role.equals("")){
                JOptionPane.showMessageDialog(null, "Role wajib diisi");
                this.role="-";
            } else {
                this.role=role;
            }
        } catch (Exception salah) {
            JOptionPane.showMessageDialog(null, salah.getMessage());
        }
    }

    public String getId_user() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    } 
    
    public String infoUser(){   
        String pesan ="\n Id User : " + getId_user()+
                    "\n Name : " + getName()+
                    "\n Role : " + getRole();
        return pesan;
    }
    
    public void infoUserPopup(){
        String pesan = "Id User : " + getId_user() + "\n"
                    + "Name : " + getName() + "\n"
                    + "Username : " + getUsername() + "\n"
                    + "Password : " + getPassword() + "\n"
                    + "Role : " + getRole() + "\n";
        JOptionPane.showMessageDialog(null, pesan, "Data User",JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
