/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gradingsystem;

import java.util.Scanner;

/**
 *
 * @author Marc T
 */
public class GradingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create an object from the scanner class and instanciate it
        
        Scanner scan = new Scanner(System.in);
        Student[] listStudents = new Student[5];
        
        // create a loop for to get the values from the user
        
        for (int i = 0; i < listStudents.length; i++) {
            System.out.println("Entrer nom");
            String n = scan.next();
            System.out.println("Entrer prenom");
            String p = scan.next();
            System.out.println("Entrer note 1");
            int n1 = scan.nextInt();
            System.out.println("Entrer note 2");
            int n2 = scan.nextInt();
         // create a object Student and instanciate it 
            Student student = new Student(n, p, 0, 0);
            listStudents[i] = student;

        }
//        for (int i = 0; i < listStudents.length; i++) {
//            System.out.println("Nom :" + listStudents[i].getNom());
//        }

         //create a loop for to get the values entered and print out the results
         
        for (Student t : listStudents) {
            if (((t.getNote1() + t.getNote2()) / 2) > 60) {
                System.out.println("Nom : " + t.getNom() + " " + t.getPrenom() + " Succes");
            } else {
                System.out.println("Nom : " + t.getNom() + " " + t.getPrenom() + " Succes");
            }
        }
    }
}
