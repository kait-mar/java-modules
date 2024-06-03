import java.util.Scanner;

// class Classes{
//     private int time;
//     private String   week_day;

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
//     private String[]    students = new String[10];
//     private Classes[]    classes = new classes[10];
//     private Attendance[]    attendance = new Attendance[100];

//     public static void main() {
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


class Student {
    private String name;
    private int[] attendance; // Using integers to represent attendance: 1 for HERE, -1 for NOT_HERE

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
    private String[] classes;
    private Student[] students;
    private int classCount;
    private int studentCount;

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
    public static void main(String[] args) {
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
