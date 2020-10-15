import java.lang.reflect.Array;
import java.util.*;

public class PSA {

    PCB[] pcbs;
    ArrayList<PCB> readyList;
    ArrayList<PCB> blockList;
    ArrayList<PCB> dieList;

    //创建进程和三个进程队列
    public PSA(){
        setPcbs(new PCB[10]);
        setReadyList(new ArrayList<>());
        setBlockList(new ArrayList<>());
        setDieList(new ArrayList<>());
        start();
    }

    public PCB[] getPcbs() {
        return pcbs;
    }

    public void setPcbs(PCB[] pcbs) {
        this.pcbs=pcbs;

        for (int i = 0; i < 10; i++) {
            pcbs[i]=new PCB(i,"进程"+String.valueOf(i),new Random().nextInt(2)+1,new Random().nextInt(5)+1,new Random().nextInt(10)+5);
        }
        Comparator cmp=new pcbComparator();
        Arrays.sort(pcbs,cmp);
    }

    public ArrayList<PCB> getReadyList() {
        return readyList;
    }

    public void setReadyList(ArrayList<PCB> readyList) {
        this.readyList = readyList;
    }

    public ArrayList<PCB> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<PCB> blockList) {
        this.blockList = blockList;
    }

    public ArrayList<PCB> getDieList() {
        return dieList;
    }

    public void setDieList(ArrayList<PCB> dieList) {
        this.dieList = dieList;
    }

    public void start(){
        for (int i = 0; i < 10; i++) {
            if (pcbs[i].state==1) {
                readyList.add(pcbs[i]);
            } else {
                blockList.add(pcbs[i]);
            }
        }

    }
    public void readyRun(){
        readyList.get(0).priority--;
        readyList.get(0).runTime--;
        readyList.get(0).state=new Random().nextInt(2)+1;
    }

    public void addReady(){
        if (blockList.get(0).state==1) {
            readyList.add(blockList.get(0));
            blockList.remove(0);
        }
    }

    public void addDie(){
        dieList.add(readyList.get(0));
        readyList.remove(0);
    }
    public void addBlock(){
        readyList.get(0).state=new Random().nextInt(2)+1;
        blockList.add(readyList.get(0));
        readyList.remove(0);
    }

    public String[] getReadyString(int i){
        String str[]=new String[]{readyList.get(i).processName, String.valueOf(readyList.get(i).pid), String.valueOf(readyList.get(i).runTime), String.valueOf(readyList.get(i).priority), String.valueOf(readyList.get(i).state)};
        return str;
    }

   /* public static void main(String[] args) {
        new PSA().run();
    }*/

    //比较器，按照pcb对象优先级排序
    class pcbComparator implements Comparator<PCB>{
        @Override
        public int compare(PCB o1,PCB o2) {
            int x;
            if (o2.priority<o1.priority){
                x=-1;
            }else {
                x=1;
            }
            return x;
        }
    }
}
