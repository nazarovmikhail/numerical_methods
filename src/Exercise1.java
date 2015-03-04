



public class Exercise1 {


    public static void main(String[] args) {
        MakeRoots(0.4,4,10,5);
//        MakeChebishevRoots(0.4,4,10,5);
//        for (int i=6; i<70; i++){
//            Accuracy(0.4,4,10,i);
//        }
//        for (int i=6; i<70; i++){
//            AccuracyChebishev(0.4,4,10,i);
//        }

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

    public static void AccuracyChebishev (double a, double b, int n, int m) {
        double[] array = new double[m + 1];
        double[] array1 = new double[n + 1];

        double h = (Math.max(a, b) - Math.min(a, b)) / n;

        for (int i = 0; i <= m; i++) {
            array[i] = ((Math.max(a, b) - Math.min(a, b)) / 2) * Math.cos(Math.PI * (2 * i + 1) / (2 * m + 2)) + ((b + a) / 2);
        }
        for (int i = 0; i <= n; i++) {
            array1[i] = Math.min(a, b) + i * h;

        }
        double maxp = 0.0;
        for (int i = 0; i <= n; i++) {
            double j = lagrange(array1[i], array, m) - ci(array1[i]);
            if (Math.abs(maxp) < Math.abs(j))
                maxp = Math.abs(j);
        }
        System.out.printf("%d %.6f" + "\n", m, maxp);
    }

    public static void MakeChebishevRoots ( double a, double b, int n, int m){

        double[] array = new double[m+1];
        double[] array1 = new double[n+1];

        //array[0]=Math.min(a,b);
        //array1[0]=Math.min(a,b);

        double h = (Math.max(a,b)-Math.min(a,b))/n;

        for( int i=0; i<=m; i++){
            array[i]=(((Math.max(a,b))-Math.min(a,b))/2)*Math.cos(Math.PI*(2*i+1)/(2*m+2))+((b+a)/2);
        }
        for (int i=0;i<=n; i++){
            array1[i]=Math.min(a,b)+i*h;
        }
        for (int i=0; i<=n;i++){
            System.out.printf("%.2f %.6f %.6f %.6f" + "\n", array1[i], lagrange(array1[i],array,m),ci(array1[i]),Math.abs(lagrange(array1[i],array,m)-ci(array1[i])));
            //System.out.printf("%.6f" + "\n",Math.abs(lagrange(mass1[i],mass,m)-ci(mass1[i])));
        }
    }

    public static void MakeRoots (double a, double b, int n, int m){

        double[] array = new double[m+1];
        double[] array1 = new double[n+1];

        double h = (Math.max(a,b)-Math.min(a,b))/m;
        double h1 = (Math.max(a,b)-Math.min(a,b))/n;

        for( int i=0; i<=m; i++){
            array[i]=Math.min(a,b)+i*h;
        }
        for (int i=0;i<=n; i++){
            array1[i]=Math.min(a,b)+i*h1;
        }
        for (int i=0; i<=n;i++){
            //System.out.printf("%.2f %.6f %.6f %.6f" + "\n", array1[i], lagrange(array1[i],array,m),ci(array1[i]),Math.abs(lagrange(array1[i],array,m)-ci(array1[i])));
            System.out.printf("%.6f" + "\n", Math.abs(lagrange(array1[i],array,m)-ci(array1[i])));
        }
    }

    public static void Accuracy (double a, double b, int n, int m){
        double[] array = new double[m + 1];
        double[] array1 = new double[n + 1];

        double h = (Math.max(a, b) - Math.min(a, b)) / m;
        double h1 = (Math.max(a, b) - Math.min(a, b)) / n;

        for (int i = 0; i <= m; i++) {
            array[i] = Math.min(a, b) + i * h;
        }
        for (int i = 0; i <= n; i++) {
            array1[i] = Math.min(a, b) + i * h1;

        }
        double maxp = 0.0;
        for (int i = 0; i <= n; i++) {
            double j = lagrange(array1[i], array, m) - ci(array1[i]);
            if (Math.abs(maxp) < Math.abs(j))
                maxp = Math.abs(j);
        }
        System.out.printf("%d %.6f" + "\n", m, maxp);
    }

}