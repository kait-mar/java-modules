public class Program {
    private int number;

    public void setNumber(int num) {
        this.number = num;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += this.number % 10;
            this.number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Program myProgram = new Program();
        myProgram.setNumber(479598);
        System.out.println(myProgram.sum());
    }
}