public class LC134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //curNum用于记录当前对应的gas[i]-cost[i]的值，如果为
        // 负数证明不能到达下一个加油站，需要将curNum清零并将res+1
        int curNum = 0;
        //totalNum用于记录总的gas与cost的差值，
        //如果为负值表明无论如何汽车也不能绕环路行驶一周
        int totalNum = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            curNum += gas[i] - cost[i];
            totalNum += gas[i] - cost[i];
            if (curNum < 0){
                curNum = 0;
                res = i + 1;
            }
        }
        if (totalNum < 0) return -1;
        return res;
    }
}
