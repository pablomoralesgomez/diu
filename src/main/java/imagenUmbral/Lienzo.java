package imagenUmbral;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class Lienzo extends JPanel{
    
    private BufferedImage imagenDisplay;
    private BufferedImage imageEmpty;
    private Mat imagen;
    private Mat imagenUmbralizada;
    
    public Lienzo() throws IOException {
        try {
            imageEmpty = ImageIO.read(
                    new URL("https://static.thenounproject.com/png/"
                            + "187803-200.png")); 
        } catch (MalformedURLException ex) {}
        imagenDisplay = imageEmpty;
        imagenUmbralizada = null;
    }
    
    public Dimension getDimension() {
        return new Dimension(imagenDisplay.getWidth(), 
                imagenDisplay.getHeight());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(imagenDisplay, 0, 0, null);
    }
    
    public void cambiaImagen(Mat nuevaImagen) throws IOException {
        imagen = nuevaImagen;
        imagenDisplay = (BufferedImage) HighGui.toBufferedImage(imagen);
        imagenUmbralizada = null;
        repaint();
    }
    
    public void quitaImagen() {
        imagenDisplay = imageEmpty;
        imagenUmbralizada = null;
        repaint();
    }
    
    public Mat getImage() {
        if(imagenUmbralizada == null) {
            return imagen;
        }
        return imagenUmbralizada;
    }
    
    public void umbraliza(Integer umbral) {
        imagenUmbralizada = umbralizar(imagen, umbral);
        imagenDisplay = (BufferedImage) HighGui.toBufferedImage(
                imagenUmbralizada);
        repaint();
    }
    
    public void deshacer() {
        imagenDisplay = (BufferedImage) HighGui.toBufferedImage(imagen);
        repaint();
    }
    
    public void rehacer() {
        imagenDisplay = (BufferedImage) HighGui.toBufferedImage(
                imagenUmbralizada);
        repaint();
    }
    
    private Mat umbralizar(Mat imagen_original, Integer umbral) {
        // crear dos imágenes en niveles de gris con el mismo
        // tamaño que la original
        Mat imagenGris = new Mat(
                imagen_original.rows(),
                imagen_original.cols(),
                CvType.CV_8U);
        
        Mat imagenUmbralizada = new Mat(
                imagen_original.rows(),
                imagen_original.cols(),
                CvType.CV_8U);
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original,imagenGris,Imgproc.COLOR_BGR2GRAY);
        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(
                imagenGris,imagenUmbralizada,umbral,255,Imgproc.THRESH_BINARY);
        // se devuelve la imagen umbralizada
        return imagenUmbralizada;
    }
}
