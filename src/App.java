import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner in = new Scanner(System.in);
        number[] numbers = new number[37]; // Assuming 37 numbers
        numbers[0] = new number(0);
        numbers[26] = new number(26, numbers[0]);
        numbers[3] = new number(3, numbers[26]);
        numbers[35] = new number(35, numbers[3]);
        numbers[12] = new number(12, numbers[35]);
        numbers[28] = new number(28, numbers[12]);
        numbers[7] = new number(7, numbers[28]);
        numbers[29] = new number(29, numbers[7]);
        numbers[18] = new number(18, numbers[29]);
        numbers[22] = new number(22, numbers[18]);
        numbers[9] = new number(9, numbers[22]);
        numbers[31] = new number(31, numbers[9]);
        numbers[14] = new number(14, numbers[31]);
        numbers[20] = new number(20, numbers[14]);
        numbers[1] = new number(1, numbers[20]);
        numbers[33] = new number(33, numbers[1]);
        numbers[16] = new number(16, numbers[33]);
        numbers[24] = new number(24, numbers[16]);
        numbers[5] = new number(5, numbers[24]);
        numbers[10] = new number(10, numbers[5]);
        numbers[23] = new number(23, numbers[10]);
        numbers[8] = new number(8, numbers[23]);
        numbers[30] = new number(30, numbers[8]);
        numbers[11] = new number(11, numbers[30]);
        numbers[36] = new number(36, numbers[11]);
        numbers[13] = new number(13, numbers[36]);
        numbers[27] = new number(27, numbers[13]);
        numbers[6] = new number(6, numbers[27]);
        numbers[34] = new number(34, numbers[6]);
        numbers[17] = new number(17, numbers[34]);
        numbers[25] = new number(25, numbers[17]);
        numbers[2] = new number(2, numbers[25]);
        numbers[21] = new number(21, numbers[2]);
        numbers[4] = new number(4, numbers[21]);
        numbers[19] = new number(19, numbers[4]);
        numbers[15] = new number(15, numbers[19]);
        numbers[32] = new number(32, numbers[15]);
        numbers[0].setNext(numbers[32]); // Set next for a0
        ArrayList<Double> clockBallSpin = new ArrayList<Double>();
        ArrayList<Double> counterClockBallSpin = new ArrayList<Double>();
        System.out.println("Enter initial ball direction 1 for clockwise, 0 for counter clockwise");
        int initialSpin = in.nextInt();
        System.out.println("Enter the number of initial location of the ball");
        int initialNum = in.nextInt();
        number previous = null;
        while(true){
            if(initialSpin>3 && initialSpin % 2 == 1 ){
                System.out.println("Guess Around "+ previous.getNext((int)(getAverage(clockBallSpin)*37)));
            } else if(initialSpin>3 && initialSpin % 2 == 0){
                System.out.println("Guess Around "+ previous.getNext((int)(getAverage(counterClockBallSpin)*37)));
            }
            System.out.println("Enter the location that the ball landed");
            int landedBall = in.nextInt();
            if(initialSpin %2 == 1 && initialSpin == 1 ){
                clockBallSpin.add(numbers[initialNum].getRotate(numbers[landedBall]));
                previous=numbers[landedBall];
                initialSpin++;
            } else if (initialSpin%2 == 0 && initialSpin == 0) {
                counterClockBallSpin.add(numbers[initialNum].getRotate(numbers[landedBall]));
                previous=numbers[landedBall];
                initialSpin= initialSpin+3;
            } else if (initialSpin % 2 == 1) {
                clockBallSpin.add(previous.getRotate(numbers[landedBall]));
                previous=numbers[landedBall];
                initialSpin++;
            } else{
                counterClockBallSpin.add(previous.getRotate(numbers[landedBall]));
                previous=numbers[landedBall];
                initialSpin++;
            }
            System.out.println("While spining clockwise, it spins on average: "+String.format("%.2f",getAverage(clockBallSpin)));
            System.out.println("While spining counter-clockwise, it spins on average: "+String.format("%.2f",getAverage(counterClockBallSpin)));
        }
    }

    public static double getAverage(ArrayList<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
}
