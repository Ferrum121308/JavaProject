package Experiment4;

import Experiment4.Fruit.FruitEntity;
import Experiment4.FruitDao.FruitDao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FruitShop {
    private JFrame frame;
    private JTable table;
    String[] thread = new String[]{"编号","名称","水果单价（元）","计量单位"}；
    String[][] tbody;
    int n;
    FruitDao fruitDao = new FruitDao();
    ArrayList<FruitEntity> list = fruitDao.getList();
    private JTextField id;
    private JTextField name;
    private JTextField price;
    private JComboBox measurement;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FruitShop window = new FruitShop();
                    window.frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public FruitShop() {
        initialize();
    }

}
