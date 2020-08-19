package java_professional.lesson_1.Exercise_3;

public class TestMain {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();

        System.out.println("\nApple and orange boxes just created");
        System.out.println("Weigth of apple box 1 is " + appleBox1.getWeight());
        System.out.println("Weigth of apple box 2 is " + appleBox2.getWeight());

        System.out.println("Weigth of orange box 1 is " + orangeBox1.getWeight());
        System.out.println("Weigth of orange box 2 is " + orangeBox2.getWeight());

        for (int i = 0; i < 5; ++i) {
            appleBox1.add(new Apple());
            appleBox2.add(new Apple());
            orangeBox1.add(new Orange());
            orangeBox2.add(new Orange());
        }

        System.out.println("\nApple and orange boxes filled");
        System.out.println("Weigth of apple box 1 is " + appleBox1.getWeight());
        System.out.println("Weigth of apple box 2 is " + appleBox2.getWeight());

        System.out.println("Weigth of orange box 1 is " + orangeBox1.getWeight());
        System.out.println("Weigth of orange box 2 is " + orangeBox2.getWeight());

        System.out.println("apple box 1 and 2 have equal weights " + appleBox1.compare(appleBox2));
        System.out.println("orange box 1 and 2 have equal weights " + orangeBox1.compare(orangeBox2));

        System.out.println("apple box 1 and orange box 1 have equal weights " + appleBox1.compare(orangeBox1));

        System.out.println("\nPour apple box 1 to apple box 2");
        appleBox1.pour(appleBox2);
        System.out.println("Weigth of apple box 1 is " + appleBox1.getWeight());
        System.out.println("Weigth of apple box 2 is " + appleBox2.getWeight());
        System.out.println("apple box 1 and 2 have equal weights " + appleBox1.compare(appleBox2));

//        Ошибка компиляции
//        appleBox1.pour(orangeBox2);
    }
}
