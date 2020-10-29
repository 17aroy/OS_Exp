import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Process_UI extends JFrame {
    JToolBar jToolBar;
    JButton jButton,jButton1,jButton2,jButton3;
    String[] columnNames;
    String[][] tableValues;
    JTable jTable;
    JScrollPane jScrollPane;
    PSA psa;
    public Process_UI(){
        this.start();
    }
    public void start(){
        jToolBar=new JToolBar();
        jButton1=new JButton("就绪");
        jButton2=new JButton("阻塞");
        jButton3=new JButton("消亡");
        jButton=new JButton("运行");

        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);
        jToolBar.add(jButton);

        psa=new PSA();

        //添加工具条
        this.add(jToolBar, BorderLayout.NORTH);

        columnNames= new String[]{"名称", "PID","时间片", "优先级", "状态"};
        tableValues=new String[10][5];

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                psa.run();
                repaintData(1);
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintData(1);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintData(2);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintData(3);
            }
        });

        jTable=new JTable(tableValues,columnNames);
        jScrollPane=new JScrollPane(jTable);
        getContentPane().add(jScrollPane);

        this.setTitle("进程管理");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void repaintData(int num){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                tableValues[i][j]=" ";
            }
        }
        jTable.repaint();
        if (num==1){
            for (int i = 0; i < psa.readyList.size(); i++) {
                tableValues[i]= psa.getListString(psa.readyList, i);
            }
        } else if (num==2){
            for (int i = 0; i < psa.blockList.size(); i++) {
                tableValues[i]=psa.getListString(psa.blockList, i);
            }
        } else {
            for (int i = 0; i < psa.dieList.size(); i++) {
                tableValues[i]=psa.getListString(psa.dieList, i);
            }
        }
    }
}
