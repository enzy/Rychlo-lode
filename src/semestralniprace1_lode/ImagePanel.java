
package semestralniprace1_lode;

import java.awt.*;
import javax.swing.*;

/**
 *
 * Trida pro vytvoreni kompomenty, ktera vykresluje zadany obrazek na pozadi opakovane
 */
public class ImagePanel extends JPanel
{
	Image image;

    public ImagePanel(Image image_){
        image = new ImageIcon(image_).getImage();
	}

	@Override
	public void paintComponent(Graphics g)
	{
        for (int i = 0; i < this.getHeight()+1; i+=image.getHeight(null)) {
            for (int j = 0; j < this.getWidth()+1; j+=image.getWidth(null)) {
                g.drawImage(image,j,i,null);
            }
        }
	}
}
