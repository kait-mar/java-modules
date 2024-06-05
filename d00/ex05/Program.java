import java.util.Scanner;

public class Program {

    String[] DAYS_OF_WEEK = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };
    static int students_size = 0;

    int getDayIndex(String dayString) {
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            if (DAYS_OF_WEEK[i].equals(dayString))
                return i;
        }
        return -1;
    }

    String getDayString(int index) {
        if (index >= 0 && index < DAYS_OF_WEEK.length) {
            return DAYS_OF_WEEK[index];
        } else
            return null;
    }

    int getStudentIndex(String[] students, String student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    int parseDayTime(String inputStram) {
        Scanner scanner = new Scanner(inputStram);
        int counter = 0;
        String regex = "\\S+";
        while (scanner.findInLine(regex) != null) {
            counter++;
        }
        scanner.close();

        if (counter != 2){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        Scanner sc = new Scanner(inputStram);
        sc.useDelimiter(" ");
        int time = Integer.parseInt(sc.next());
        int dayIndex = getDayIndex(sc.next());

        sc.close();
        return packIntegers(time, dayIndex);
    }



    int getAttendanceStatus(String input) {
        if (input.equals("HERE"))
            return 1;
        else if (input.equals("NOT_HERE"))
            return 0;
        return 0;
    }


    int countDayOccurancesInMonth(int[] schedule) {

        int counter = 0;

        for (int i = 1; i < 31; i++) {
            for (int j = 0; j < schedule.length; j++) {
                int T[] = unpackIntegers(schedule[j]);
                if (getDayString(i % 7).equals(getDayString(T[1])))
                    counter++;
            }
        }
        return counter;
    }

    /*
    ***********************************************************************************
    */
    String formatOutput(String[] output, int count) {
        // System.out.print(" ");
        String formattedOutput = "           ";
        for (int i = 0; i < count; i++) {
            formattedOutput += output[i];
            if (i < count - 1) {
                formattedOutput += "|";
            }
        }
        formattedOutput += "|";
        return formattedOutput;
    }

    /*
    ***********************************************************************************
    */

    public  String intToString(int num) {
        if (num == 0) {
            return "0";
        }
        String str = "";
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        while (num > 0) {
            char digit = (char) ('0' + num % 10);
            str = digit + str;
            num /= 10;
        }
        if (isNegative) {
            str = "-" + str;
        }
        return str;
    }

    /*
    ***********************************************************************************
    */

    public  void printTimetable(String[] students, int[] timeDatePairOfMonth, int[][] attendanceRecords,
            int count, String[] output) {
        if (count > 0) {
            String formattedOutput = formatOutput(output, count);
            System.out.println(formattedOutput);
        }

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%-10s", students[i]);

            for (int k = 0; k < timeDatePairOfMonth.length; k++) {
                int attendanceStatus = attendanceRecords[i][timeDatePairOfMonth[k]];

                if (attendanceStatus == -1)
                    System.out.printf("|          ");
                else if (attendanceStatus == 0)
                    System.out.printf("|        -1");
                else
                    System.out.printf("|         1");
            }

            System.out.println("|");
        }
    }

    /*
    ***********************************************************************************
    */

    void displayRecords(String[] students, int[][] attendanceRecords, int[] classSchedule) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter attendance records");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("."))
                break;
            Scanner sc = new Scanner(input);
            sc.useDelimiter(" ");
    
            int studentIndex = getStudentIndex(students, sc.next());
            int time = Integer.parseInt(sc.next());
            int date = Integer.parseInt(sc.next());
            int attendanceStatus = getAttendanceStatus(sc.next());
            int timeDatePair = packIntegers(time, date);
    
            attendanceRecords[studentIndex][timeDatePair] = attendanceStatus;
        }
        scanner.close();
        

        int size = countDayOccurancesInMonth(classSchedule);

        int count = 0;
        String[] output = new String[size];
        int[] timeDatePairOfMonth = new int[size]; // I already stored the timeDatePair in the attendanceRecords array,
                                                   // "John 4 9 HERE" so it gonna be easy to get the timeDatePair of the
                                                   // month for students printing later

        for (int i = 1; i < 31; i++) {
            for (int j = 0; j < classSchedule.length; j++) {
                int[] timeDayPair = unpackIntegers(classSchedule[j]);
                int time = timeDayPair[0];
                int day = timeDayPair[1];

                if (getDayString(i % 7).equals(getDayString(day))) {

                    String dayOfMonth = intToString(i);

                    String delimiter = (dayOfMonth.length() == 2) ? " " : "  ";

                    timeDatePairOfMonth[count] = packIntegers(time, i);
                    output[count] = time + ":00 " + getDayString(day) + delimiter + i;

                    count++;
                }
            }
        }

        System.out.println();
        printTimetable(students, timeDatePairOfMonth, attendanceRecords, count, output);
    }

    int packIntegers(int hour, int day) {
        return (hour << 5) | (day & 0x1F);

    }

    int[] unpackIntegers(int packedVal) {
        int[] unpackedInts = new int[2];

        unpackedInts[0] = (packedVal >> 5) & 0x07;
        unpackedInts[1] = packedVal & 0x1F;

        return unpackedInts;
    }

    public static void main(String[] args) {
        String[] _students = new String[10];
        int[] classScheduleTemp = new int[10];
        Program myProgram = new Program();


        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter students names");

        while (true) {
            name = scanner.nextLine();
            if (name.equals(".") || students_size >= 10)
                break ;
            _students[students_size++] = name;
        }
        String[] students = new String[students_size];
        for (int i = 0; i < students_size; i++)
            students[i] = _students[i];

        int numClasses = 0;
        System.out.println("Enter classes schedule");

        while (numClasses < 10) {
            String input = scanner.nextLine();
            if (input.equals(".")) {
                break;
            }
            int dayTime = myProgram.parseDayTime(input);
            classScheduleTemp[numClasses] = dayTime;
            numClasses++;
        }

        int[] classSchedule = new int[numClasses];
        for (int i = 0; i < numClasses; i++)
            classSchedule[i] = classScheduleTemp[i];
        myProgram.insertionSort(classSchedule);

        // int MAX_TIME_DAY_PAIR = myProgram.packIntegers(6, 31); // 223 // 6 * 31
        int[][] attendanceRecords = new int[students_size][6 * 31 /*MAX_TIME_DAY_PAIR*/];
        for (int i = 0; i < attendanceRecords.length; i++) {
            for (int j = 0; j < attendanceRecords[i].length; j++) {
                attendanceRecords[i][j] = -1;
            }
        }

        myProgram.displayRecords(students, attendanceRecords, classSchedule);
    }
}

// -> John
// -> Mike
// -> .
// -> 2 MO
// -> 4 WE
// -> .
// -> Mike 2 28 NOT_HERE
// -> John 4 9 HERE
// -> Mike 4 9 HERE
// -> .