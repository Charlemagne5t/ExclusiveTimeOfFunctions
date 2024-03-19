import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        int t = 0;
        for(String log : logs){
            String[] arr = log.split(":");
            int func = Integer.parseInt(arr[0]);
            String action = arr[1];
            int time = Integer.parseInt(arr[2]);
            t = time;
            if(action.equals("start")){
                if(stack.isEmpty()){
                    stack.push(new int[]{func, time});
                }else {
                    int f = stack.peek()[0];
                    int sTime = stack.poll()[1];
                    res[f] += t - sTime;
                    stack.push(new int[]{f, -1});
                    stack.push(new int[]{func, time});
                }
            }else {
                int f = stack.peek()[0];
                int sTime = stack.poll()[1];
                res[f] += t  + 1 - sTime;
                if(!stack.isEmpty()){
                    int[] onHold = stack.poll();
                    onHold[1] = t + 1;
                    stack.push(onHold);
                }
            }
        }

        return res;
    }
}