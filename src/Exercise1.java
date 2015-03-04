

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise1 {


    public static void main(String[] args) {


        //for(int h=5;h<60;h=h+2) {
        int h = 6;
        double[] x = new double[h];
        double[] z = new double[h];

        double a1 = 0.4;
        double b1 = 4.0;
        double h1 = (b1 - a1) / (h - 1);

        for (int i = 0; i < h; i++) {
            x[i] = a1 + h1 * i;
        }
        for (int i = 0; i < h; i++) {
            z[i] = ci(x[i]);
            //System.out.printf("%.2f %.6f" + "\n", x[i], z[i]);
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
        //System.out.println();

        int k = 11;
        double e1 = 0;
        double[] x1 = new double[k];
        double[] f = new double[k];
        double[] f1 = new double[k];
        double[] f2 = new double[k];

        double h2 = (b1 - a1) / (k - 1);

        for (int i = 0; i < k; i++) {

            x1[i] = a1 + h2 * i;
        }
        for (int i = 0; i < k; i++) {
            f[i] = lagrange(x1[i], x, h);
            f1[i] = ci(x1[i]);
            f2[i] = Math.abs(f[i] - f1[i]);
            //System.out.printf("%.2f %.6f %.6f %.6f" + "\n", x1[i], f[i], f1[i], f2[i]);
            //System.out.printf("%.6f" + "\n", f2[i]);
            if (Math.abs(f2[i]) >= e1) {
                e1 = f2[i];
            }
        }

        //System.out.println();
        double e2 = 0;
        double[] x2 = new double[k];
        double[] f3 = new double[k];
        double[] f4 = new double[k];
        double[] f5 = new double[k];


        for (int i = 0; i < k; i++) {
            x2[i] = ((b1 - a1) / 2) * Math.cos(Math.PI * (2 * i + 1) / (2 * (k - 1) + 2)) + (b1 + a1) / 2;
        }


        for (int i = 0; i < k; i++) {
            f3[i] = lagrange(x[i], x2, h);
            f4[i] = ci(x[i]);
            f5[i] = Math.abs(f4[i] - f3[i]);
            //System.out.printf("%.2f %.6f %.6f %.6f" + "\n", x2[i], f3[i], f4[i], f5[i]);
            //System.out.printf("%.6f" + "\n", f5[i]);
            if (Math.abs(f5[i]) >= e2) {
                e2 = f5[i];
            }
        }
//        for (int i = 5; i < 60; i=i+2) {
//            PogreshnostCheb(0.4, 4, k-1, i);
//        }
        MakeChebish(a1,b1,10,5);

    }



    public static double lagrange(double arg, double[] x, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            double g = ci(x[i]);
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    g *= ((arg - x[j]) / (x[i] - x[j]));
                }
            }
            result += g;
        }
        return result;
    }

    public static double ci(double x) {
        final double e = 1e-6;
        double a, q, y = 0;
        int n = 1;
        a = -Math.pow(x, 2) / 4;
        while (Math.abs(a) > e) {
            y = y + a;
            q = -(Math.pow(x, 2) * 2 * n) / (Math.pow(2 * n + 2, 2) * (2 * n + 1));
            n++;
            a = a * q;
        }
        return y;

    }

    public static void PogreshnostCheb(double a, double b, int n, int m) {
        double[] mass = new double[m + 1];
        double[] mass1 = new double[n + 1];
        mass[0] = Math.min(a, b);
        mass1[0] = Math.min(a, b);

        double h = (Math.max(a, b) - Math.min(a, b)) / n;
        for (int i = 0; i <= m; i++) {
            mass[i] = ((Math.max(a, b) - Math.min(a, b)) / 2) * Math.cos(Math.PI * (2 * i + 1) / (2 * m + 2)) + ((b + a) / 2);
        }
        for (int i = 0; i <= n; i++) {
            mass1[i] = Math.min(a, b) + i * h;

        }
        double maxp = 0.0;
        for (int i = 0; i <= n; i++) {
            double j = lagrange(mass1[i], mass, m) - ci(mass1[i]);
            if (Math.abs(maxp) < Math.abs(j))
                maxp = Math.abs(j);
        }
        //System.out.printf("%d %.6f" + "\n", m, maxp);
    }

    public static void MakeChebish( double a, double b, int n, int m){
        double[] mass = new double[m+1];
        double[] mass1 = new double[n+1];

        mass[0]=Math.min(a,b);
        mass1[0]=Math.min(a,b);

        double h = (Math.max(a,b)-Math.min(a,b))/n;

        for( int i=0; i<=m; i++){
            mass[i]=(((Math.max(a,b))-Math.min(a,b))/2)*Math.cos(Math.PI*(2*i+1)/(2*m+2))+((b+a)/2);
        }
        for (int i=1;i<=n; i++){
            mass1[i]=Math.min(a,b)+i*h;
        }
        for (int i=0; i<=n;i++){
            System.out.printf("%.2f %.6f %.6f %.6f" + "\n", mass1[i], lagrange(mass1[i],mass,m),ci(mass1[i]),Math.abs(lagrange(mass1[i],mass,m)-ci(mass1[i])));
            //System.out.printf("%.6f" + "\n",Math.abs(lagrange(mass1[i],mass,m)-ci(mass1[i])));
        }
    }

}