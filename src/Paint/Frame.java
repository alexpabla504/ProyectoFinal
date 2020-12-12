
package Paint;

import javax.swing.JFrame;

//ESTA ES LA VENTANA PRINCIPAL

public class Frame extends JFrame{
    
    public Frame(){
        
        Dibujar d1= new Dibujar();
        add(d1);
        
       this.setSize(600, 600);
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       this.setTitle("DIBUJO A MANO ALZADA");
       this.setLocationRelativeTo(null);
        
        
    }
    
    public static void main(String[] args) {
        Frame f= new Frame();
        
       
        f.setVisible(true);
        
    }
    
    
}
