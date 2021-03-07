class Application {

    String name;

    void run(String[] args) {
        System.out.println(this.name);
        for (String a:
             args) {
            System.out.println(a);
        }
    }
}