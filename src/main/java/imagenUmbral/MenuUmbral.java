
package imagenUmbral;

import java.awt.Dimension;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class MenuUmbral extends javax.swing.JFrame {

    private final JFileChooser escogeArchivos; 
    private final FileNameExtensionFilter filtro;
    
    public MenuUmbral() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        escogeArchivos = new JFileChooser();
        filtro = new FileNameExtensionFilter("Imágenes (*.jpg, *.png)",
                "jpg", "png");
        escogeArchivos.addChoosableFileFilter(filtro);
        
        initComponents();
        
        guardar.setEnabled(false);
        cerrar.setEnabled(false);
        umbralizar.setEnabled(false);
        deshacer.setEnabled(false);
        rehacer.setEnabled(false);
        
        Dimension dim = lienzo.getDimension();
        setBounds(0, 0, dim.width+40, dim.height+80);
    }
    
    private boolean onlyValidNumber(String input) {
        Pattern pattern = Pattern.compile("[+]?[0-9]+");
        Matcher matcher  = pattern.matcher(input);
        return matcher.matches();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            lienzo = new imagenUmbral.Lienzo();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        menu = new javax.swing.JMenuBar();
        ficheros = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        cerrar = new javax.swing.JMenuItem();
        separador1 = new javax.swing.JPopupMenu.Separator();
        salir = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenu();
        umbralizar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        deshacer = new javax.swing.JMenuItem();
        rehacer = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        info = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carlos Brito Pérez y Pablo Morales Gómez");
        setResizable(false);

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        ficheros.setMnemonic('f');
        ficheros.setText("Ficheros");

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        ficheros.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        ficheros.add(guardar);

        cerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        ficheros.add(cerrar);
        ficheros.add(separador1);

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        ficheros.add(salir);

        menu.add(ficheros);

        editar.setMnemonic('e');
        editar.setText("Editar");

        umbralizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        umbralizar.setText("Umbralizar");
        umbralizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizarActionPerformed(evt);
            }
        });
        editar.add(umbralizar);
        editar.add(jSeparator1);

        deshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        deshacer.setText("Deshacer");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });
        editar.add(deshacer);

        rehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        rehacer.setText("Rehacer");
        rehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehacerActionPerformed(evt);
            }
        });
        editar.add(rehacer);

        menu.add(editar);

        ayuda.setMnemonic('a');
        ayuda.setText("Ayuda");

        info.setText("Acerca de");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        ayuda.add(info);

        menu.add(ayuda);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        int res = escogeArchivos.showOpenDialog(abrir);
        if(res == JFileChooser.APPROVE_OPTION) {
             
            Mat imagen = Imgcodecs.imread(
                    escogeArchivos.getSelectedFile().getAbsolutePath());
            try {
                lienzo.cambiaImagen(imagen);
            } catch (IOException ex) {}
            
            setBounds(0, 0, imagen.width()+40, imagen.height()+80);
            
            guardar.setEnabled(true);
            cerrar.setEnabled(true);
            umbralizar.setEnabled(true);
            
        } else if(res == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(rootPane, 
                    "Ha ocurrido un error con su solicitud", 
                    "Mensaje de Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
            guardar.setEnabled(false);
            cerrar.setEnabled(false);
            umbralizar.setEnabled(false);
            deshacer.setEnabled(false);
            rehacer.setEnabled(false);
            lienzo.quitaImagen();
            Dimension dim = lienzo.getDimension();
            setBounds(0, 0, dim.width+40, dim.height+80);
    }//GEN-LAST:event_cerrarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, 
                "¿Está seguro de querer salir? Guarde su trabajo previo "
                + "si no desea perderlo.", "Confirmación de salida", 
                JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        int res = escogeArchivos.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION) {
            Imgcodecs.imwrite(
                    escogeArchivos.getSelectedFile().getAbsolutePath(), 
                    lienzo.getImage());
        } else if(res == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(rootPane, 
                    "Ha ocurrido un error con su solicitud", 
                    "Mensaje de Error", JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_guardarActionPerformed

    private void umbralizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralizarActionPerformed
        String input = JOptionPane.showInputDialog("Introduzca el valor de "
                    + "umbralizado. El rango aceptado está entre 0 y 255.");
        
        // Controlamos que se ha introducido un valor válido
        if(input != null) {
            if(onlyValidNumber(input)) {
                
                int inputNumber = Integer.parseInt(input);
                if(inputNumber < 0){
                    inputNumber = 0;
                } else if(inputNumber > 255) {
                    inputNumber = 255;
                }
                
                lienzo.umbraliza((Integer) inputNumber);
                deshacer.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, 
                    "El valor introducido no es válido.", 
                    "Valor no válido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_umbralizarActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        lienzo.deshacer();
        deshacer.setEnabled(false);
        rehacer.setEnabled(true);
    }//GEN-LAST:event_deshacerActionPerformed

    private void rehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehacerActionPerformed
        lienzo.rehacer();
        deshacer.setEnabled(true);
        rehacer.setEnabled(false);
    }//GEN-LAST:event_rehacerActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
         JOptionPane.showMessageDialog(rootPane, 
                   "\nAplicación que umbraliza una imagen previamente cargada. "
                           + "Acciones posibles:\n\nABRIR: carga una imagen de "
                           + "una carpeta\nGUARDAR: guarda una imagen en una "
                           + "carpeta.\nCERRAR: cierra la imagen cargada sin "
                           + "guardarla.\nSALIR: cierra la app\nUMBRALIZAR: "
                           + "aplica un umbral [0, 255] a una imagen cargada."
                           + "\nDESHACER: quita el umbral a la imagen "
                           + "umbralizada.\nREHACER: devuelve el umbralizado "
                           + "a una imagen a la que se le ha quitado.", 
                    "Información de la app", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUmbral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUmbral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUmbral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUmbral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUmbral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenuItem cerrar;
    private javax.swing.JMenuItem deshacer;
    private javax.swing.JMenu editar;
    private javax.swing.JMenu ficheros;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem info;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private imagenUmbral.Lienzo lienzo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem rehacer;
    private javax.swing.JMenuItem salir;
    private javax.swing.JPopupMenu.Separator separador1;
    private javax.swing.JMenuItem umbralizar;
    // End of variables declaration//GEN-END:variables
}