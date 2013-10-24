package view;

import javax.swing.*;

public class TilePanel extends JPanel {

    protected TilePanel() {

        initialize();
    }

    private void initialize() {
        this.setLayout(null);
        this.setBounds(168, 0, 832, 400); 
        
        //COLUMN ZERO
        JLabel label00 = new JLabel("New label");
        label00.setBounds(92, 20, 72, 72);
        add(label00);
        
        JLabel label10 = new JLabel("New label");
        label10.setBounds(92, 92, 72, 72);
        add(label10);
        
        JLabel label20 = new JLabel("New label");
        label20.setBounds(92, 164, 72, 72);
        add(label20);
        
        JLabel label30 = new JLabel("New label");
        label30.setBounds(92, 236, 72, 72);
        add(label30);
        
        JLabel label40 = new JLabel("New label");
        label40.setBounds(92, 308, 72, 72);
        add(label40);
        
        //COLUMN ONE
        JLabel label01 = new JLabel("New label");
        label01.setBounds(164, 20, 72, 72);
        add(label01);
        
        JLabel label11 = new JLabel("New label");
        label11.setBounds(164, 92, 72, 72);
        add(label11);
        
        JLabel label21 = new JLabel("New label");
        label21.setBounds(164, 164, 72, 72);
        add(label21);
        
        JLabel label31 = new JLabel("New label");
        label31.setBounds(164, 236, 72, 72);
        add(label31);
        
        JLabel label41 = new JLabel("New label");
        label41.setBounds(164, 308, 72, 72);
        add(label41);
        
        //COLUMN TWO
        JLabel label02 = new JLabel("New label");
        label02.setBounds(236, 20, 72, 72);
        add(label02);
        
        JLabel label12 = new JLabel("New label");
        label12.setBounds(236, 92, 72, 72);
        add(label12);
        
        JLabel label22 = new JLabel("New label");
        label22.setBounds(236, 164, 72, 72);
        add(label22);
        
        JLabel label32 = new JLabel("New label");
        label32.setBounds(236, 236, 72, 72);
        add(label32);
        
        JLabel label42 = new JLabel("New label");
        label42.setBounds(236, 308, 72, 72);
        add(label42);
        
        //COLUMN THREE
        JLabel label03 = new JLabel("New label");
        label03.setBounds(236, 20, 72, 72);
        add(label03);
        
        JLabel label13 = new JLabel("New label");
        label13.setBounds(236, 92, 72, 72);
        add(label13);
        
        JLabel label23 = new JLabel("New label");
        label23.setBounds(236, 164, 72, 72);
        add(label23);
        
        JLabel label33 = new JLabel("New label");
        label33.setBounds(236, 236, 72, 72);
        add(label33);
        
        JLabel label43 = new JLabel("New label");
        label43.setBounds(236, 308, 72, 72);
        add(label43);
          
    }
}
