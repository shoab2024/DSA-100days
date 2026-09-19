import java.util.Scanner;

class Zeroons{
    
    static int solve(int n, String str, int idx, int z, int o){
        if(idx<0) return 0;
        int Zero=0;
        int One=0;
        
        for(char c:str.toCharArray()){
            if(c=='0') Zero++;
            else One++;
        }
        int skip=solve(n,str,idx-1,z,o);
        int select=0;
        if(Zero<=z && One<=o){
            select=solve(n,str,idx-1,z-Zero,o-One);
        } 

        return Math.max(skip,select);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.nextLine();
        System.out.println(solve(n,str,n-1,sc.nextInt(),sc.nextInt()));
    }
}