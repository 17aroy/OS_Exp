import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Process_UI extends JFrame {
    JToolBar jToolBar;//工具条
    JButton jButton1,jButton2,jButton3;
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

        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);

        psa=new PSA();

        this.add(jToolBar, BorderLayout.NORTH);	//添加工具条

        columnNames= new String[]{"名称", "PID","时间片", "优先级", "状态"};
        /*tableValues=new String[][]{{"A","2","22","222","T"},{"B","3","33","333","F"},{"C","4","44","444","T"}};*/
        tableValues=new String[10][5];

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(psa);
                writeReadyData(psa);
            }
        });


        jTable=new JTable(tableValues,columnNames);
        jScrollPane=new JScrollPane(jTable);
        getContentPane().add(jScrollPane,BorderLayout.CENTER);
        this.setTitle("进程管理");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void run(PSA psa){
        if (psa.readyList.isEmpty()&&psa.readyList.get(0).runTime==0){
            psa.addDie();
        } else if (!psa.readyList.isEmpty()&&psa.readyList.get(0).state==1){
            psa.readyRun();
        } else {
            psa.addBlock();
        }
        if (!psa.blockList.isEmpty()){
            psa.addReady();
        }
    }

    public void writeReadyData(PSA psa){
        for (int i = 0; i < psa.readyList.size(); i++) {
            tableValues[i]= psa.getReadyString(i);
            System.out.println(psa.readyList.size());
            System.out.println(psa.getReadyString(i));
        }
    }
}
