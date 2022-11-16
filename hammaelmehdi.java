public class JobSearsh{

    private class Job {
        int start, finish, profit;
        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public int jobSearsh(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length();
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return sol(jobs);
    }

}

    public int search(Job[] jobs, int index) {
        int start = 0, end = index - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    start = mid + 1;
                else
                    return mid;
            }

        return -1;
    }

public int sol(Job[] jobs) {
        
    int n = jobs.length;
    int[] dp = new int[n];
    dp[0] = jobs[0].profit;
    for (int i=1; i<n; i++) {
        int profit = jobs[i].profit;
        int l = search(jobs, i);
        if (l != -1)
            profit += dp[l];
        dp[i] = Math.max(profit, dp[i-1]);
    }

    return dp[n-1];
}
