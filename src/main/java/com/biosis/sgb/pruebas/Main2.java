/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.pruebas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//www.j ava  2s .  c  o m
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class Main2 {

    private static TreeModel getTreeModel() {
        return new DefaultTreeModel(getNodes(new DefaultMutableTreeNode(
                "<html>Root <a href=\"http://www.google.be\">Google</a></html>"), 5));
    }

    private static TreeNode getNodes(DefaultMutableTreeNode parent, int i) {
        if (i > 0) {
            for (int j = 0; j < 5; j++) {
                DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(
                        "<html>Node "
                        + (j + 1)
                        + " <a href=\"http://www.java2s.com\">java2s.com</a></html> and text");
                getNodes(newChild, i - 1);
                parent.add(newChild);
            }
        }
        return parent;
    }

    public static void main(String[] args) throws Exception {
        final JTree tree = new JTree(getTreeModel());
        tree.setCellRenderer(new MyTreeCellRenderer());
        HyperlinkMouseListener listener = new HyperlinkMouseListener(tree);
        tree.addMouseListener(listener);
        tree.addMouseMotionListener(listener);
        JFrame f = new JFrame(Main2.class.getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(tree), BorderLayout.CENTER);
        f.pack();
        f.setSize(f.getWidth() + 100, f.getHeight() + 100);
        f.setVisible(true);
    }

}

class MyTreeCellRenderer extends DefaultTreeCellRenderer implements
        TreeCellRenderer {

    private JEditorPane editorPane;

    public MyTreeCellRenderer() {
        editorPane = new JEditorPane("text/html", null);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, selected,
                expanded, leaf, row, hasFocus);
        if (c instanceof JLabel) {
            JLabel label = (JLabel) c;
            editorPane.setText(label.getText());
            editorPane.setToolTipText(label.getToolTipText());
            editorPane.setOpaque(label.isOpaque());
            editorPane.setBackground(label.getBackground());
            editorPane.setBorder(label.getBorder());
        }
        return editorPane;
    }
}

class HyperlinkMouseListener extends MouseAdapter {

    JTree tree;

    public HyperlinkMouseListener(JTree tree) {
        this.tree = tree;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tree.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Element h = getHyperlinkElement(e);
        if (h != null) {
            Object attribute = h.getAttributes().getAttribute(HTML.Tag.A);
            if (attribute instanceof AttributeSet) {
                AttributeSet set = (AttributeSet) attribute;
                String href = (String) set.getAttribute(HTML.Attribute.HREF);
                if (href != null) {
                    try {
                        Desktop.getDesktop().browse(new URI(href));
                    } catch (URISyntaxException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        boolean isHyperlink = isHyperlink(event);
        if (isHyperlink) {
            tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            tree.setCursor(Cursor.getDefaultCursor());
        }

    }

    private boolean isHyperlink(MouseEvent event) {
        return getHyperlinkElement(event) != null;
    }

    private Element getHyperlinkElement(MouseEvent event) {
        Point p = event.getPoint();
        int selRow = tree.getRowForLocation(p.x, p.y);
        TreeCellRenderer r = tree.getCellRenderer();
        if (selRow == -1 || r == null) {
            return null;
        }
        TreePath path = tree.getPathForRow(selRow);
        Object lastPath = path.getLastPathComponent();
        Component rComponent = r.getTreeCellRendererComponent(tree, lastPath, tree
                .isRowSelected(selRow), tree.isExpanded(selRow), tree.getModel()
                .isLeaf(lastPath), selRow, true);

        if (rComponent instanceof JEditorPane == false) {
            return null;
        }
        Rectangle pathBounds = tree.getPathBounds(path);
        JEditorPane editor = (JEditorPane) rComponent;
        editor.setBounds(tree.getRowBounds(selRow));
        p.translate(-pathBounds.x, -pathBounds.y);
        int pos = editor.getUI().viewToModel(editor, p);
        if (pos >= 0 && editor.getDocument() instanceof HTMLDocument) {
            HTMLDocument hdoc = (HTMLDocument) editor.getDocument();
            Element elem = hdoc.getCharacterElement(pos);
            if (elem.getAttributes().getAttribute(HTML.Tag.A) != null) {
                return elem;
            }
        }
        return null;
    }
}
