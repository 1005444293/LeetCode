public class LC860_柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            //第一种情况，bill为5
            if (bill == 5){
                five++;
                //第二种情况，bill为10
            }else if (bill == 10){
                if (five <= 0) return false;
                five--;
                ten++;
            }else if (bill == 20){
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
