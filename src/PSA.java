import java.lang.reflect.Array;
import java.util.*;

public class PSA {

    PCB[] pcbs;
    ArrayList<PCB> readyList;
    ArrayList<PCB> blockList;
    ArrayList<PCB> dieList;
    ArrayList<String[][]> readyRecord;
    ArrayList<String[][]> blockRecord;
    ArrayList<String[][]> dieRecoed;
    int count;

    //创建进程和三个进程队列
    public PSA(){
        setPcbs(new PCB[10]);
        setReadyList(new ArrayList<>());
        setBlockList(new ArrayList<>());
        setDieList(new ArrayList<>());
        count=0;
        readyRecord=new ArrayList<>();
        blockRecord=new ArrayList<>();
        dieRecoed=new ArrayList<>();
        start();
    }

    public PCB[] getPcbs() {
        return pcbs;
    }

    public void setPcbs(PCB[] pcbs) {
        this.pcbs=pcbs;

        for (int i = 0; i < 10; i++) {
            pcbs[i]=new PCB(i,"进程"+String.valueOf(i),2,new Random().nextInt(5)+1,new Random().nextInt(10)+5);
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
            readyList.add(pcbs[i]);
        }
    }

    public void addBlock(){
        blockList.add(readyList.get(0));
        readyList.remove(0);
        listSort(blockList);
    }

    public void addReady(){
        blockList.get(0).state=new Random().nextInt(2)+1;
        if (blockList.get(0).state==2) {
            readyList.add(blockList.get(0));
            blockList.remove(0);
            listSort(readyList);
        }
    }

    public void addDie(){
        readyList.get(0).state=0;
        dieList.add(readyList.get(0));
        readyList.remove(0);
    }

    //执行进程
    public void readyRun(){
        readyList.get(0).runTime--;
        readyList.get(0).priority--;
        if (readyList.get(0).runTime==0){
            addDie();
        } else {
            readyList.get(0).state = new Random().nextInt(2) + 1;
            if (readyList.get(0).state==1){
                addBlock();
            }
        }
    }

    //运行一次时间片
    public void run(){
        if (!readyList.isEmpty()){
            readyRun();
        }
        if (!blockList.isEmpty()&&blockList.size()>1){
            addReady();
        }
        if (readyList.isEmpty()&&!blockList.isEmpty()){
            readyList.add(blockList.get(0));
            blockList.remove(0);
        }
    }

    //返回队列对象的字符数组
    public String[] getListString(ArrayList<PCB> list,int i){
        String str[]=new String[]{list.get(i).processName, String.valueOf(list.get(i).pid), String.valueOf(list.get(i).runTime), String.valueOf(list.get(i).priority), (list.get(i).state==0?"die":((list.get(i).state==1)?"block":"ready"))};
        return str;
    }


    //对3个队列进行优先级排序
    public void listSort(ArrayList<PCB> list){
        Collections.sort(list,new pcbComparator());
    }

    //返回队列对象的字符串
    public String toString(ArrayList<PCB> list,int i){
        return list.get(i).processName+"\t "+String.valueOf(list.get(i).pid)+"\t\t "+String.valueOf(list.get(i).runTime)+"\t\t "+String.valueOf(list.get(i).priority)+"\t\t "+String.valueOf(list.get(i).state);
    }

    //打印队列进程数据
    public void wireQueueData(ArrayList<PCB> list){
        System.out.println(list.size());
        System.out.println("名称"+"\t\t"+"PID"+"\t\t"+"时间片"+"\t"+"优先级"+"\t"+"状态");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(toString(list, i));
        }
    }

    //比较器，对进程进行优先级排序
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
