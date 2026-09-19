import java.util.Scanner;

class Knapsack002{
    static int solve(int idx, int value,int vl[],int wt[]){
        if(value==0) return 0;
        if(idx<0) return Integer.MAX_VALUE;

        int skip=solve(idx-1,value,vl,wt);
        int select=Integer.MAX_VALUE;
        if(value>=vl[idx]){

            int remen=solve(idx-1, value-vl[idx], vl, wt);
            if(remen!=Integer.MAX_VALUE){
                select=remen+wt[idx];
            }
        }
        return Math.min(skip,select);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int wt[]=new int[n];
        int vl[]=new int[n];
        int value=0;
        for(int i=0; i<n; i++){
            wt[i]=sc.nextInt();
            vl[i]=sc.nextInt();
            value+=vl[i];
        }
        int ans=0;
        for(int i=0; i<=value; i++){
            int val=solve(n-1, i, vl, wt);
            if(val<=w){
                ans=i;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}