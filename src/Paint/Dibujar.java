
package Paint;


//NUEVAS LIBRERIAS
import java.awt.*;
import java.awt.event.KeyEvent;//PARA SABER QUE HACEMOS CON EL TECLADO
import java.awt.event.KeyListener;//PARA SABER QUE TECLA ESTAMOS USANDO
import java.awt.event.MouseEvent;//PARA SABER QUE ESTA HACIENDO EL MOUSE
import java.awt.event.MouseListener;//PARA SABER LOS MOVIMIENTOS DEL MOUSE CUANDO SE DEJA PRECIONADO O SE SUELTA
import java.awt.event.MouseMotionListener;


//PARA PINTAR NECESITAMOS LA EXTENCION CANVAS
public class Dibujar extends Canvas implements KeyListener, MouseListener, MouseMotionListener{
    
    //COORDENADAS PARA DIBUJAR
    int x=-1;
    int y=-1;
    int x2=-1;
    int y2=-1;
    boolean mnw= false;
    
    public Dibujar(){
        
        //AGREGAMOS LOS LISTENER AL CANVAS
        
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        
        setBackground(Color.WHITE); //COLOCAMOS EL COLOR DE FONDO DEL CANVAS
          
    }
    
    public void paint(Graphics g){
        
        
        //AÑADIMOS LAS PROPIEDADES AL PINCEL
        
        Graphics2D g2= (Graphics2D) g; //GRAPHICS 2D CONTIENE MAS METODOS PARA DIBUJAR
        g2.setStroke(new BasicStroke(2.3f)); //EL TAMAÑO DEL PINCEL, SE COLOCA F PORQUE ES UNA VARIABLE TIPO FLOAT
        g2.setColor(Color.black);//COLOCAMOS EL COLOR DEL PINCEL
        
        
        //CONDICION PARA QUE EL DIBUJO NO SE SALGA DE LOS LIMITES
        if(x2 !=-1 && x !=-1){
            
            
            g2.drawLine(x, y, x2, y2);//METODO PARA DIBUJAR A MANO ALZADA
            //g2.fillOval(x, y, 5, 5);
        }
        
        //REINICIA EL CANVAS
        if(mnw==true){
            
            
            g2.setColor(Color.white);
            g2.fillRect(-10, -10, 600, 600);
            mnw=false;
            paint(this.getGraphics());
                    
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='r'){
            mnw=true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        x=e.getX();//MODIFICAMOS LAS POSICIONES DE X
        y=e.getY();//MODIFICAMOS LAS POSICIONES DE Y
        paint(this.getGraphics());//USAMOS EL METODO PAINT PERO NECESITAMOS ENVIARLE UNOS GRAFICOS, ENTONCES LE ESTAMOS MANDANDO LOS GRAFICOS DEL CANVAS
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x=-1; x2=-1;//RESETEAR LA POSICION DEL MOUSE
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        x2=e.getX();
        y2=e.getY();
        paint(this.getGraphics());
        x=x2;
        y=y2;
                
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    
    
}
