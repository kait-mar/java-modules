package ex00;

// import ex00.FileProcess;

class Program {
    public static void main(String[] args) {
        try {
            FileProcess file = new FileProcess();
            file.lunch();
        } catch (Exception e) {
            // System.out.println(e);
            e.printStackTrace();

        }
    }
}