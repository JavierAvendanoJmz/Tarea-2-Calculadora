/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author j4v13
 */
public class MainForm extends JFrame {
    
    Controlador controlador;
    JButton btnAnalizar;
    
    public MainForm() {
        super("Super Calculadora");
        super.setSize(720, 115);
        super.setResizable(false);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlador = new Controlador();
        super.add(pnlSuperior(), BorderLayout.NORTH);
        super.add(pnlBotones(), BorderLayout.CENTER);
        super.add(pnlInferior(), BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private JPanel pnlInferior() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("La salida constara de 5 lineas que son los resultados de las operaciones: suma, resta, multiplicacion, division, y residuo"));
        return panel;
    }
    
    private JPanel pnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        btnAnalizar = new JButton("Analizar Archivo");
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    JFileChooser fc = new JFileChooser();
                    int returnVal = fc.showOpenDialog(MainForm.this);
                    Lista l = new Lista();
                    Lista l2 = new Lista();
                    if (returnVal == JFileChooser.APPROVE_OPTION) {           
                        controlador.abrir(fc.getSelectedFile(), l, l2);
//                        System.out.println(l);
//                        System.out.println(l2);
                    }
                    try {
                        Lista suma = controlador.sumar(l.clonar(),l2.clonar());
//                        System.out.println("1: "+suma);
                        Lista resta = controlador.restar(l.clonar(), l2.clonar());
//                        System.out.println("2: "+resta);
                        Lista multiplicacion = controlador.multiplicar(l.clonar(), l2.clonar());
//                        System.out.println("3: "+multiplicacion);
                        Resul division = controlador.dividir(l.clonar(), l2.clonar());
//                        System.out.println("4.1: "+division.getCociente());
//                        System.out.println("4.2: "+division.getResiduo());
                        try {
                            JOptionPane.showMessageDialog(MainForm.this, "Guarde el archivo");
                            returnVal = fc.showSaveDialog(MainForm.this);
                            if (returnVal == JFileChooser.APPROVE_OPTION) {
                                File f = fc.getSelectedFile();
                                controlador.guardar(f,suma,resta,multiplicacion,
                                        division.getCociente(),division.getResiduo());
                                JOptionPane.showMessageDialog(MainForm.this, "Listo!\nRevise ruta del archivo");
                            }    
                        } catch(Exception exce) {
                            
                        }
                    } catch (Exception exc) {
                    }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(MainForm.this, "Entrada invalida!");
                }
            }
        });
        panel.add(btnAnalizar);        
        return panel;
    }
    
    private JPanel pnlSuperior() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Formato de entrada .txt: 2 numeros positivos separados por un salto de linea, considerando el mayor antes que el menor"));
        return panel;
    }
}
