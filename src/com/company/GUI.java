package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    static JFrame frame;
    JPanel panel;
    JButton[] buttons = new JButton[9];
    JLabel title;
    Font font = new Font("BOLD", Font.BOLD, 50);
    String [] board = new String [9];
    final String sign_o = "O";
    final String sign_x = "X";
    String sign = sign_o;
    public GUI(){
        frame = new JFrame();
        frame.setSize(350,460);
        frame.setTitle("Kółko i krzyżyk");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(20,100,295,300);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(3,3,10,10));

        title = new JLabel();
        title.setBounds(30,10,275,70);
        title.setText("Turn: " + sign);
        title.setFont(font);
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);

        for(int i=0;i<9;i++){
            buttons[i]=new JButton("");
            panel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            board[i]="";
        }

        frame.add(title);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource().equals(buttons[i]) && buttons[i].getText().equals("")){
                if(sign.equals(sign_o)){
                    buttons[i].setText("O");
                }
                else{
                    buttons[i].setText("X");
                }
                buttons[i].setFont(font);
                board[i]=sign;
                sign=set_sign();
                print_turn();
                draw();
                check_board();
            }
        }
    }
    private String set_sign(){
        if(sign.equals(sign_o)){
            sign=sign_x;
        }
        else{
            sign=sign_o;
        }
        return sign;
    }

    private  void print_turn(){
        title.setText("Turn: " + sign);
    }

    private void check_board() {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6]) && !board[i].equals("")) {
                sign = board[i];
                buttons[i].setBackground(Color.GREEN);
                buttons[i+3].setBackground(Color.GREEN);
                buttons[i+6].setBackground(Color.GREEN);
                winner();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i*3].equals(board[i*3+1]) && board[i*3+1].equals(board[i*3+2]) && !board[i*3].equals("")) {
                sign = board[i*3];
                buttons[i*3].setBackground(Color.GREEN);
                buttons[i*3+1].setBackground(Color.GREEN);
                buttons[i*3+2].setBackground(Color.GREEN);
                winner();
            }
        }
        for (int i = 0; i < 2; i++) {
            if (board[4].equals(board[i*2]) && board[i*2].equals(board[8-2*i]) && !board[4].equals("")) {
                sign = board[4];
                buttons[4].setBackground(Color.GREEN);
                buttons[i*2].setBackground(Color.GREEN);
                buttons[8-2*i].setBackground(Color.GREEN);
                winner();
            }
        }
    }

    private void winner(){
        for(int i=0;i<board.length;i++){
            if(buttons[i].isEnabled()){
                buttons[i].setEnabled(false);
            }
        }
        title.setText("Winner: " + sign + "!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.GREEN);
        new Restart();
    }

    private void draw(){
        int licznik=0;
        for(int i=0;i<board.length;i++){
            if(buttons[i].getText().equals("X") || buttons[i].getText().equals("O")){
                licznik+=1;
            }
        }
        if(licznik==9){
            title.setText("Draw!");
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setForeground(Color.RED);
            new Restart();
        }
    }
}
