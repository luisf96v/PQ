package View;

import Control.PanelFactory;
import Control.ProyectHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.IntStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class Item extends JPanel implements MouseListener {

    public Item(String title, boolean active, int panel) throws IllegalArgumentException {
        this.active = active;
        this.panel = panel;
        this.initComponents(this.convert(title));
        this.addMouseListener(this);
    }

    //<editor-fold defaultstate="collapsed" desc="Init Components"> 
    private void initComponents(String _title) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));

        this.activeLabel = new JLabel(" ");
        this.activeLabel.setOpaque(true);

        this.title = new JLabel(_title, javax.swing.SwingConstants.CENTER);
        this.title.setFont(new java.awt.Font("Arial", 1, 13));

        if (this.active) {
            this.img = new JLabel(
                    new ImageIcon(
                            new ImageIcon(getClass().getResource("../img/delete_gold.png"))
                                    .getImage()
                                    .getScaledInstance(5, 5, Image.SCALE_DEFAULT)
                    )
            );
            this.activeLabel.setBackground(Color.decode("#d19b3d"));
            this.arrow = new JLabel(new ImageIcon(getClass().getResource("../img/arr.png")));
            this.title.setForeground(Color.decode("#d19b3d"));
        } else {
            this.img = new JLabel(
                    new ImageIcon(
                            new ImageIcon(getClass().getResource("../img/delete.png"))
                                    .getImage()
                                    .getScaledInstance(5, 5, Image.SCALE_DEFAULT)
                    )
            );
            this.activeLabel.setBackground(Color.decode("#020203"));
            this.arrow = new JLabel(new ImageIcon(getClass().getResource("../img/arr_grey.png")));
            this.title.setForeground(Color.white);
        }
        this.add(this.activeLabel, BorderLayout.LINE_START);

        this.internal_panel = new JPanel(new GridBagLayout());
        this.internal_panel.setOpaque(true);
        this.internal_panel.setBackground(Color.decode("#181c20"));

        GridBagConstraints c = new GridBagConstraints();
        c.ipady = 2;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 1;
        c.insets = new Insets(0, 3, 0, 5);
        c.gridx = 1;
        c.gridy = 0;
        this.internal_panel.add(this.img, c);

        c.weightx = 9;
        c.insets = new Insets(0, 0, 0, 20);
        c.gridx = 2;
        c.gridy = 0;
        this.internal_panel.add(this.title, c);

        c.weightx = 3;
        c.insets = new Insets(0, 0, 0, 10);
        c.gridx = 3;
        c.gridy = 0;
        this.internal_panel.add(this.arrow, c);

        this.add(this.internal_panel, BorderLayout.CENTER);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Mouse Listener Implementation"> 
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.locked) {
            JOptionPane.showMessageDialog(null, "No posee los permisos para acceder, contacte con el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            PanelFactory.openPanel(panel);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!this.locked) {
            this.internal_panel.setBackground(Color.decode("#020203"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!this.locked) {
            this.internal_panel.setBackground(Color.decode("#181c20"));
        }
    }
    //</editor-fold>

    public void Active() {
        if (!this.active) {
            this.activeLabel.setBackground(Color.decode("#d19b3d"));
            this.title.setForeground(Color.decode("#d19b3d"));
            this.img.setIcon(
                    new ImageIcon(
                            new ImageIcon(getClass().getResource("../img/delete_gold.png"))
                                    .getImage()
                                    .getScaledInstance(5, 5, Image.SCALE_DEFAULT)
                    )
            );
            this.arrow.setIcon(new ImageIcon(getClass().getResource("../img/arr.png")));
            this.active = true;
        }
    }

    public void Desctive() {
        if (this.active) {
            this.activeLabel.setBackground(Color.decode("#020203"));
            this.title.setForeground(Color.WHITE);
            this.img.setIcon(
                    new ImageIcon(
                            new ImageIcon(getClass().getResource("../img/delete.png"))
                                    .getImage()
                                    .getScaledInstance(5, 5, Image.SCALE_DEFAULT)
                    )
            );
            this.arrow.setIcon(new ImageIcon(getClass().getResource("../img/arr_grey.png")));this.title.setForeground(Color.WHITE);
            this.active = false;
        }
    }

    public void setPanel(int panel) {
        this.panel = panel;
    }

    public boolean isActive() {
        return this.active;
    }

    private String convert(String str) {
        if (str.length() > 15) {
            return str.substring(0, 14);
        }
        StringBuilder sb = new StringBuilder(str);
        IntStream.range(0, 15 - str.length()).forEach(i -> sb.append(" "));
        return sb.toString();
    }

    public void lock() {
        this.locked = true;
        this.img.setIcon(new ImageIcon(
                new ImageIcon(getClass().getResource("../img/lock.png"))
                        .getImage()
                        .getScaledInstance(10, 10, Image.SCALE_DEFAULT)
        )
        );
    }

    //<editor-fold defaultstate="collapsed" desc="Elements">   
    private JLabel activeLabel;
    private JLabel arrow;
    private JLabel title;
    private JLabel img;

    private int panel;
    private JPanel internal_panel;

    private boolean active;
    private boolean locked;
    // </editor-fold> 
}
