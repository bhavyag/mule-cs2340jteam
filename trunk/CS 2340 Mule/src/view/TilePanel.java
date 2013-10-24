package view;

import javax.swing.*;

public class TilePanel extends JPanel {

	private JLabel[][] labelArray;
    public TilePanel() {
    	labelArray = new JLabel[5][9];
        initialize();
    }

    public void instantiate(ImageIcon i, int x, int y)
    {
    	labelArray[x][y].setIcon(i);
    }
    
    private void initialize() {
        this.setLayout(null);
        this.setBounds(168, 0, 832, 400); 
        
      //COLUMN ZERO
        JLabel label00 = new JLabel();
        label00.setBounds(92, 20, 72, 72);
        add(label00);
        labelArray[0][0]=label00;
        
        JLabel label10 = new JLabel();
        label10.setBounds(92, 92, 72, 72);
        add(label10);
        labelArray[1][0]=label10;
                
        JLabel label20 = new JLabel();
        label20.setBounds(92, 164, 72, 72);
        add(label20);
        labelArray[2][0]=label20;
                
        JLabel label30 = new JLabel();
        label30.setBounds(92, 236, 72, 72);
        add(label30);
        labelArray[3][0]=label30;
                
        JLabel label40 = new JLabel();
        label40.setBounds(92, 308, 72, 72);
        add(label40);
        labelArray[4][0]=label40;
                
      //COLUMN ONE
        JLabel label01 = new JLabel();
        label01.setBounds(164, 20, 72, 72);
        add(label01);
        labelArray[0][1]=label01;
                
        JLabel label11 = new JLabel();
        label11.setBounds(164, 92, 72, 72);
        add(label11);
        labelArray[1][1]=label11;
                
        JLabel label21 = new JLabel();
        label21.setBounds(164, 164, 72, 72);
        add(label21);
        labelArray[2][1]=label21;
                
        JLabel label31 = new JLabel();
        label31.setBounds(164, 236, 72, 72);
        add(label31);
        labelArray[3][1]=label31;
                
        JLabel label41 = new JLabel();
        label41.setBounds(164, 308, 72, 72);
        add(label41);
        labelArray[4][1]=label41;
                
      //COLUMN TWO
        JLabel label02 = new JLabel();
        label02.setBounds(236, 20, 72, 72);
        add(label02);
        labelArray[0][2]=label02;
                
        JLabel label12 = new JLabel();
        label12.setBounds(236, 92, 72, 72);
        add(label12);
        labelArray[1][2]=label12;
                
        JLabel label22 = new JLabel();
        label22.setBounds(236, 164, 72, 72);
        add(label22);
        labelArray[2][2]=label22;
                
        JLabel label32 = new JLabel();
        label32.setBounds(236, 236, 72, 72);
        add(label32);
        labelArray[3][2]=label32;
                
        JLabel label42 = new JLabel();
        label42.setBounds(236, 308, 72, 72);
        add(label42);
        labelArray[4][2]=label42;
                
      //COLUMN THREE
        JLabel label03 = new JLabel();
        label03.setBounds(308, 20, 72, 72);
        add(label03);
        labelArray[0][3]=label03;
                
        JLabel label13 = new JLabel();
        label13.setBounds(308, 92, 72, 72);
        add(label13);
        labelArray[1][3]=label13;
                
        JLabel label23 = new JLabel();
        label23.setBounds(308, 164, 72, 72);
        add(label23);
        labelArray[2][3]=label23;
                
        JLabel label33 = new JLabel();
        label33.setBounds(308, 236, 72, 72);
        add(label33);
        labelArray[3][3]=label33;
                
        JLabel label43 = new JLabel();
        label43.setBounds(308, 308, 72, 72);
        add(label43);
        labelArray[4][3]=label43;
                
      //COLUMN FOUR
        JLabel label04 = new JLabel();
        label04.setBounds(380, 20, 72, 72);
        add(label04);
        labelArray[0][4]=label04;
                
        JLabel label14 = new JLabel();
        label14.setBounds(380, 92, 72, 72);
        add(label14);
        labelArray[1][4]=label14;
                
        JLabel label24 = new JLabel();
        label24.setBounds(380, 164, 72, 72);
        add(label24);
        labelArray[2][4]=label24;
                
        JLabel label34 = new JLabel();
        label34.setBounds(380, 236, 72, 72);
        add(label34);
        labelArray[3][4]=label34;
                
        JLabel label44 = new JLabel();
        label44.setBounds(380, 308, 72, 72);
        add(label44);
        labelArray[4][4]=label44;
                
      //COLUMN FIVE
        JLabel label05 = new JLabel();
        label05.setBounds(452, 20, 72, 72);
        add(label05);
        labelArray[0][5]=label05;
                
        JLabel label15 = new JLabel();
        label15.setBounds(452, 92, 72, 72);
        add(label15);
        labelArray[1][5]=label15;
                
        JLabel label25 = new JLabel();
        label25.setBounds(452, 164, 72, 72);
        add(label25);
        labelArray[2][5]=label25;
                
        JLabel label35 = new JLabel();
        label35.setBounds(452, 236, 72, 72);
        add(label35);
        labelArray[3][5]=label35;
                
        JLabel label45 = new JLabel();
        label45.setBounds(452, 308, 72, 72);
        add(label45);
        labelArray[4][5]=label45;
                
      //COLUMN SIX
        JLabel label06 = new JLabel();
        label06.setBounds(524, 20, 72, 72);
        add(label06);
        labelArray[0][6]=label06;
                
        JLabel label16 = new JLabel();
        label16.setBounds(524, 92, 72, 72);
        add(label16);
        labelArray[1][6]=label16;
                
        JLabel label26 = new JLabel();
        label26.setBounds(524, 164, 72, 72);
        add(label26);
        labelArray[2][6]=label26;
                
        JLabel label36 = new JLabel();
        label36.setBounds(524, 236, 72, 72);
        add(label36);
        labelArray[3][6]=label36;
                
        JLabel label46 = new JLabel();
        label46.setBounds(524, 308, 72, 72);
        add(label46);
        labelArray[4][6]=label46;
                
      //COLUMN SEVEN
        JLabel label07 = new JLabel();
        label07.setBounds(596, 20, 72, 72);
        add(label07);
        labelArray[0][7]=label07;
                
        JLabel label17 = new JLabel();
        label17.setBounds(596, 92, 72, 72);
        add(label17);
        labelArray[1][7]=label17;
                
        JLabel label27 = new JLabel();
        label27.setBounds(596, 164, 72, 72);
        add(label27);
        labelArray[2][7]=label27;
                
        JLabel label37 = new JLabel();
        label37.setBounds(596, 236, 72, 72);
        add(label37);
        labelArray[3][7]=label37;
                
        JLabel label47 = new JLabel();
        label47.setBounds(596, 308, 72, 72);
        add(label47);
        labelArray[4][7]=label47;
                
      //COLUMN EIGHT
        JLabel label08 = new JLabel();
        label08.setBounds(668, 20, 72, 72);
        add(label08);
        labelArray[0][8]=label08;
                
        JLabel label18 = new JLabel();
        label18.setBounds(668, 92, 72, 72);
        add(label18);
        labelArray[1][8]=label18;
                
        JLabel label28 = new JLabel();
        label28.setBounds(668, 164, 72, 72);
        add(label28);
        labelArray[2][8]=label28;
                
        JLabel label38 = new JLabel();
        label38.setBounds(668, 236, 72, 72);
        add(label38);
        labelArray[3][8]=label38;
                
        JLabel label48 = new JLabel();
        label48.setBounds(668, 308, 72, 72);
        add(label48);
        labelArray[4][8]=label48;
                  
    }
    
	public JLabel[][] getLabelArray()
	{
		return this.labelArray;
	}
}
	
	
