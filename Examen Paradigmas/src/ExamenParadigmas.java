
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ExamenParadigmas {

    public void prueba() {       
        Document document = new Document();
        Scanner s = new Scanner(System.in);
        
        String Nombre, Nombre2,  Direccion, Claveelector, CURP;
        
        System.out.println("Introduce tu nombre: ");
        Nombre = s.nextLine();
        System.out.println("Introduce tu nombre: ");
        Nombre2 = s.nextLine();
        System.out.println("Introduce tu direccion: ");
        Direccion = s.nextLine();
        System.out.println("Introduce tu clave de elector: ");
        Claveelector = s.nextLine();
        System.out.println("Introduce tu CURP: ");
        CURP = s.nextLine();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("INE.pdf"));

            document.open();
            
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            ImageIcon img1 = new ImageIcon(getClass().getResource("imagenes/ine.jpg"));
            g.drawImage(img1.getImage(), 51, 250, 480, 300, null);
            
            ImageIcon img2 = new ImageIcon(getClass().getResource("imagenes/Joe.jpg"));
            g.drawImage(img2.getImage(), 97, 350, 100, 155, null);
            
            Font font1 = new Font("Tahoma", Font.PLAIN, 72);
            g.setFont(font1);
            g.setColor(Color.BLACK);
            g.drawString("INE", 240, 80);
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 10);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString(Nombre, 210, 350);
            
            Font font3 = new Font("Tahoma", Font.PLAIN, 10);
            g.setFont(font3);
            g.setColor(Color.BLACK);
            g.drawString(Nombre2, 210, 360);
            
            Font font4 = new Font("Tahoma", Font.PLAIN, 10);
            g.setFont(font4);
            g.setColor(Color.BLACK);
            g.drawString(Direccion, 210, 410);
            
            Font font5 = new Font("Tahoma", Font.PLAIN, 10);
            g.setFont(font5);
            g.setColor(Color.BLACK);
            g.drawString(Claveelector, 299, 460);
            
            Font font6 = new Font("Tahoma", Font.PLAIN, 10);
            g.setFont(font6);
            g.setColor(Color.BLACK);
            g.drawString(CURP, 240, 480);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        document.close();

        JOptionPane.showMessageDialog(null, "Se creo el archivo 'INE' en la carpeta del proyecto");
    }

    public static void main(String[] args) 
    {
        ExamenParadigmas obj = new ExamenParadigmas();
        obj.prueba();
    }
}
