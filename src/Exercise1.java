

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise1 {


    public static void main(String[] args){


        int h=50;
        double[] x= new double [h];
        double[] z= new double [h];

        double a1=0.4;
        double b1=4.0;
        double h1=(b1-a1)/(h-1);

        x[0] = a1;
        //x[0]=a1;

        for(int i=1; i<h; i++){
            x[i] = x[i-1]+h1;
            //x[i]=x[i-1]+h1;
        }
        for(int i=0; i<h; i++){
            z[i] = ci(x[i]);
            System.out.printf("%.2f %.6f" + "\n", x[i], z[i]);
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




        x1[0] =  a1;
        double h2 = (b1-a1)/(k-1);

        for(int i=1; i<k; i++){
            x1[i] = x1[i-1]+h2;
        }
        for(int i=0; i<k; i++){
            f[i] = lagrange(x1[i],x,z);
            f1[i] = ci(x1[i]);
            f2[i] = Math.abs(f[i]-f1[i]);
            System.out.printf("%.2f %.6f %.6f %.6f" + "\n", x1[i],f[i],f1[i],f2[i]);
                    if(Math.abs(f2[i]) >= e1){
                        e1=f2[i];
                    }
            }
        System.out.println();
        double e2=0;
        double[] x2= new double [k];
        double[] f3= new double [k];
        double[] f4= new double [k];
        double[] f5= new double [k];

        for(int i=0; i<k; i++) {
            x2[i] = ((b1 - a1) / 2.0) * Math.cos(((2 * i + 1) * Math.PI)/(2*k+1)) + (b1 + a1) / 2;
        }
        for(int i=0; i<k; i++){
            f3[i] = lagrange(x2[i],x,z);
            f4[i] = ci(x2[i]);
            f5[i] = Math.abs(f3[i]-f4[i]);
            System.out.printf("%.2f %.6f %.6f %.6f" + "\n", x2[i],f3[i],f4[i],f5[i]);
            if(Math.abs(f5[i]) >= e2){
                e2=f2[i];
            }
        }
        System.out.printf("%.6f" + "\n", Math.abs(e1));
        System.out.printf("%.6f" + "\n", Math.abs(e2));
//        for(int i=0; i<k; i++){
//            System.out.printf("%.2f" + "\n", x2[i]);
//        }

    }

    public static double lagrange(double arg, double[] x, double[] y){
        double result=0;
        for(int i=0; i<x.length; i++){
            double k=1;
            for(int j=0; j<y.length; j++){
                if(j!=i){
                    k = k*((arg-x[j])/(x[i]-x[j]));
                }
            }
            result = result+(k*y[i]);
        }
        return result;
    }

    public static double ci(double x){
        final double e=1e-6;
        double a,q,y=0;
        int n=1;
        a = -Math.pow(x,2)/4;
        while(Math.abs(a)>e){
            y = y+a;
            q = -(Math.pow(x,2)*2*n)/(Math.pow(2*n+2,2)*(2*n+1));
            n++;
            a=a*q;
        }
        return y;

    }
}
