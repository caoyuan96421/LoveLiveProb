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
public class LoveLiveProb {

    
    static BigInteger F[][] = new BigInteger[Config.N+1][Config.K+1];
    static double P[][] = new double[Config.N+1][Config.K+1];
    static double Q[][] = new double[Config.N+1][Config.K+1];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        P[1][1] = 0;
        F[1][1] = BigInteger.ZERO;
        for(int i=2;i<=Config.K;i++){
            P[1][i] = 1;
            F[1][i] = BigInteger.ONE;
        }
        for(int i=2;i<=Config.N;i++){
            for(int j=1;j<=Config.K;j++){
                BigInteger sum=BigInteger.ZERO;
                for(int k=2;k<=j+2-2*i;k++){
                    sum = sum.add(F[i-1][j-k].multiply(Binomial.nchoosek(j, k)));
                }
                F[i][j] = sum;
                P[i][j] = sum.multiply(BigInteger.valueOf(Config.D)).divide(BigInteger.valueOf(i).pow(j)).longValue() / (double)Config.D; // Convert count to probability according to precision defined by D
            }
            double unity = 0;
            double expect = 0;
            for(int j=2;j<=Config.K;j++){
                Q[i][j] = P[i-1][j-2] * (j-1) / (i-1) * Math.pow(1 - 1.0 / i, j - 1);
                unity += Q[i][j];
                expect += Q[i][j] * j;
            }
            System.out.print("n="+i);
            System.out.print(" unity = " + unity);
            System.out.println(" expectation = " + expect);
        }
        for(int i=1;i<=Config.N;i++){
            for(int j=1;j<=Config.K;j++){
                System.out.print("" + Q[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
