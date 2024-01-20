package com.mycompany.colorcalculator2609;

import java.awt.*;
import java.awt.event.*;

public class ColorCalculator2609 implements ActionListener {
    private Frame f;
    private Panel p1, p2, p3, p4, p5, p6;
    private Label l1, l2, l3, l4;
    private TextField tf1, tf2, tf3, tf4;
    private Button btnCompute, btnClear;
  
    public ColorCalculator2609() {
        f = new Frame ("Color Calculator 2609!");
        
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        

        
        l1 = new Label("Red: ");
        l2 = new Label("Green: ");
        l3 = new Label("Blue: ");
        l4 = new Label("Alpha: ");
        
        tf1 = new TextField("", 3);
        tf2 = new TextField("", 3);
        tf3 = new TextField("", 3);
        tf4 = new TextField("", 4);
        
        btnCompute = new Button("Compute");
        btnClear = new Button("Clear");
        
        btnCompute.addActionListener((ActionListener) this);
        btnClear.addActionListener((ActionListener) this);
        
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void startApp() {
        p1.add(l1);
        p1.add(tf1);
        
        p2.add(l2);
        p2.add(tf2);
        
        p3.add(l3);
        p3.add(tf3);
        
        p4.add(l4);
        p4.add(tf4);
        
        p5.add(btnCompute);
        p5.add(btnClear);
        
        p6.setSize(100, 100); 
        
        f.setLayout(new GridLayout(6, 1));
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);

        f.pack();
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        ColorCalculator2609 calc2609 = new ColorCalculator2609();
        calc2609.startApp();
    }
    
    public void computeColor() {
        try {
            int red = Integer.parseInt(tf1.getText());
            int green = Integer.parseInt(tf2.getText());
            int blue = Integer.parseInt(tf3.getText());
            int alpha = Integer.parseInt(tf4.getText());

            Color color = new Color(red, green, blue, alpha);
            p6.setBackground(color);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers only.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCompute) {
            computeColor();
        } else if (e.getSource() == btnClear) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            p6.setBackground(new Color(0, 0, 0)); 
        }
    }

}
