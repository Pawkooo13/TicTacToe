package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restart extends JFrame implements ActionListener {
    JButton button_1;
    JButton button_2;
    JLabel title;
    public Restart() {
        button_1 = new JButton("TAK");
        button_2 = new JButton("NIE");
        title = new JLabel("Chcesz zagrać ponownie?");

        this.setTitle("Restart");
        this.setBounds(80, 150, 300, 110);

        button_1.setBounds(30, 30, 100, 30);
        button_1.addActionListener(this);

        button_2.setBounds(160, 30, 100, 30);
        button_2.addActionListener(this);

        title.setFont(new Font("BOLD", Font.BOLD, 16));
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(40, 10, 220, 30);
        title.setHorizontalAlignment(JLabel.CENTER);

        this.add(button_1);
        this.add(button_2);
        this.add(title);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button_1){
            GUI.frame.setVisible(false);
            new GUI();
        }else{
            System.exit(0);
        }
        this.setVisible(false);
    }
}

