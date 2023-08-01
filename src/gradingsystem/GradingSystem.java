import java.util.Scanner;

public class GradingSystem {

	
  private static final int MAX_STUDENTS = 10;
  private static final int PASSING_GRADE = 60;
  
  public enum GradeLetter {
    A, B, C, D, F
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez le nombre d'étudiants (max "+MAX_STUDENTS+") : ");
    int numStudents = scanner.nextInt();
    scanner.nextLine();
    
    if (numStudents > MAX_STUDENTS) {
      System.out.println("Nombre d'étudiants trop grand, réglé sur "+MAX_STUDENTS);
      numStudents = MAX_STUDENTS;
    }
    
    Student[] students = new Student[numStudents];

    // Saisie des infos étudiants
    for (int i = 0; i < numStudents; i++) {
      
      System.out.print("Entrez le nom : ");
      String lastName = scanner.nextLine();

      System.out.print("Entrez le prénom : ");
      String firstName = scanner.nextLine();

      int grade1 = getExamGradeFromUser(scanner);
      int grade2 = getExamGradeFromUser(scanner); 
      int grade3 = getExamGradeFromUser(scanner);

      students[i] = new Student(lastName, firstName, grade1, grade2, grade3);
    }

    // Affichage des résultats
    for (Student student : students) {
      System.out.printf("Nom : %s %s - Moyenne : %.2f - Note : %s%n",
        student.getLastName(), student.getFirstName(),
        student.calculateAverageGrade(), student.getGradeLetter());
    }
    
    scanner.close();
  }

  public static int getExamGradeFromUser(Scanner scanner) {
    
    int grade;
    do {
      System.out.print("Entrez la note : ");
      grade = scanner.nextInt();
    } while (grade < 0 || grade > 100); 

    return grade;
  }

}
