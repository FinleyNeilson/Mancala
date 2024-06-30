import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    Boolean player1Turn;


    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9 ; i++) {
           buttons[i] = new JButton();
           buttonPanel.add(buttons[i]);
           buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
           buttons[i].setFocusable(false);
           buttons[i].addActionListener(this);
        }

        titlePanel.add(textfield);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.validate();
        frame.repaint();

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player1Turn){
                    if(buttons[i].getText().isEmpty()){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                }else {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0) {
            player1Turn = true;
            textfield.setText("X turn");
        } else {
            player1Turn = false;
            textfield.setText("O turn");
        }

    }

    public void check(){
        for (int i = 0; i < 3; i++) {
           checkRow(i);
           checkCol(i);
        }
    }

    public void checkCol(int i){
        String type = buttons[i].getText();
        boolean win = true;
        for (int j = 1; j < 9; j += 2) {
            if(!(buttons[i+j].getText().equals(type))) {
                win = false;
            }
        }
        if(win){
            if(type.equals("X")){xWins();}
            else{oWins();}
        }
    }

    public void checkRow(int i){
        String type = buttons[i].getText();
        boolean win = true;
        for (int j = 1; j < 3; j++) {
            if(!(buttons[i+j].getText().equals(type))) {
               win = false;
            }
        }
        if(win){
            if(type.equals("X")){xWins();}
            else{oWins();}
        }
    }

   public void xWins(){

   }

    public void oWins(){

    }
}