package andreeva.LR2;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
         int len = 0;
         double res = 0;
         Vector vector_1, vector_2, vector_3;
         Scanner sc = new Scanner(System.in); // создаём объект класса Scanner

	 System.out.println("ЛР 2 Андреева 6413");
     System.out.println("");
     System.out.print("Введите длину вектора 1: ");
     len = sc.nextInt();
     if (len == 0){
            len = 5;
     }
     vector_1 = new Vector(len);

     System.out.println("");
     System.out.print("Вектор 1: ");
     for(int i = 0; i < vector_1.getLength(); i++){
            vector_1.setElement(i, Math.random() * 10);
            System.out.print( vector_1.getElement(i) + "; ");
     }
     System.out.println("");
     System.out.println("Полученная длина вектора 1:" + (vector_1.getLength() +1));

     System.out.println("");
     System.out.println("Элемент вектора 1 с индексом: " + (int)(vector_1.getLength()/2) + ": " + vector_1.getElement((int)(vector_1.getLength()/2)));
     System.out.println("");

        System.out.println("");
        System.out.println("Заменим элемент вектора 1 с индексом: " + (int)(vector_1.getLength()/2) + " на 1.1 ");
        vector_1.setElement((int)(vector_1.getLength()/2), 1.1);
        System.out.println("");

        System.out.print("Вектор 1 после изменения: ");
         for(int i = 0; i < vector_1.getLength(); i++){
             System.out.print( vector_1.getElement(i) + "; ");
         }

         System.out.println("");
         System.out.print("Минимальный элемент: " + vector_1.getMin());
         System.out.println("");

         System.out.println("");
         System.out.print("Максимальный элемент: " + vector_1.getMax());
         System.out.println("");

         System.out.println("");
         vector_1.sort();
         System.out.print("Отсортированный по возрастанию вектор 1: ");
         for(int i = 0; i < vector_1.getLength(); i++){
             System.out.print( vector_1.getElement(i) + "; ");
         }
         System.out.println("");

         System.out.println("");
         System.out.print("Евклидова норма вектора 1: " + vector_1.getNorm());
         System.out.println("");

         System.out.println("");
         System.out.print("Вектор после умножения на число 5: ");
         vector_1.mulNum(5);
         for(int i = 0; i < vector_1.getLength(); i++){
             System.out.print( vector_1.getElement(i) + "; ");
         }
         System.out.println("");

         System.out.print("Введите длину вектора 2: ");
         len = sc.nextInt();
         if (len == 0){
             len = 5;
         }
         vector_2 = new Vector(len);

         System.out.println("");
         System.out.print("Вектор 2: ");
         for(int i = 0; i < vector_2.getLength(); i++){
             vector_2.setElement(i,Math.random() * 10);
             System.out.print( vector_2.getElement(i) + "; ");
         }
         System.out.println("");

         System.out.println("");
         System.out.print("Вектор-сумма двух векторов 1 и 2: ");
         vector_3 = Vector.sumVectors(vector_1, vector_2);
         for(int i = 0; i < vector_3.getLength(); i++){
             System.out.print( vector_3.getElement(i) + "; ");
         }

         System.out.println("");
         res = Vector.mulVectors(vector_1, vector_2);
         if(res != -1){
             System.out.println("Скалярное произведение векторов 1 и 2: "+ res);
         }
         else System.out.println("Умножение векторов разной размерности невозможно.");
    }
}

