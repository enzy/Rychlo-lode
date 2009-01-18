/*
 * @(#)DemoGroup.java	1.26 99/04/23
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
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Vector;


/**
 * DemoGroup handles multiple demos inside of a panel.  Demos are loaded
 * from the demos[][] string as listed in Java2Demo.java.
 * Demo groups can be loaded individually, for example : 
 *      java DemoGroup Fonts
 * Loads all the demos found in the demos/Fonts directory.
 */
public class DemoGroup extends JPanel implements MouseListener, ChangeListener, ActionListener {

    static int columns = 2;

    private static Font font = new Font("serif", Font.PLAIN, 10);
    private static EmptyBorder emptyB = new EmptyBorder(5,5,5,5);
    private static BevelBorder bevelB = new BevelBorder(BevelBorder.LOWERED);
    private String groupName;
    public JPanel clonePanels[];
    public JTabbedPane tabbedPane;


    public DemoGroup(String name) {

        groupName = name;

        setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(0,2));
        p.setBorder(new CompoundBorder(emptyB, bevelB));

        Vector vector = new Vector(40);

        int index = 0;
        for (; index < Java2Demo.demos.length; index++) {
            if (name.compareTo(Java2Demo.demos[index][0]) == 0) {
               break;
            }
        }
        String[] demos = Java2Demo.demos[index];
        for (int j = 1; j < demos.length; j++) {
            vector.add("demos." + name + "." + demos[j]);
        }
        if (vector.size()%2 == 1) {
            p.setLayout(new GridBagLayout());
        } 
        for (int i = 0; i < vector.size(); i++) {
            DemoPanel dp = new DemoPanel((String) vector.elementAt(i));
            dp.setDemoBorder(p);
            if (dp.surface != null) {
                dp.surface.addMouseListener(this);
                dp.surface.setMonitor(Java2Demo.performancemonitor != null);
            } 
            if (p.getLayout() instanceof GridBagLayout) {
                int x = p.getComponentCount() % 2;
                int y = p.getComponentCount() / 2;
                int w = i == vector.size()-1 ? 2 : 1;
                Java2Demo.addToGridBag(p,dp,x,y,w,1,1,1);
            } else {
                p.add(dp);
            }
        }

        add(p);
    }


    public void mouseClicked(MouseEvent e) {

        if (tabbedPane == null) {
            shutDown(getPanel());
            JPanel p = new JPanel(new BorderLayout());
            p.setBorder(new CompoundBorder(emptyB, bevelB));

            tabbedPane = new JTabbedPane();
            tabbedPane.setFont(font);

            JPanel tmpP = (JPanel) getComponent(0);
            tabbedPane.addTab(groupName, tmpP);

            clonePanels = new JPanel[tmpP.getComponentCount()];
            for (int i = 0; i < clonePanels.length; i++) {
                clonePanels[i] = new JPanel(new BorderLayout());
                DemoPanel dp = (DemoPanel) tmpP.getComponent(i);
                DemoPanel c = new DemoPanel(dp.className);
                c.setDemoBorder(clonePanels[i]);
                if (c.surface != null) {
                    c.surface.setMonitor(Java2Demo.performancemonitor != null);
                    c.tools.cloneB = 
                        c.tools.addTool("clone.gif","Clone the Surface",this);
                    Dimension d = c.tools.toolbar.getPreferredSize();
                    c.tools.toolbar.setPreferredSize(
                        new Dimension(d.width+27, d.height));
                    if (Java2Demo.backgroundColor != null) {
                        c.surface.setBackground(Java2Demo.backgroundColor);
                    }
                } 
                clonePanels[i].add(c);
                String s = dp.className.substring(dp.className.indexOf('.')+1);
                tabbedPane.addTab(s, clonePanels[i]);
            }
            p.add(tabbedPane);
            remove(tmpP);
            add(p);

            tabbedPane.addChangeListener(this);
            validate();
        }

        String className = e.getComponent().toString();
        className = className.substring(0, className.indexOf('['));

        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            String s1 = className.substring(className.indexOf('.')+1);
            if (tabbedPane.getTitleAt(i).equals(s1)) {
                tabbedPane.setSelectedIndex(i);
                break;
            }
        }

        validate();
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }


    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b.getToolTipText().startsWith("Clone")) {
            cloneDemo();
        } else {
            removeClone(b.getParent().getParent().getParent().getParent());
        }
    }


    private int index;

    public void stateChanged(ChangeEvent e) {
        shutDown((JPanel) tabbedPane.getComponentAt(index));
        index = tabbedPane.getSelectedIndex();
        setup(false);
    }


    public JPanel getPanel() {
        if (tabbedPane != null) {
            return (JPanel) tabbedPane.getSelectedComponent();
        } else {
            return (JPanel) getComponent(0);
        }
    }


    public void setup(boolean issueRepaint) {

        JPanel p = getPanel();

        // Let PerformanceMonitor know which demos are running
        if (Java2Demo.performancemonitor != null) {
            Java2Demo.performancemonitor.surf.setPanel(p);
            Java2Demo.performancemonitor.surf.setSurfaceState();
        }

        // .. tools check against global controls settings ..
        // .. & start demo & custom control thread if need be ..
        for (int i = 0; i < p.getComponentCount(); i++) {
            DemoPanel dp = (DemoPanel) p.getComponent(i);

            if (dp.surface != null) {
                Tools t = dp.tools;
                if (t.startStopB != null && t.startStopB.isSelected()) {
                   dp.surface.start();
                }

                Controls c = Java2Demo.controls;
                if (c == null) {
                    continue;
                }

                t.setVisible(isValid());
                t.issueRepaint = issueRepaint;
                JButton b[] = {t.toggleB, t.aliasB, t.renderB,
                               t.textureB, t.compositeB};
                JCheckBox cb[] = {c.toolBarCB, c.aliasCB, c.renderCB,
                                  c.textureCB, c.compositeCB};
                for (int j = 0; j < b.length; j++) {
                    if (c.obj != null && c.obj.equals(cb[j])) {
                        if (b[j].isSelected() != cb[j].isSelected()) {
                            b[j].doClick();
                        }
                    } else if (c.obj == null) {
                        if (b[j].isSelected() != cb[j].isSelected()) {
                            b[j].doClick();
                        }
                    }
                }
                t.setVisible(true);
                if (c.screenCombo.getSelectedIndex() != t.screenCombo.getSelectedIndex()) 
                {
                    t.screenCombo.setSelectedIndex(c.screenCombo.getSelectedIndex());
                }
                if (Java2Demo.verboseCB.isSelected()) {
                    dp.surface.verbose();
                }
                dp.surface.setSleepAmount(c.slider.getValue());
                if (Java2Demo.backgroundColor != null) {
                    dp.surface.setBackground(Java2Demo.backgroundColor);
                }
                t.issueRepaint = true;
            }
        
            if (dp.custom != null
                && Java2Demo.ccthreadCB != null 
                    && Java2Demo.ccthreadCB.isSelected()) {
                dp.custom.customControlsThread(CustomControls.START);
            }
        } 
        validate();
    }


    public void shutDown(JPanel p) {
        invalidate();
        for (int i = 0; i < p.getComponentCount(); i++) {
            DemoPanel dp = (DemoPanel) p.getComponent(i);
            if (dp.surface != null) {
                dp.surface.stop();
                dp.surface.bimg = null;
            }
            if (dp.custom != null) {
                dp.custom.customControlsThread(CustomControls.STOP);
            }
        } 
        System.gc();
    }


    public void cloneDemo() {
        int i = tabbedPane.getSelectedIndex() - 1;
        if (clonePanels[i].getComponentCount() == 1) {
            clonePanels[i].invalidate();
            clonePanels[i].setLayout(new GridLayout(0,columns,5,5));
            clonePanels[i].validate();
        }
        DemoPanel original = (DemoPanel) getPanel().getComponent(0);
        DemoPanel clone = new DemoPanel(original.className);
        if (columns == 2) {
            clone.setDemoBorder(clonePanels[i]);
        }
        clone.tools.cloneB = 
              clone.tools.addTool("remove.gif","Remove the Surface",this);
        Dimension d = clone.tools.toolbar.getPreferredSize();
        clone.tools.toolbar.setPreferredSize(
                        new Dimension(d.width+27, d.height));
        if (Java2Demo.backgroundColor != null) {
            clone.surface.setBackground(Java2Demo.backgroundColor);
        }
        if (Java2Demo.controls != null) {
            if (clone.tools.toggleB.isSelected() 
                != Java2Demo.controls.toolBarCB.isSelected())
            {
                clone.tools.toggleB.doClick();
            } 
        }
        clone.surface.start();
        clone.surface.setMonitor(Java2Demo.performancemonitor != null);
        clonePanels[i].add(clone);
        clonePanels[i].repaint();
        clonePanels[i].validate();
    }


    public void removeClone(Component theClone) {
        int i = tabbedPane.getSelectedIndex() - 1;
        if (clonePanels[i].getComponentCount() == 2) {
            Component cmp = clonePanels[i].getComponent(0);
            clonePanels[i].removeAll();
            clonePanels[i].setLayout(new BorderLayout());
            clonePanels[i].validate();
            clonePanels[i].add(cmp);
        } else {
            clonePanels[i].remove(theClone);
            int cmpCount = clonePanels[i].getComponentCount();
            for (int j = 1;j < cmpCount; j++) {
                int top = (j+1 >= 3) ? 0 : 5;
                int left = ((j+1) % 2) == 0 ? 0 : 5;
                EmptyBorder eb = new EmptyBorder(top,left,5,5);
                SoftBevelBorder sbb = new SoftBevelBorder(BevelBorder.RAISED);
                JPanel p = (JPanel) clonePanels[i].getComponent(j);
                p.setBorder(new CompoundBorder(eb, sbb));
            }
        }
        clonePanels[i].repaint();
        clonePanels[i].validate();
    }


    public static void main(String args[]) {
        final DemoGroup group = new DemoGroup(args[0]);
        JFrame f = new JFrame("Java2D Demo - DemoGroup");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
            public void windowDeiconified(WindowEvent e) { group.setup(false); }
            public void windowIconified(WindowEvent e) { 
                group.shutDown(group.getPanel()); 
            }
        });
        f.getContentPane().add("Center", group);
        f.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int WIDTH = 620;
        int HEIGHT = 530;
        f.setLocation(screenSize.width/2 - WIDTH/2,
                          screenSize.height/2 - HEIGHT/2);
        f.setSize(WIDTH, HEIGHT);
        f.show();
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-run")) {
                Java2Demo.ccthreadCB = new JCheckBoxMenuItem("CCThread", true);
            }
        }
        group.setup(false);
    }
}
