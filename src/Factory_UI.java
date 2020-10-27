import javax.swing.*;
import java.awt.*;

public class Factory_UI extends JFrame {
    JPanel jPanel1,jPanel2;
    JLabel jLabel1,jLabel2;
    ImageIcon imageIcon1,imageIcon2;

    public Factory_UI(){
        start();
    }

    public void start(){


        jLabel1=new JLabel();
        jLabel2=new JLabel();

        imageIcon1=new ImageIcon("./image/producer.jpg");
        imageIcon2=new ImageIcon("./image/consumer.jpg");

        imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        jLabel1.setIcon(imageIcon1);
        jLabel2.setIcon(imageIcon2);

        jLabel1.setSize(100,100);
        jLabel2.setSize(100,100);

        jLabel1.setLocation(0,150);
        jLabel2.setLocation(682,150);

        this.add(jLabel1);
        this.add(jLabel2);

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
