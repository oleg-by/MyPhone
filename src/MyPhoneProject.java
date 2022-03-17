// Task #4 by Oleg Bukatich (Minsk, BY)

public class MyPhoneProject {
    public static void main(String[] args) {
        CPU cpuApple = new CPU("Apple A15 Bionic", 3240);
        CPU cpuQualcomm = new CPU("Qualcomm Snapdragon 8 Gen1", 3000);
        Battery batteryApple = new Battery(4325, "Li-ion");
        Battery batterySamsung = new Battery(5000, "Li-ion");
        Phone iphone = new Phone("Apple", "Iphone 13 PRO MAX", 291112233, "iOS" ,cpuApple, batteryApple);
        Phone samsung = new Phone("Samsung", "Galaxy S22 Ultra", 447775566, "Android", cpuQualcomm, batterySamsung);
        iphone.setName("phone");
        iphone.setDimensions("160.8 x 78.1 x 7.7");
        iphone.setColor("white");
        iphone.setWeight(240);
        samsung.setName("phone");
        samsung.setDimensions("163.3 x 77.9 x 8.9");
        samsung.setColor("blue");
        samsung.setWeight(229);
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());
        iphone.printInfo();
        samsung.printInfo();
        iphone.calling(mary);
        samsung.calling(172020327);
        iphone.sendMessage("Hello Mary! How are you!", mary);
        samsung.sendMessage("Hi Alex! I'm fine, and you?", alex);
        iphone.charging(2200);
        samsung.charging(2200);
    }
}
