public class Java8LambdaRunnable {
    public static void main(String[] args) {
        // JAVA 8: FUNÇÕES LAMBDA

        //Função sem lambda
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Olá mundo!");
            }
        }).run();

        //Função com lambda
        new Thread(() -> System.out.println("Olá mundo!")).run();

        // SAM - Single Abstract Method
        // Qualquer interface que tenha apenas 1 método abstrato.
    }
}
