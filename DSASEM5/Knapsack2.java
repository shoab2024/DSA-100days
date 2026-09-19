// import java.util.Arrays;
// import java.util.Scanner;

// public class Knapsack2 {
    
//     static int solve(int pr[],int wt[],int idx, int value,int dp[][]){
//         // base  case
//         if(idx==0){
//             if(value==0){
//                 return 0;
//             }else{
//                 return Integer.MAX_VALUE;
//             }
//         }
//         // dp case
//         if(dp[idx-1][value]!=-1){
//         return dp[idx-1][value];
//         }

//         int skip= solve(pr, wt, idx-1, value,dp);
//         int select=Integer.MAX_VALUE;
//         if(value>=wt[idx-1]){
//             select=pr[idx-1]+solve(pr, wt, idx-1, value-wt[idx-1],dp);
//         }
//         return Math.min(skip, select);
//     }
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int n=sc.nextInt();
//             int pr[]=new int[n];
//             int wt[]=new int[n];
//             for(int i=0; i<n;i++){
//                 pr[i]=sc.nextInt();
//             }
//             for(int i=0; i<n; i++){
//                 wt[i]=sc.nextInt();
//             }
//             int value=0;
//             for(int i=0; i<n; i++){
//                 value+=pr[i];
//             }
//             int dp[][]=new int[n][value+1];
//             for(int i=0;i<n; i++){
//                 Arrays.fill(dp[i], -1);
//             }
//             int result=Integer.MAX_VALUE;
//             for(int i=0; i<=value; i++){
//                  result=Math.min(result,solve(pr, wt, n, i,dp));
//             }
            
//             System.out.println(result);
//         }
//     }
// }



// /////
// /// 
// static int solve2(int N, int MaxValue){
//         int dp[][]=new int[N+1][MaxValue+1];

//         for(int i=0;i<=N; i++){
//             dp[i][0]=0;
//         }

//         for(int i=0; i<=N; i++){
//             for(int value=1; value<=MAxValue; value++){
//                 int skip=dp[i-1][value];
//                 int select=Integer.MAX_VALUE;

//                 if(vl[i-1]<=value){
//                     select=wt[i-1]+dp[i-1][value-wt[i-1]];
//                 }
//             }
//         }

//     }