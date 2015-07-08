/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelive;
import java.math.*;
/**
 *
 * @author Yuan
 */
public class Binomial {
    private static BigInteger b[][] = new BigInteger[Config.K+1][Config.K+1];
    private static BigInteger fac[] = new BigInteger[Config.K+1];
    
    static {
        fac[0] = BigInteger.ONE;
        for(int i=1;i<=Config.K;i++){
            fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
        }
        b[0][0] = BigInteger.ONE;
        b[1][0] = b[1][1] = BigInteger.ONE;
        for(int i=2;i<=Config.K;i++){
            b[i][0] = b[i][i] = BigInteger.ONE;
            for(int j=1;j<i;j++){
                b[i][j] = b[i-1][j-1].add(b[i-1][j]);
            }
        }
//        for(int i=1;i<Config.K;i++){
//            for(int j=0;j<=i;j++){
//                System.out.print("" + b[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println("Binomial initialized");
    }
    
    public static BigInteger nchoosek(int n, int k){
        return b[n][k];
    }
    
    public static BigInteger factorial(int k){
        return fac[k];
    }
}
