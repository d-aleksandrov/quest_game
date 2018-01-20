package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image extends JPanel {

    private BufferedImage _instance;
    public String text;

    public void set_size(Dimension _size) {
        this._size.width = _size.width;
        this._size.height = _size.height;
        updateBounds();
    }

    public Dimension get_size() {
        return _size;
    }

    public Dimension get_pos() {
        return _pos;
    }

    protected Dimension _size;

    public void set_pos(Dimension _pos) {
        this._pos.width = _pos.width;
        this._pos.height = _pos.height;
        updateBounds();
    }

    protected Dimension _pos = new Dimension();

    Image(String path) {
        super();
        setLayout(new BorderLayout());
        try {
            _instance = ImageIO.read(new File(path));
            _size = new Dimension(_instance.getWidth(), _instance.getHeight());
            updateBounds();
        } catch (Exception e) {
            System.out.println("oops");
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return _size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(_instance, 0, 0, _size.width, _size.height, this);

        if (text != null) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

            g.setColor(Color.black);
            g.drawString(text, 0, 20);
        }
    }

    private void updateBounds() {
        setBounds(_pos.width, _pos.height, _size.width, _size.height);
    }

    public void addActionListener(ClickListener l) {
        JPanel me = this;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                l.clicked(me);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
