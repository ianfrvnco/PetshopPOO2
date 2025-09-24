
package utils;

import java.awt.Image;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Util {
    
    public static Date converterStringToDate(String text) {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date data = null;

        try {
            data = formato.parse(text);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
        }

        return data;
    }
    
    public static String converterDateToString(Date data) {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String texto = "";

    try {
      //Irá formatar a data para o formato dd/MM/yyyy
      texto = formato.format(data);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,
              "Erro ao formatar a data");
    }

    return texto;
  }
    
    public static Image getIcone(){
    URL caminhoImagem = Util.class.getResource("/images/imgPetMenu24px.png");

    ImageIcon icon = new ImageIcon(caminhoImagem);
    
    return icon.getImage();
  }
}
