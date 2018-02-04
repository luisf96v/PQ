package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public final class Title extends javax.swing.JPanel{

    public Title(String title, String link) throws IllegalArgumentException {
        this.initComponents(this.convert(title),link);
        list = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Init Components"> 
    private void initComponents(String _title, String link) {
        this.setLayout(new GridBagLayout());
        this.setOpaque(true);
        this.setBackground(Color.decode("#2e353d"));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel img = new JLabel(
                        new ImageIcon(
                            new ImageIcon(getClass().getResource(link))
                            .getImage()
                            .getScaledInstance(23, 23, Image.SCALE_DEFAULT)
                        )
                    );
        c.insets = new Insets(0, 5, 0, 20);
        this.add(img,c);
        
        JLabel title = new JLabel(_title, javax.swing.SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial", 1, 17));
        title.setForeground(Color.white);
        c.weightx = 9;
        c.insets = new Insets(0, 5, 0, 20);
        c.gridx = 1;
        c.gridy = 0;
        this.add(title, c);

        c.weightx = 3;
        c.insets = new Insets(0, 0, 0, 10);
        c.gridx = 2;
        c.gridy = 0;
       // this.add(this.arrow, c);

    }
    // </editor-fold>

    private String convert(String str){
         if(str.length() > 12){
            return str.substring(0, 11);
        }
        StringBuilder sb = new StringBuilder(str);
        IntStream.range(0, 12 - str.length()).forEach(i -> sb.append(" "));
        return sb.toString();
    }
    
    public void add(Item i){
        list.add(i);
    }
    
    public Item get(int i){
        return list.get(0);
    }
    
    public void forEach(Consumer<? super Item> action){
        list.forEach(action);
    }
    
    private ArrayList<Item> list;
}
