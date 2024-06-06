public class Program {
    private static int number;

    private static int sum() {
        int sum = 0;

        sum += number % 10;
        number /= 10;

        sum += number % 10;
        number /= 10;

        sum += number % 10;
        number /= 10;

        sum += number % 10;
        number /= 10;

        sum += number % 10;
        number /= 10;

        sum += number % 10;
        number /= 10;

        return sum;
    }

    public static void main(String[] args) {
        number = 479596;
        System.out.println(sum());
    }
}
