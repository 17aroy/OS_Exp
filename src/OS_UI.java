import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class OS_UI extends JFrame{
    JMenuBar jMenuBar;//菜单栏
    JMenu menu1,menu2,menu3,menu4,menu5;//菜单项
    JMenuItem item11,item12,item13,item21,item22,item31,item32,item33,item34,item41,item42,item5;//菜单子项
    //可以写成数组形式，如menu[0]...,item[0]...
    JToolBar jToolBar;//工具条
    JButton button1,button2,button3;//按钮

    JTextArea jTextArea;

    public OS_UI(){
        start();
    }

    public void start(){
        //创建菜单
        jMenuBar=new JMenuBar();
        menu1=new JMenu("文件(F)");
        menu1.setMnemonic(KeyEvent.VK_F);
        menu2=new JMenu("编辑(E)");
        menu2.setMnemonic(KeyEvent.VK_E);
        menu3 =new JMenu("进程管理(P)");
        menu4=new JMenu("存储管理(M)");
        menu5=new JMenu("设备管理(D)");


        //创建菜单子项
        item11=new JMenuItem("打开(O)",KeyEvent.VK_O);
        item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        item11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                openTextFile();
            }
        });

        item12=new JMenuItem("保存(S)",KeyEvent.VK_S);
        item12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                savaTextFile();
            }
        });
        item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        item13=new JMenuItem("退出(X)",KeyEvent.VK_X);
        item13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        item13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);}}
        );
        item21=new JMenuItem("允许编辑");
        item21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jTextArea.setEditable(true);
            }
        });
        item22=new JMenuItem("禁止编辑");
        item22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                jTextArea.setEditable(false);
            }
        });
        item31=new JMenuItem("进程状态转换");
        item32=new JMenuItem("生产者-消费者");
        item33=new JMenuItem("进程调度");
        item33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Process_UI();
            }
        });
        item34=new JMenuItem("银行家算法");
        item41=new JMenuItem("动态分区分配算法");
        item42=new JMenuItem("页面置换算法");
        item5=new JMenuItem("磁盘调度算法");

        //创建工具栏
        jToolBar=new JToolBar();
        button1=new JButton("打开");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                openTextFile();
            }
        });
        button2=new JButton("保存");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                savaTextFile();
            }
        });
        button3=new JButton("退出");
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);}}
        );

        //创建文本框
        jTextArea=new JTextArea();
        /*jTextArea.setEditable(flag);*/
        JScrollPane jsp = new JScrollPane(jTextArea);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //添加菜单项
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        menu2.add(item21);
        menu2.add(item22);
        menu3.add(item31);
        menu3.add(item32);
        menu3.add(item33);
        menu3.add(item34);
        menu4.add(item41);
        menu4.add(item42);
        menu5.add(item5);
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);
        jMenuBar.add(menu3);
        jMenuBar.add(menu4);
        jMenuBar.add(menu5);

        //添加按钮
        jToolBar.add(button1);
        jToolBar.add(button2);
        jToolBar.add(button3);


        this.setJMenuBar(jMenuBar);//添加菜单栏
        this.add(jToolBar, BorderLayout.NORTH);	//添加工具条
        this.add(jsp, BorderLayout.CENTER);	//添加文本域

        this.setTitle("操作系统辅助教学系统");
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //用于打开文件的方法
    public void openTextFile() {
        JFileChooser fileChooser=new JFileChooser();    //创建文件选择对话框
        fileChooser.setFileFilter(new FileNameExtensionFilter("文本文件","txt"));
        int returnValue=fileChooser.showOpenDialog(getContentPane());    //打开文件选择对话框
        if(returnValue==JFileChooser.APPROVE_OPTION) {
            File file=fileChooser.getSelectedFile();    //获得文件对象
            BufferedReader in;    //声明字符缓冲流
            try {
                in=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
                String info=in.readLine();    //从文件中读取一行信息
                while(info!=null) {
                    //判断是否读到内容
                    jTextArea.append(info+"\n");    //把读到的信息追加到文本域中
                    info=in.readLine();    //继续读下一行信息
                }
                in.close();    //关闭字符缓冲流
            }
            catch(Exception ex) {
                ex.printStackTrace();    //输出栈踪迹
            }
        }
    }
    //用于保存文件的方法
    public void savaTextFile(){

        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(null);
        if(option==JFileChooser.APPROVE_OPTION){	//假如用户选择了保存
            File file = chooser.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(file+".txt");
                fos.write(jTextArea.getText().getBytes());
                fos.close();

            } catch (IOException e) {
                System.err.println("IO异常");
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new OS_UI();
    }
}
