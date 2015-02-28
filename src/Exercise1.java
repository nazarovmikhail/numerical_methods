

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise1 {


    public static void main(String[] args){

//        final double e=1e-6;
//
////        double[] x= new double [3];
////        double[] s= new double [3];
////        double[] a= new double [3];
//
        int h=11;
        double[] x= new double [h];
        double[] z= new double [h];

        double a1=0.4;
        double b1=4.0;
        double h1=(b1-a1)/5;

        x[0] = new BigDecimal(a1).setScale(4, RoundingMode.HALF_UP).doubleValue();
        //x[0]=a1;

        for(int i=1; i<h; i++){
            x[i] = new BigDecimal(x[i-1]+h1).setScale(4, RoundingMode.HALF_UP).doubleValue();
            //x[i]=x[i-1]+h1;
        }
        for(int i=0; i<h; i++){
            z[i] = new BigDecimal(ci(x[i])).setScale(6, RoundingMode.HALF_UP).doubleValue();
            System.out.println(x[i]+" \t"+z[i]);
        }

//        x[0]=0.8;
//        x[1]=2;
////        x[2]=3.2;
//
//        for(int i=0; i<6; i++){
//            z[i]=0;
//        }
//
//        int n;
//        double a,q;
//
//        for(int i=0; i<6; i++){
//            n=1;
//            a=(Math.pow(-1,1)*Math.pow(x[i],2))/(factorial(2)*2);
//            while(Math.abs(a)>e){
//                z[i]=z[i]+a;
//                q=-(Math.pow(x[i],2)*2*n)/(Math.pow(2*n+2,2)*(2*n+1));
//                n++;
//                a=a*q;
//            }
//            a=0;
//            System.out.println(x[i]+"\t"+z[i]);
//        }
        int k=11;
        double e1=0;
        System.out.println();
        double[] x1= new double [k];
        double[] f= new double [k];
        double[] f1= new double [k];
        double[] f2= new double [k];

        double[] x2= new double [k];

        for(int i=0; i<h; i++) {
            x2[i] = ((b1 - a1) / 2) * Math.cos((2 * i + 1) / (2 * h) * Math.PI) + (b1 + a1) / 2;
        }


        x1[0] =  new BigDecimal(a1).setScale(4, RoundingMode.HALF_UP).doubleValue();
        double h2 = new BigDecimal((b1-a1)/(k-1)).setScale(4, RoundingMode.HALF_UP).doubleValue();

        for(int i=1; i<k; i++){
            x1[i] = new BigDecimal(x1[i-1]+h2).setScale(4, RoundingMode.HALF_UP).doubleValue();
        }
        for(int i=0; i<k; i++){
            f[i] = new BigDecimal(lagrange(x1[i],x,z)).setScale(6, RoundingMode.HALF_UP).doubleValue();
            f1[i] = new BigDecimal(ci(x1[i])).setScale(6, RoundingMode.HALF_UP).doubleValue();
            f2[i] = new BigDecimal(Math.abs(f[i]-f1[i])).setScale(6, RoundingMode.HALF_UP).doubleValue();
            System.out.println(x1[i]+" \t"+f[i]+"\t"+f1[i]+"\t"+f2[i]);
                    if(Math.abs(f2[i]) >= e1){
                        e1=f2[i];
                    }
            }
        System.out.println(h2);
        System.out.println(Math.abs(e1));
        for(int i=0; i<k; i++){
            System.out.println(x2[i]);
        }

    }

    public static double lagrange(double arg, double[] x, double[] y){
        double result=0;
        for(int i=0; i<x.length; i++){
            double k=1;
            for(int j=0; j<y.length; j++){
                if(j!=i){
                    k = new BigDecimal(k*((arg-x[j])/(x[i]-x[j]))).setScale(4, RoundingMode.HALF_UP).doubleValue();
                }
            }
            result = new BigDecimal(result+(k*y[i])).setScale(6, RoundingMode.HALF_UP).doubleValue();
        }
        return result;
    }

    public static double ci(double x){
        final double e=1e-6;
        double a,q,y=0;
        int n=1;
        a = new BigDecimal(-Math.pow(x,2)/4).setScale(6, RoundingMode.HALF_UP).doubleValue();
        while(Math.abs(a)>e){
            y = new BigDecimal(y+a).setScale(6, RoundingMode.HALF_UP).doubleValue();
            q = new BigDecimal(-(Math.pow(x,2)*2*n)/(Math.pow(2*n+2,2)*(2*n+1))).setScale(6, RoundingMode.HALF_UP).doubleValue();
            n++;
            a=a*q;
        }
        return y;

    }
}
