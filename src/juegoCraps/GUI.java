package juegoCraps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for show use MouseListener, MouseMotionListener and KeyListener
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:22/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelMouse;
    private JTextArea mensajes;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("MouseListener, MouseMotionListener and KeyListener");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("Manejando Escuchas del Mouse y del Teclado", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addMouseMotionListener(escucha);
        panelMouse.addKeyListener(escucha);
        panelMouse.setFocusable(true);
        panelMouse.setBackground(Color.BLUE);
        panelMouse.setPreferredSize(new Dimension(600,120));

        mensajes = new JTextArea(7,3);
        mensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(mensajes);

        add(panelMouse,BorderLayout.CENTER);
        add(scroll,BorderLayout.SOUTH);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements MouseListener, MouseMotionListener, KeyListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            panelMouse.setBackground(Color.CYAN);
            mensajes.append("mouseClicked was detected \n");
        }

        @Override
        public void mousePressed(MouseEvent e) {
           panelMouse.setBackground(Color.pink);
           mensajes.append("mousePressed was detected \n");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panelMouse.setBackground(Color.BLACK);
            mensajes.append("mouseReleased was detected \n");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panelMouse.setBackground(Color.GRAY);
            mensajes.append("mouseEntered was detected \n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panelMouse.setBackground(Color.YELLOW);
            mensajes.append("mouseExited was detected \n");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mensajes.append("mouseDragged was detected \n"+
                    "Mouse position x = "+e.getX()+" Mouse position y = "+e.getY()+"\n");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
             mensajes.append("mouseMoved was detected \n"+
                             "Mouse position x = "+e.getX()+" Mouse position y = "+e.getY()+"\n");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            mensajes.append("keyTyped was detected \n"+
                            "Tecla alfa numérica = "+e.getKeyChar()+"\n");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            mensajes.append("keyTyped was detected \n"+
                            "Tecla = "+e.getKeyChar()+"\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            mensajes.append("keyReleased was detected \n"+
                            "Tecla = "+e.getKeyChar()+"\n");
        }
    }
}
