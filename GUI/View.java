/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import CodeFiles.Compress;
import CodeFiles.Decompress;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitish
 */
public class View extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 200, 200, 30);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 200, 200, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(500, 300);
        this.getContentPane().setBackground(Color.darkGray);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.compressFunction(file);
                } catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressFunction(file);
                } catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
            }    }
        }
    }
    
    public static void main(String[] args){
        View view = new View();
        view.setVisible(true); //1.33
    }
}
