package java_base.lesson_8;

import javax.swing.*;

public abstract class BaseFieldButton implements FieldItem {
    protected JButton btn;

    public BaseFieldButton(String imgPath) {
        btn = new JButton(new ImageIcon(imgPath));
    }

    @Override
    public JButton getItem() {
        return btn;
    }
}
