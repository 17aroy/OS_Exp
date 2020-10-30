import javax.swing.*;
import java.awt.*;

public class Factory_UI extends JFrame {
    //JPanel jPanel1,jPanel2;
    JLabel jLabel1,jLabel2,jLabel3,jLabel4;
    ImageIcon imageIcon1,imageIcon2,imageIcon3,imageIcon4;

    //JPanel jPanel[]=new JPanel[5];
    JLabel jLabel[]=new JLabel[5];
    ImageIcon imageIcon[]=new ImageIcon[5];

    public Factory_UI(){
        start();
    }

    public void start(){

        jLabel1=new JLabel();
        jLabel2=new JLabel();
        jLabel3=new JLabel();
        jLabel4=new JLabel();
        //jLabel[0]=new JLabel();

        imageIcon1=new ImageIcon("./image/producer.jpg");
        imageIcon2=new ImageIcon("./image/consumer.jpg");
        imageIcon3=new ImageIcon("./image/conveyorBelt.gif");
        imageIcon4=new ImageIcon("./image/conveyorBelt.gif");
        //imageIcon[0]=new ImageIcon("./image/product.jpg");

        imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imageIcon3.setImage(imageIcon3.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
        imageIcon4.setImage(imageIcon4.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));

        //imageIcon[0].setImage(imageIcon[0].getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        jLabel1.setIcon(imageIcon1);
        jLabel2.setIcon(imageIcon2);
        jLabel3.setIcon(imageIcon3);
        jLabel4.setIcon(imageIcon4);
        //jLabel[0].setIcon(imageIcon[0]);

        jLabel1.setSize(100,100);
        jLabel2.setSize(100,100);
        jLabel3.setSize(200,100);
        jLabel4.setSize(200,100);
        //jLabel[0].setSize(50,50);

        jLabel1.setLocation(0,150);
        jLabel2.setLocation(682,150);
        jLabel3.setLocation(130,150);
        jLabel4.setLocation(450,150);
        //jLabel[0].setLocation(350,300);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);

        for (int i = 0; i < 5; i++) {
            jLabel[i]=new JLabel();
            imageIcon[i]=new ImageIcon("./image/product.jpg");
            imageIcon[i].setImage(imageIcon[i].getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            jLabel[i].setIcon(imageIcon[i]);
            jLabel[i].setSize(50,50);
            jLabel[i].setLocation(360,300-(i*50));
            this.add(jLabel[i]);
        }



        this.setLayout(null);
        this.setTitle("生产者-消费者");
        this.setSize(800,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Factory_UI();
    }
}
