import java.util.Scanner;

/**
 * Main class for processing, user interaction, and display
 *
 * @author GaryZhang
 */
public class VectorCalculatorProcessor {

    public void run() {
        System.out.println("Hello, the application is running...");
        System.out.println("Welcome to the vector operation calculator, all the coordinates for a vector " +
                "should be separated by \',\'s \nFor example, for vector <1,2,3>, you should enter " +
                "1,2,3 similarly for negative numbers -1,-2,-3\nWhen entering non-integer data, " +
                "make sure to convert them all to decimals, for example, 1.2,-0.3,7.54323\nTo exit, " +
                "simply type in \'bye\' Hope you enjoy! --Gary");
        while (true) {
            try {
                Scanner sa = new Scanner(System.in);
                Scanner sb = new Scanner(System.in);
                System.out.println("------------------");
                System.out.println("Please enter the first/only vector");
                String input = sa.nextLine();
                if (input.equals("bye")) {
                    System.out.println("See you later!");
                    break;
                }
                String[] coordinatesA = input.split(",");
                Vector va = new Vector(coordinatesA);
                System.out.print("Vector entered, ");
                System.out.println("please enter operation type " +
                        "\n1[magitude],2[dot product],3[cross product],4[angle between],5[unit vector],6[projection].");
                int choice = sa.nextInt();
                if (choice == 1) {
                    System.out.println("Magnitude: " + va.magnitude);
                } else if (choice == 5) {
                    System.out.println("Unit: " + va.unitVec().toString());
                } else if (choice > 6) {
                    System.out.println("Please fill in an integer between 1 and 6.");
                } else {
                    System.out.println("please enter the second vector:");
                    String[] coordinatesB = sb.nextLine().split(",");
                    Vector vb = new Vector(coordinatesB);
                    switch (choice) {
                        case 2:
                            System.out.println("Dot Product: " + VectorOperationUtil.dotProduct(va, vb));
                            break;
                        case 3:
                            System.out.println("Cross Product: " + VectorOperationUtil.crossProduct(va, vb));
                            break;
                        case 4:
                            double d = VectorOperationUtil.angleCosine(va, vb);
                            double rad = d == 0.0 ? d : Math.acos(d);
                            double deg = rad == 0.0 ? 0.0 : Math.toDegrees(rad);
                            System.out.println("Angle Between: Rad " + rad
                                    + " Deg: " + deg);
                            break;
                        case 6:
                            Vector[] recAl = VectorOperationUtil.projectionVec(va, vb);
                            System.out.println("Proj of a on b " + recAl[0]);
                            System.out.println("Proj of b on a " + recAl[1]);
                            break;
                        default:
                            System.out.println("invalid option");
                    }
                }
            } catch (Exception e) {
                System.out.println("Problem with input, please be careful with the format and boundary. Try again please.");
            }
        }
    }
}
