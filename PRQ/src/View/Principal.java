package View;

import Control.PanelFactory;
import View.Panels.Rgs.RgsIn;
import View.Panels.Rgs.RgsList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    //<editor-fold defaultstate="collapsed" desc="INIT COMPONENTS">       
    private void initComponents() {
        // Header
        setTitle("Administrador de Parqueos");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon.png")));

        //Frame configs
        setSize(
                java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
                java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 50
        );

        setMaximizedBounds(
                new java.awt.Rectangle(
                        0,
                        0,
                        java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
                        java.awt.Toolkit.getDefaultToolkit().getScreenSize().height
                )
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Panels config
        initPanels();
        setLayout(new BorderLayout());
        add(start, BorderLayout.LINE_START);
        add(content, BorderLayout.CENTER);
       // add(bottom, BorderLayout.PAGE_END);
    }

    private void initPanels() {
        // top panel config
        top = new JPanel();
        top.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 9;
        title = new JLabel("Lista de Vehículos", javax.swing.SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial", 1, 26));
        title.setBackground(Color.red);
        c.weightx = 9;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 15, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        top.add(title, c);

        // START PANEL CONFIGURATION
        start = new JPanel();

        start.setLayout(new GridLayout(20, 1));
        start.setBackground(Color.decode("#2e353d"));

        // VEHICLES
        lista = new ArrayList<>();

        Title title1 = new Title("Vehículos", "../img/car.png");

        lista.add(new Item("Lista", true, PanelFactory.LIST));
        title1.add(lista.get(0));

        lista.add(new Item("Ingreso", false, PanelFactory.IN));
        title1.add(lista.get(1));

        start.add(title1);
        title1.forEach(i -> start.add(i));
        // ENDS VEHICLES 

        // STADISTICS
        //Title title2 = new Title("Estadísticas", "../img/chart.png");
        //title2.add(new Item("Total", false, 0));
       // title2.add(new Item("Datos", false, 0));

        //start.add(title2);
        //title2.forEach(i -> start.add(i));
        // ENDS STADISTICS 

        // USERS
       // Title title3 = new Title("Usuarios", "../img/user2.png");
       // title3.add(new Item("Nuevo", false, 0));
       // title3.add(new Item("Lista", false, 0));

        //start.add(title3);
        //title3.forEach(i -> start.add(i));
        // ENDS USERS

        //SYSTEM
        Title title4 = new Title("Sistema", "../img/shield.png");

        lista.add(new Item("Configuración", false, PanelFactory.CONFIG));
        title4.add(lista.get(2));
        lista.add(new Item("Cierre Caja", false, 0));
        title4.add(lista.get(3));
        //title4.add(new Item("Respaldos", false, 0));

        start.add(title4);
        title4.forEach(i -> start.add(i));
        //ENDS SYSTEM

        //title2.forEach(i -> i.lock());
        //title3.forEach(i -> i.lock());
        //title4.forEach(i -> i.lock());
        content = new JPanel(new BorderLayout());
        content.add(top, BorderLayout.PAGE_START);
        content.add(PanelFactory.createPanel(PanelFactory.LIST), BorderLayout.CENTER);
        selected = 0;
        title1.get(0).Active();
        /*
        bottom = new JPanel();
        bottom.setBackground(Color.LIGHT_GRAY);
        bottom.add(new JLabel("Hecho por Luis Fernando Vásquez (luisf96v@gmail.com).  Se reservan los derechos de autor."));
        JButton manual = new JButton("Manual de Usuario");
        manual.addActionListener((ActionEvent e) -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File("src\\manual.pdf"));
                } catch (IOException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "El manual fue eliminado, por favor comunicar con el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esta computadora no soporta componentes de java, por favor comunicar con el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bottom.add(manual);
         */

    }
    // </editor-fold> 

    public void panelList() {
        content.remove(1);
        content.add(new RgsList(), BorderLayout.CENTER);

        if (selected >= 0) {
            lista.get(selected).Desctive();
        }

        lista.get(0).Active();
        selected = 0;

        title.setText("Lista de Vehículos");
    }

    public void panelIn(int i) {
        content.remove(1);
        content.add(new RgsIn(i), BorderLayout.CENTER);

        if (selected >= 0) {
            lista.get(selected).Desctive();
        }

        lista.get(1).Active();
        selected = 1;

        title.setText("Ingreso de Vehículo");
        revalidate();
    }

    public void panelConifg() {
        content.remove(1);
        content.add(PanelFactory.createPanel(PanelFactory.CONFIG), BorderLayout.CENTER);

        if (selected >= 0) {
            lista.get(selected).Desctive();
        }

        lista.get(2).Active();
        selected = 2;

        title.setText("Configuración del Sistema");
    }

    public void setPanel(JPanel p, String tittle) {
        content.remove(1);
        content.add(p, BorderLayout.CENTER);

        if (selected >= 0) {
            lista.get(selected).Desctive();
        }

        selected = -1;

        title.setText(tittle);
    }

    //<editor-fold defaultstate="collapsed" desc="Elements">   
    private JPanel top;
    private JPanel start;
    private JPanel content;
    private JPanel bottom;
    private JLabel title;
    private ArrayList<Item> lista;
    private int selected;
    // </editor-fold> 

}
