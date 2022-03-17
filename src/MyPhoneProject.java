// Task #4 by Oleg Bukatich (Minsk, BY)

public class MyPhoneProject {
    public static void main(String[] args) {
        CPU cpuApple = new CPU("Apple A15 Bionic", 3240);
        CPU cpuIpad = new CPU("Apple M1", 3200);
        CPU cpuQualcomm = new CPU("Qualcomm Snapdragon 8 Gen1", 3000);
        Battery batteryApple = new Battery(4325, "Li-ion");
        Battery batterySamsung = new Battery(5000, "Li-ion");
        Battery batteryIpad = new Battery(9720, "Li-ion");
        Battery batteryWatch = new Battery(1094, "Li-ion");
        Phone iphone = new Phone("phone", "160.8 x 78.1 x 7.7", "white", 240, "Apple", "Iphone 13 PRO MAX", 291112233, "iOS" ,cpuApple, batteryApple);
        Phone samsung = new Phone("phone", "163.3 x 77.9 x 8.9", "blue", 229, "Samsung", "Galaxy S22 Ultra", 447775566, "Android", cpuQualcomm, batterySamsung);
        Tablet ipad = new Tablet("tablet", "280.6 x 214.9 x 6.4", "silver", 684, "Apple", "iPad Pro", "iPadOS 15", cpuIpad, batteryIpad, (float)12.9);
        SmartWatch watch = new SmartWatch("smart watch", "45 x 38 x 10.7", "grey", 39, "Apple", "Watch Series 7", (float)1.9, batteryWatch);
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());
        System.out.println(iphone.toString() + " HashCode = " + iphone.hashCode());
        System.out.println(samsung.toString() + " HashCode = " + samsung.hashCode());
        System.out.println(ipad.toString() + " HashCode = " + ipad.hashCode());
        System.out.println(watch.toString() + " HashCode = " + watch.hashCode());

//        iphone.printInfo();
//        samsung.printInfo();
//        ipad.printInfo();
//        watch.printInfo();
//        iphone.calling(mary);
//        samsung.calling(172020327);
//        iphone.sendMessage("Hello Mary! How are you!", mary);
//        samsung.sendMessage("Hi Alex! I'm fine, and you?", alex);
//        iphone.charging(2200);
//        samsung.charging(2200);
//        ipad.charging(2200);
//        watch.charging(2200);
    }
}
