import java.util.Scanner;

public class GradingSystem {

  private static final int PASSING_GRADE = 60;
  
  public enum GradeLetter {
    A, B, C, D, F
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Student[] students = new Student[5];

    // Saisie des infos étudiants
    for (int i = 0; i < students.length; i++) {
      
      System.out.print("Entrez le nom : ");
      String lastName = scanner.nextLine();

      System.out.print("Entrez le prénom : ");
      String firstName = scanner.nextLine();

      int grade1 = getValidGrade(scanner);
      int grade2 = getValidGrade(scanner); 
      int grade3 = getValidGrade(scanner);

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

  public static int getValidGrade(Scanner scanner) {
    
    int grade;
    do {
      System.out.print("Entrez la note : ");
      grade = scanner.nextInt();
    } while (grade < 0 || grade > 100); 

    return grade;
  }

}

class Student {

  private final String lastName;
  private final String firstName;
  private final int grade1;
  private final int grade2;
  private final int grade3;

  public Student(String lastName, String firstName, int grade1, int grade2, int grade3) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.grade1 = grade1;
    this.grade2 = grade2;
    this.grade3 = grade3;
  }

  public double calculateAverageGrade() {
    return (grade1 + grade2 + grade3) / 3.0;
  }

  public GradeLetter getGradeLetter() {
    
    double avg = calculateAverageGrade();
    
    if (avg >= 90) return GradeLetter.A;
    else if (avg >= 80) return GradeLetter.B;
    else if (avg >= 70) return GradeLetter.C;
    else if (avg >= 60) return GradeLetter.D;
    else return GradeLetter.F;
  }

}
