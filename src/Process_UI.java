import javax.swing.*;
import java.awt.*;

public class Process_UI extends JFrame {
    JToolBar jToolBar;//工具条
    JButton jButton,jButton2,jButton3;
    String[] columnNames;
    String[][] tableValues;
    JTable jTable;
    JScrollPane jScrollPane;

    public Process_UI(){
        this.start();
    }
    public void start(){
        jToolBar=new JToolBar();
        jButton=new JButton("就绪");
        jButton2=new JButton("阻塞");
        jButton3=new JButton("消亡");

        jToolBar.add(jButton);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);

        this.add(jToolBar, BorderLayout.NORTH);	//添加工具条

        columnNames= new String[]{"名称", "PID","时间片", "优先级", "状态"};
        tableValues=new String[][]{{"A","2","22","222","T"},{"B","3","33","333","F"},{"C","4","44","444","T"}};
        jTable=new JTable(tableValues,columnNames);
        jScrollPane=new JScrollPane(jTable);
        getContentPane().add(jScrollPane,BorderLayout.CENTER);
        this.setTitle("进程管理");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
