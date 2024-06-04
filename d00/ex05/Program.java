import java.util.Scanner;

// class Classes{
//      nt time;
//      tring   week_day;

//     public void setTime(int _time) { time = _time; }
//     public void setDay(String _day) { week_day = _day; }
//     public int getTime() { return time; }
//     public String getWeekDay() { return week_day; }
// }



//  class Attendance {
//     String student;
//     int     class_time;
//     int     date;
//     int     is_present;
    
//     public void setStudent(String _student) { student = _student; }
//     public void setClassTime(int _time) { class_time = _time; }
//     public void setDate(int _date) { date = _date; }
//     public void setIsPresent(int _is_present) { is_present = _is_present; }
    
//     public String getStudent(String _student) { return student; }
//     public int getClassTime(int _time) { return class_time; }
//     public int getDate(int _date) { return date ; }
//     public int getIsPresent(int _is_present) { return is_present; }
// }

// public class Program {
//      tring[]    students = new String[10];
//      lasses[]    classes = new classes[10];
//      ttendance[]    attendance = new Attendance[100];

//     public  void main() {
//         Scanner scanner = new Scanner(System.in);
//         int i = 0;
//         while ((String name = scanner.nextLine()) != ".") {
//             students[i++] = name;
//         }
//         i = 0;
//         while (1) {
//             int time = scanner.nextInt();
//             String week_day = scanner.nextLine();
//             if (week_day == ".")
//                 break;
//             classes[i].setDate(week_day);
//             classes[i++].setTime(time);
//         }
//         i = 0;
//         while (1) {
//             String name = scanner.next();
//             if (name == ".")
//                 break ;
//             attendance[i].setStudent(name);
//             attendance[i].setClassTime(scanner.nextInt());
//             attendance[i].setDate(scanner.nextInt());
//             String is_present = scanner.nextInt();
//             attendance[i++].setIsPresent(is_present == "HERE" ? 1 : -1);
//         }
//     }
// }
// > Mike 2 28 NOT_HERE
// -> John 4 9 HERE
// -> Mike 4 9 HERE

/* 
class Student {
     tring name;
     nt[] attendance; // Using integers to represent attendance: 1 for HERE, -1 for NOT_HERE

    public Student(String name) {
        this.name = name;
        this.attendance = new int[10];
        for (int i = 0; i < attendance.length; i++) {
            attendance[i] = 0; // Initialize all attendance as 0
        }
    }

    public String getName() {
        return name;
    }

    public void recordAttendance(int classIndex, String status) {
        if (classIndex >= 0 && classIndex < attendance.length) {
            if (status.equals("HERE")) {
                attendance[classIndex] = 1;
            } else if (status.equals("NOT_HERE")) {
                attendance[classIndex] = -1;
            }
        }
    }

    public int getAttendance(int classIndex) {
        if (classIndex >= 0 && classIndex < attendance.length) {
            return attendance[classIndex];
        }
        return 0; // Return 0 if classIndex is out of bounds
    }
}

class Timetable {
     tring[] classes;
     tudent[] students;
     nt classCount;
     nt studentCount;

    public Timetable() {
        this.classes = new String[10];
        this.students = new Student[10];
        this.classCount = 0;
        this.studentCount = 0;
    }

    public boolean addStudent(String name) {
        if (studentCount >= 10 || name.length() > 10) {
            return false;
        }
        students[studentCount] = new Student(name);
        studentCount++;
        return true;
    }

    public boolean addClass(String time, String day) {
        if (classCount >= 10) {
            return false;
        }
        String classTime = time + " " + day;
        classes[classCount] = classTime;
        classCount++;
        return true;
    }

    public int getClassIndex(String time, String day) {
        String classTime = time + " " + day;
        for (int i = 0; i < classCount; i++) {
            if (classes[i].equals(classTime)) {
                return i;
            }
        }
        return -1;
    }

    public void recordAttendance(String studentName, String time, String date, String status) {
        String classWithDate = time + " " + date;
        for (int i = 0; i < classCount; i++) {
            if (classes[i].contains(classWithDate)) {
                for (int j = 0; j < studentCount; j++) {
                    if (students[j].getName().equals(studentName)) {
                        students[j].recordAttendance(i, status);
                        return;
                    }
                }
            }
        }
    }

    public void displayTimetable() {
        for (int i = 0; i < classCount; i++) {
            System.out.print(classes[i] + "|");
        }
        System.out.println();

        for (int i = 0; i < studentCount; i++) {
            System.out.print(students[i].getName() + " |");
            for (int j = 0; j < classCount; j++) {
                System.out.print(students[i].getAttendance(j) + "|");
            }
            System.out.println();
        }
    }
}

public class Program {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timetable timetable = new Timetable();

        // Creating list of students
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals(".")) {
                break;
            }
            timetable.addStudent(input);
        }

        // Populating timetable with classes
        System.out.println("->");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals(".")) {
                break;
            }
            String[] parts = input.split(" ");
            timetable.addClass(parts[0], parts[1]);
        }

        // Recording attendance
        System.out.println("->");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals(".")) {
                break;
            }
            String[] parts = input.split(" ");
            timetable.recordAttendance(parts[0], parts[1], parts[2], parts[3]);
        }

        // Displaying the timetable
        System.out.println("->");
        timetable.displayTimetable();
    }
}*/

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

import java.util.Scanner;

public class Program {

    String[] DAYS_OF_WEEK = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };
    int students_size = 0;

    /*
    ***********************************************************************************
    */



    /*
    ***********************************************************************************
    */

    int getDayIndex(String dayString) {
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            if (DAYS_OF_WEEK[i].equals(dayString))
                return i;
        }
        return -1;
    }

    /*
    ***********************************************************************************
    */

    String getDayString(int index) {
        if (index >= 0 && index < DAYS_OF_WEEK.length) {
            return DAYS_OF_WEEK[index];
        } else
            return null;
    }

    /*
    ***********************************************************************************
    */


    /*
    ***********************************************************************************
    */

    int getStudentIndex(String[] studentNames, String student) {
        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i] != null && studentNames[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    /*
    ***********************************************************************************
    */

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

    /*
    ***********************************************************************************
    */

    boolean hasSpace(String str) {
        if (str == null) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == ' ')
                return true;
        }

        return false;
    }

    /*
    ***********************************************************************************
    */

    int getStudentsNames(String[] T1, String[] T2, int size) {

        if (size == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter students names");

            for (int i = 0; i < 10; i++) {
                String name = scanner.nextLine();
                if (name.equals("."))
                    break;

                if (name.length() > 10 || hasSpace(name)){
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                T1[i] = name;
                size++;
            }
        } else
            for (int i = 0; i < size; i++)
                T2[i] = T1[i];

        return size;
    }

    /*
    ***********************************************************************************
    */

    int isDigit(String str) {
        if (str == null){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 48 || chars[i] > 57) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
        }
        return Integer.parseInt(str);
    }

    /*
    ***********************************************************************************
    */

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
        int time = isDigit(sc.next());
        int dayIndex = getDayIndex(sc.next());

        if (!isInRange(time, 1, 6) || dayIndex == -1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        sc.close();
        return packIntegers(time, dayIndex);
    }

    /*
     ***************************** FUNC NO LONGER USED******************************************************
     */
    void checkLimitClassPerWeek(int[] classSchedule) {
        int i = 0;
        while (i < classSchedule.length && classSchedule[i] != -1)
            i++;
        if (i > 10){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int[] days = new int[7];
        for (int j = 0; j < classSchedule.length; j++) {
            if (classSchedule[j] == -1)
                break;
            int T[] = unpackIntegers(classSchedule[j]);
            days[T[1]]++;
        }
        int countClass = 0;
        for (int j = 0; j < days.length; j++) {
            // if (days[j] > 10)
            // terminate();
            countClass += days[j];
        }
        System.out.println("countClass: " + countClass);
        if (countClass > 10){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }
    /*
    ***********************************************************************************
    */

    int getClassSchedule(int[] T1, int[] T2, int numClasses) {

        if (numClasses == 0) {
            System.out.println("Enter class schedule");
            Scanner scanner = new Scanner(System.in);

            while (numClasses < 10) {
                String input = scanner.nextLine();
                if (input.equals(".")) {
                    break;
                }
                int dayTime = parseDayTime(input);
                if (isDuplicate(T1, dayTime)){
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                T1[numClasses] = dayTime;
                numClasses++;
            }
        } else
            for (int i = 0; i < numClasses; i++)
                T2[i] = T1[i];
        // checkLimitClassPerWeek(classSchedule); // no need to check this, the while
        // loop above already does
        // scanner.close(); // dont close the scanner, we still need it next
        return numClasses;
    }

    /*
    ***********************************************************************************
    */

    boolean isDuplicate(int[] classSchedule, int dayTime) {
        for (int i = 0; i < classSchedule.length; i++) {
            if (classSchedule[i] == dayTime)
                return true;
        }
        return false;
    }

    /*
    ***********************************************************************************
    */

    int getAttendanceStatus(String input) {
        if (input == null)
            return 0;
        if (input.equals("HERE"))
            return 1;
        else if (input.equals("NOT_HERE"))
            return 0;
        else{
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        return 0;
    }

    /*
    ***********************************************************************************
    */

    boolean isInRange(int num, int lowerBound, int upperBound) {
        return (num >= lowerBound && num <= upperBound);
    }

    /*
    ***********************************************************************************
    */

    void checkIfTimeExistInSchedule(int[] classSchedule, int time) {
        for (int i = 0; i < classSchedule.length; i++) {
            int T[] = unpackIntegers(classSchedule[i]);
            if (T[0] == time)
                return;
        }
        System.err.println("IllegalArgument");
        System.exit(-1);
    }

    /*
    ***********************************************************************************
    */

    void checkIfDateCorrespondToDayInSchedule(int[] classSchedule, int date) {

        for (int i = 0; i < classSchedule.length; i++) {
            int T[] = unpackIntegers(classSchedule[i]);
            if (getDayString(T[1]).equals(getDayString(date % 7)))
                return;
        }
        System.err.println("IllegalArgument");
        System.exit(-1);
    }

    /*
    ***********************************************************************************
    */

    void parseAttendanceRecords(int[][] attendanceRecords, String[] studentNames, int[] classSchedule,
            String inputStram) {

        Scanner scanner = new Scanner(inputStram);
        scanner.useDelimiter(" ");

        int counter = 0;
        String regex = "\\S+";
        while (scanner.findInLine(regex) != null)
            counter++;

        scanner.close();

        if (counter != 4)
        System.err.println("IllegalArgument");
        System.exit(-1);

        Scanner sc = new Scanner(inputStram);
        sc.useDelimiter(" ");

        int studentIndex = getStudentIndex(studentNames, sc.next());
        int time = isDigit(sc.next());
        int date = isDigit(sc.next());
        int attendanceStatus = getAttendanceStatus(sc.next());
        int timeDatePair = packIntegers(time, date);

        checkIfTimeExistInSchedule(classSchedule, time);
        checkIfDateCorrespondToDayInSchedule(classSchedule, date);
        if (!isInRange(date, 1, 31) || studentIndex == -1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        sc.close();

        attendanceRecords[studentIndex][timeDatePair] = attendanceStatus;
    }

    /*
    ***********************************************************************************
    */

    void getAttendanceRecords(int[][] attendanceRecords, String[] studentNames, int[] classSchedule) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter attendance records");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("."))
                break;
            parseAttendanceRecords(attendanceRecords, studentNames, classSchedule, input);
        }
        scanner.close(); // close the scanner, we don't need it anymore
    }

    /*
    ***********************************************************************************
    */

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

    public  void printTimetable(String[] studentNames, int[] timeDatePairOfMonth, int[][] attendanceRecords,
            int count, String[] output) {
        if (count > 0) {
            String formattedOutput = formatOutput(output, count);
            System.out.println(formattedOutput);
        }

        for (int i = 0; i < studentNames.length; i++) {
            System.out.printf("%-10s", studentNames[i]);

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

    void displayRecords(String[] studentNames, int[][] attendanceRecords, int[] classSchedule) {

        getAttendanceRecords(attendanceRecords, studentNames, classSchedule);

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

        printTimetable(studentNames, timeDatePairOfMonth, attendanceRecords, count, output);
    }

    /*
    ***********************************************************************************
    */

    int packIntegers(int hour, int day) {
        return (hour << 5) | (day & 0x1F);

    }

    /*
    ***********************************************************************************
    */

    int[] unpackIntegers(int packedVal) {
        int[] unpackedInts = new int[2];

        unpackedInts[0] = (packedVal >> 5) & 0x07;
        unpackedInts[1] = packedVal & 0x1F;

        return unpackedInts;
    }

    public static void main(String[] args) {
        String[] students = new String[10];
        int[] classScheduleTemp = new int[10];
        Program myProgram = new Program();


        int size = 0;
        // size = myProgram.getStudentsNames(students, null, 0);
        int NBR_STUD = size;
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter students names");

        while ((name = scanner.nextLine()) != ".") {
            students[myProgram.students_size++] = name;
        }
        int i = 0;
        int numClasses = 0;
        System.out.println("Enter classes schedule");

        // String[] studentNames = new String[size];
        // myProgram.getStudentsNames(students, studentNames, size);

        while (numClasses < 10) {
            String input = scanner.nextLine();
            if (input.equals(".")) {
                break;
            }
            int dayTime = myProgram.parseDayTime(input);
            // if (isDuplicate(T1, dayTime)){
            //     System.err.println("IllegalArgument");
            //     System.exit(-1);
            // }
            T1[numClasses] = dayTime;
            numClasses++;
        }
        size = 0;
        size = myProgram.getClassSchedule(classScheduleTemp, null, 0);

        int[] classSchedule = new int[size];
        myProgram.getClassSchedule(classScheduleTemp, classSchedule, size);

        myProgram.insertionSort(classSchedule);

        int MAX_TIME_DAY_PAIR = myProgram.packIntegers(6, 31); // 223 // 6 * 31
        int[][] attendanceRecords = new int[NBR_STUD][MAX_TIME_DAY_PAIR];
        for (int i = 0; i < attendanceRecords.length; i++) {
            for (int j = 0; j < attendanceRecords[i].length; j++) {
                attendanceRecords[i][j] = -1;
            }
        }

        myProgram.displayRecords(studentNames, attendanceRecords, classSchedule);
    }
}

// > Mike 2 28 NOT_HERE
// -> John 4 9 HERE
// -> Mike 4 9 HERE