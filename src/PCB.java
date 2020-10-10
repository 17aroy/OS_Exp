public class PCB{
    int pid;
    String processName;
    int state;
    int runTime;
    int priority;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PCB(int pid, String processName,int state, int runTime, int priority) {
        this.pid = pid;
        this.processName = processName;
        this.state = state;
        this.runTime = runTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PCB{" +
                "pid=" + pid +
                ", processName='" + processName + '\'' +
                ", state=" + state +
                ", runTime=" + runTime +
                ", priority=" + priority +
                '}';
    }
}
