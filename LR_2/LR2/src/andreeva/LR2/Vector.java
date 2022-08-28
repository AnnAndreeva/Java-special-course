package andreeva.LR2;

public class Vector {
    private double[] v;
    public Vector(int length){
        v = new double[length];
    }
    //получение элемента вектора
    public double getElement( int index){
        return this.v[index];
    }
    //установка элемента вектора
    public void setElement(int index, double element){
        this.v[index] = element;
    }
    //получение «длины» вектора
    public int getLength(){
        return v.length;
    }
    //поиск минимального значения из элементов вектора
    public double getMin(){
        double min = v[0];
        for (int i = 1; i < v.length; i++){
            if(v[i]<min){
                min = v[i];
            }
        }
        return min;
    }
    //поиск максимального значения из элементов вектора
    public double getMax(){
        double max = v[0];
        for (int i = 1; i < v.length; i++){
            if(v[i]>max){
                max = v[i];
            }
        }
        return max;
    }
    //сортировка элементов вектора по возрастанию
    public void sort(){
        for (int i = 1; i < v.length; i++) {
            if (v[i] <  v[i - 1]) {
                swap(v, i, i-1);
            }
        }
    }

    private void swap(double[] vec, int i, int j) {
        double tmp =  vec[i];
        vec[i] = vec[j];
        vec[j] = tmp;
    }
    //нахождение евклидовой нормы
    public double getNorm(){
        double norm = 0;
        for (int i = 0; i < v.length; i++){
            norm+= v[i] * v[i];
        }
        norm = Math.sqrt(norm);
        return norm;
    }
    //умножение вектора на число
    public void mulNum(int num){
        for (int i = 0; i < v.length; i++){
            v[i] *= num;
        }
    }
    //сложение двух векторов
    public static Vector sumVectors(Vector vector1, Vector vector2){
        Vector sumVector = null;
        int minLen = 0;
        if(vector1.getLength()<=vector2.getLength())
        {
            sumVector = new Vector(vector2.getLength());
            minLen = vector1.getLength();
            for (int i = 0; i < sumVector.getLength(); i++){
                if(i>=minLen){
                    sumVector.setElement(i, 0 + vector2.getElement(i));
                }
                else {
                    sumVector.setElement(i,  vector1.getElement(i) + vector2.getElement(i));
                }
            }
        }
        else {
            sumVector = new Vector(vector1.getLength());
            minLen = vector2.getLength();
            for (int i = 0; i < sumVector.getLength(); i++){
                if(i>=minLen){
                    sumVector.setElement(i, 0 + vector1.getElement(i));
                }
                else {
                    sumVector.setElement(i,  vector1.getElement(i) + vector2.getElement(i));
                }
            }
        }

        return sumVector;
    }

    //умножение двух векторов
    public static double mulVectors(Vector vector1, Vector vector2){
        double mulVector = 0;
        if(vector1.getLength()==vector2.getLength()){
            for (int i = 0; i < vector1.getLength(); i++){

                mulVector += vector1.getElement(i) + vector2.getElement(i);
            }
        }
        else mulVector=-1;
        return mulVector;
    }
}
