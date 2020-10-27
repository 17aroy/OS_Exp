import java.util.Random;

import static java.lang.Thread.getAllStackTraces;
import static java.lang.Thread.sleep;

public class Factory {
    Info info;
    int productionSpeed;
    int consumptionSpeed;

    public Factory(Info info,int productionSpeed,int consumptionSpeed) {
        this.info = info;
        this.productionSpeed=productionSpeed;
        this.consumptionSpeed=consumptionSpeed;
    }

    public void start() throws InterruptedException{
        while(true){
            if (new Random().nextInt(productionSpeed)==0){
                if (info.product<5){
                    info.produce();
                } else {
                    System.out.println("库存已满，停止生产");
                }
                sleep(500);

            }

            if (new Random().nextInt(consumptionSpeed)==0){
                if (info.product>0){
                    info.consumption();
                } else {
                    System.out.println("库存已空，停止消费");
                }
                sleep(500);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException{

        Info info=new Info(0);
        Factory factory=new Factory(info,2,3);
        factory.start();
    }
}


