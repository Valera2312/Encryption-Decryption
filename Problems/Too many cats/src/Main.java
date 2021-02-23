class Cat {

    public String name;
    public int age;
    public static int counter = 0;

    public Cat(String name, int age) {
        // implement the constructor
        // do not forget to check the number of cats
        this.age = age;
        this.name = name;
        counter++;
        if(counter > 5){
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
        }
    }
