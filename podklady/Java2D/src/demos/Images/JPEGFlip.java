/*
 * @(#)JPEGFlip.java	1.17 99/04/23
 *
 * Copyright (c) 1998, 1999 by Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 * 
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

package demos.Images;

import java.awt.*;
import java.awt.event.*;
import com.sun.image.codec.jpeg.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.geom.GeneralPath;
import java.io.*;
import DemoSurface;
import DemoPanel;


/**
 * Render a filled star & duke into a BufferedImage, save the BufferedImage
 * as a JPEG, display the BufferedImage, using the decoded JPEG BufferedImage
 * DataBuffer flip the elements, display the JPEG flipped BufferedImage.
 */
public class JPEGFlip extends DemoSurface {

    private static Image img;

    public JPEGFlip() {
        setBackground(Color.white);
        img = getImage("duke.gif");
    }


    public void drawDemo(int w, int h, Graphics2D g2) {

        int hh = h/2;

        BufferedImage bi = (BufferedImage) createImage(w, hh);
        Graphics2D big = bi.createGraphics();

        // .. use rendering hints from J2DCanvas ..
        big.setRenderingHints(g2.getRenderingHints());

        big.setBackground(getBackground());
        big.clearRect(0, 0, w, hh);

        big.setColor(Color.green.darker());
        GeneralPath p = new GeneralPath(GeneralPath.WIND_NON_ZERO);
        p.moveTo(- w / 2.0f, - hh / 8.0f);
        p.lineTo(+ w / 2.0f, - hh / 8.0f);
        p.lineTo(- w / 4.0f, + hh / 2.0f);
        p.lineTo(+     0.0f, - hh / 2.0f);
        p.lineTo(+ w / 4.0f, + hh / 2.0f);
        p.closePath();
        big.translate(w/2, hh/2);
        big.fill(p);

        int iw = img.getWidth(this);
        int ih = img.getHeight(this);
        if (hh < ih * 1.5)
            ih = (int) (ih * ((hh / (ih*1.5))));
        big.drawImage(img, -img.getWidth(this)/2, -ih/2, iw, ih, this);

        g2.drawImage(bi, 0, 0, this);
        g2.setFont(new Font("Dialog", Font.PLAIN, 10));
        g2.setColor(Color.black);
        g2.drawString("BufferedImage", 4, 12);


        BufferedImage bi1 = null;

        try {
            // To write the jpeg to a file uncomment the File* lines and
            // comment out the ByteArray*Stream lines.
            //File file = new File("images", "test.jpg");
            //FileOutputStream out = new FileOutputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
            param.setQuality(1.0f, false);
            encoder.setJPEGEncodeParam(param);
            encoder.encode(bi);

            //FileInputStream in = new FileInputStream(file);
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
            bi1 = decoder.decodeAsBufferedImage();
        } catch (Exception ex) {
            g2.setColor(Color.red);
            g2.drawString("write permissions on images/test.jpg?", 5, hh*2-5);
        }

        if (bi1 == null) {
            g2.setColor(Color.red);
            g2.drawString("decodeAsBufferedImage=null", 5, hh*2-5);
            return;
        }

        BufferedImage bi2 = new BufferedImage(bi1.getWidth(),bi1.getHeight(),bi1.getType());
        DataBuffer db1 = bi1.getRaster().getDataBuffer();
        DataBuffer db2 = bi2.getRaster().getDataBuffer();

        for (int i = db1.getSize()-1, j = 0; i >= 0; --i, j++) {
            db2.setElem(j, db1.getElem(i));
        }

        g2.drawImage(bi2, 0, hh, this);

        g2.drawString("JPEGImage Flipped", 4, hh*2-4);
        g2.drawLine(0, hh, w, hh);
    }


    public static void main(String s[]) {
        Frame f = new Frame("Java2D Demo - JPEGFlip");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        f.add("Center", new DemoPanel(new JPEGFlip()));
        f.pack();
        f.setSize(new Dimension(400,300));
        f.show();
    }
}
