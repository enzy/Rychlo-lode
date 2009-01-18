/*
 * @(#)DemoSurface.java	1.38 99/08/16
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


import java.awt.*;
import java.awt.image.*;
import java.awt.print.*;
import javax.swing.JPanel;
import javax.swing.RepaintManager;


/**
 * All demos extend this DemoSurface Abstract class.  From
 * this class demos must implement the drawDemo method.  This
 * class handles animated demos, the demo must implement the
 * AnimatingContext interface.
 */
public abstract class DemoSurface extends JPanel implements Runnable, Printable {


    public Object AntiAlias = RenderingHints.VALUE_ANTIALIAS_ON;
    public Object Rendering = RenderingHints.VALUE_RENDER_SPEED;
    public AlphaComposite composite;
    public Paint texture;
    public String perfStr;            // PerformanceMonitor
    public BufferedImage bimg;
    public int imageType;
    public Thread thread;
    public String name;         
    public boolean clearSurface = true;
    // Demos using animated gif's that implement ImageObserver set dontThread.
    public boolean dontThread;       

    private long orig, start, frame;
    private Toolkit toolkit;
    private boolean perfMonitor, outputPerf;
    private int biw, bih;
    private AnimatingContext animating;
    private long sleepAmount = 50;
    private boolean clearOnce;


    public DemoSurface() {
        setDoubleBuffered(this instanceof AnimatingContext);
        toolkit = getToolkit();
        name = this.getClass().getName();
        name = name.substring(name.indexOf(".", 7)+1);
        setImageType(0);

        // To launch an individual demo with the performance str output  :
        //    java -Djava2demo.perf= -cp Java2Demo.jar demos.Clipping.ClipAnim
        try {
            if (System.getProperty("java2demo.perf") != null) {
                perfMonitor = outputPerf = true;
            }
        } catch (Exception ex) { }

        if (this instanceof AnimatingContext) {
            animating = (AnimatingContext) this;
        }
    }


    protected Image getImage(String name) {
        return DemoImages.getImage(name, this);
    }


    public int getImageType() {
        return imageType;
    }


    public void setImageType(int imgType) {
        if (imgType == 0) {
            if (this instanceof AnimatingContext) {
                imageType = 2;
            } else {
                imageType = 1;
            }
        } else {
            imageType = imgType;
        }
        bimg = null;
    }


    public void setAntiAlias(boolean aa) {
        AntiAlias = aa 
            ? RenderingHints.VALUE_ANTIALIAS_ON
            : RenderingHints.VALUE_ANTIALIAS_OFF;
    }


    public void setRendering(boolean rd) {
        Rendering = rd
            ? RenderingHints.VALUE_RENDER_QUALITY
            : RenderingHints.VALUE_RENDER_SPEED;
    }


    public void setTexture(Object obj) {
        if (obj instanceof GradientPaint) {
            texture = new GradientPaint(0, 0, Color.white,
                                        getSize().width*2, 0, Color.green);
        } else {
            texture = (Paint) obj;
        }
    }


    public void setComposite(boolean cp) {
        composite = cp 
            ? AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f) 
            : null;
    }


    public void setMonitor(boolean pm) {
        perfMonitor = pm;
    }


    public void setSleepAmount(long amount) {
        sleepAmount = amount;
    }


    public long getSleepAmount() {
        return sleepAmount;
    }


    public BufferedImage createBufferedImage(int w, int h, int imgType) {
        BufferedImage bi = null;
        if (imgType == 0) {
            bi = (BufferedImage) createImage(w, h);  
        } else if (imgType > 0 && imgType < 14) {
            bi = new BufferedImage(w, h, imgType);
        } else if (imgType == 14) {
            bi = createBinaryImage(w, h, 2);
        } else if (imgType == 15) {
            bi = createBinaryImage(w, h, 4);
        }
        biw = w;
        bih = h;
        return bi;
    }


    // Lookup tables for BYTE_BINARY 1, 2 and 4 bits.
    static byte[] lut1Arr = new byte[] {0, (byte)255 };
    static byte[] lut2Arr = new byte[] {0, (byte)85, (byte)170, (byte)255};
    static byte[] lut4Arr = new byte[] {0, (byte)17, (byte)34, (byte)51,
                                  (byte)68, (byte)85,(byte) 102, (byte)119,
                                  (byte)136, (byte)153, (byte)170, (byte)187,
                                  (byte)204, (byte)221, (byte)238, (byte)255};


    private BufferedImage createBinaryImage(int w, int h, int pixelBits) {

       int[] pixels = new int[w*h];
       int bytesPerRow = w * pixelBits / 8;
       if (w * pixelBits % 8 != 0) {
           bytesPerRow++;
       }
       byte[] imageData = new byte[h * bytesPerRow];
       IndexColorModel cm = null;
       switch (pixelBits) {
       case 1:
           cm = new IndexColorModel(pixelBits, lut1Arr.length,
                                    lut1Arr, lut1Arr, lut1Arr);
           break;
       case 2:
           cm = new IndexColorModel(pixelBits, lut2Arr.length,
                                    lut2Arr, lut2Arr, lut2Arr);
           break;
       case 4:
           cm = new IndexColorModel(pixelBits, lut4Arr.length,
                                    lut4Arr, lut4Arr, lut4Arr);
           break;
       default:
           {new Exception("Invalid # of bit per pixel").printStackTrace();}
       }
       
       DataBuffer db = new DataBufferByte(imageData, imageData.length);
       WritableRaster r = Raster.createPackedRaster(db, w, h, pixelBits, null);
       return new BufferedImage(cm, r, false, null);
    }


    public Graphics2D createGraphics2D(int width, 
                                       int height, 
                                       BufferedImage bi, 
                                       Graphics g) {

        Graphics2D g2 = null;

        if (bi != null) {
            g2 = bi.createGraphics();
        } else {
            g2 = (Graphics2D) g;
        }

        g2.setBackground(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, AntiAlias);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, Rendering);

        if (clearSurface || clearOnce) {
            g2.clearRect(0, 0, width, height);
            clearOnce = false;
        }

        if (texture != null) {
            // set composite to opaque for texture fills
            g2.setComposite(AlphaComposite.SrcOver);
            g2.setPaint(texture);
            g2.fillRect(0, 0, width, height);
        }

        if (composite != null) {
            g2.setComposite(composite);
        }

        return g2;
    }

    // ...demos that extend DemoSurface must implement this routine...
    public abstract void drawDemo(int w, int h, Graphics2D g2);


    /**
     * It's possible to turn off double-buffering for just the repaint 
     * calls invoked directly on the non double buffered component.  
     * This can be done by overriding paintImmediately() (which is called 
     * as a result of repaint) and getting the current RepaintManager and 
     * turning off double buffering in the RepaintManager before calling 
     * super.paintImmediately(g).
     */
    public void paintImmediately(int x,int y,int w, int h) {
        RepaintManager repaintManager = null;
        boolean save = true;
        if (!isDoubleBuffered()) {
             repaintManager = RepaintManager.currentManager(this);
             save = repaintManager.isDoubleBufferingEnabled();
             repaintManager.setDoubleBufferingEnabled(false);
        }
        super.paintImmediately(x, y, w, h);

        if (repaintManager != null) {
            repaintManager.setDoubleBufferingEnabled(save);
        }
    }


    public void paint(Graphics g) {

        Dimension d = getSize();

        if (imageType == 1) {
            bimg = null;
            startClock();
        } else if (bimg == null || biw != d.width || bih != d.height) {
            if (animating != null && (biw != d.width || bih != d.height)) {
                animating.reset(d.width, d.height);
            }
            bimg = createBufferedImage(d.width, d.height, imageType-2);
            clearOnce = true;
            startClock();
        }

        if (thread != null) {
            animating.step(d.width, d.height);
        }
        Graphics2D g2 = createGraphics2D(d.width, d.height, bimg, g);
        drawDemo(d.width, d.height, g2);
        g2.dispose();

        if (bimg != null)  {
            g.drawImage(bimg, 0, 0, null);
            toolkit.sync();
        }

        if (perfMonitor) {
            LogPerformance();
        }
    }


    public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        if (pi >= 1) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.translate(pf.getImageableWidth() / 2,
                      pf.getImageableHeight() / 2);
        
        Dimension d = getSize();

        double scale = Math.min(pf.getImageableWidth() / d.width,
                                pf.getImageableHeight() / d.height);
        if (scale < 1.0) {
            g2d.scale(scale, scale);
        }

        g2d.translate(-d.width / 2.0, -d.height / 2.0);

        if (bimg == null) {
            Graphics2D g2 = createGraphics2D(d.width, d.height, null, g2d);
            drawDemo(d.width, d.height, g2);
            g2.dispose();
        } else {
            g2d.drawImage(bimg, 0, 0, this);
        }

        return Printable.PAGE_EXISTS;
    }


    public void start() {
        if (thread != null || !(this instanceof AnimatingContext) || dontThread) {
            return;
        }
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setName(name + " Demo");
        thread.start();
    }


    public synchronized void stop() {
        if (thread != null) {
            thread.interrupt();
        }
        thread = null;
        notifyAll();
    }


    public void run() {

        Thread me = Thread.currentThread();

        while (thread == me && !isShowing() || getSize().width == 0) {
            try {
                thread.sleep(200);
            } catch (InterruptedException e) { }
        }

        while (thread == me) {
            repaint();
            try {
                thread.sleep(sleepAmount);
            } catch (InterruptedException e) { }
        }
        thread = null;
    }


    private void startClock() {
        orig = System.currentTimeMillis();
        start = orig;
    }

    private static final int REPORTFRAMES = 30;

    private void LogPerformance() {
        if ((frame % REPORTFRAMES) == 0) {
            long end = System.currentTimeMillis();
            long rel = (end - start);
            long tot = (end - orig);
            if (frame == 0) {
                perfStr = name + " " + rel+" ms";
                if (animating == null) {
                    frame = -1;     
                }
            } else {
                String s1 = Float.toString((REPORTFRAMES/(rel/1000.0f)));
                s1 = (s1.length() < 4) ? s1.substring(0,s1.length()) : s1.substring(0,4);
                perfStr = name + " " + s1 + " fps";
            }
            if (outputPerf) {
                System.out.println(perfStr);
            }
            start = end;
        }
        ++frame;
    }



    // System.out graphics state information.
    public void verbose() {
        String str = "  " + name + " ";
        if (thread != null) {
            str = str.concat(" Running");
        } else if (this instanceof AnimatingContext) {
            str = str.concat(" Stopped");
        }

        str = str.concat(" " + Controls.screenCombo.getSelectedItem());

        str = AntiAlias == RenderingHints.VALUE_ANTIALIAS_ON
            ? str.concat(" ANTIALIAS_ON ") 
            : str.concat(" ANTIALIAS_OFF ");

        str = Rendering == RenderingHints.VALUE_RENDER_QUALITY
            ? str.concat("RENDER_QUALITY ") 
            : str.concat("RENDER_SPEED ");

        if (texture != null) {
            str = str.concat("Texture ");
        }

        if (composite != null) {
            str = str.concat("Composite=" + composite.getAlpha() + " ");
        }

        Runtime r = Runtime.getRuntime();
        r.gc();
        float freeMemory = (float) r.freeMemory();
        float totalMemory = (float) r.totalMemory();
        str = str.concat(((totalMemory - freeMemory)/1024) + "K used");
        System.out.println(str);
    }
}
