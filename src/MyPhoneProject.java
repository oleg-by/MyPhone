public class MyPhoneProject {
    public static void main(String[] args) {
        CPU cpuApple = new CPU("Apple A15 Bionic", 3240);
        CPU cpuIpad = new CPU("Apple M1", 3200);
        CPU cpuQualcomm = new CPU("Qualcomm Snapdragon 8 Gen1", 3000);
        Battery batteryApple = new Battery(4325, "Li-ion");
        Battery batterySamsung = new Battery(5000, "Li-ion");
        Battery batteryIpad = new Battery(9720, "Li-ion");
        Battery batteryWatch = new Battery(1094, "Li-ion");
        Phone iphone = new Phone("phone", "Apple", "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", "white", 240, 291112233, "iOS" ,cpuApple, batteryApple);
        Phone samsung = new Phone("phone", "Samsung", "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", "blue", 229, 447775566, "Android", cpuQualcomm, batterySamsung);
        Tablet ipad = new Tablet("tablet", "Apple", "iPad Pro","280.6 x 214.9 x 6.4", "silver", 684, "iPadOS 15", cpuIpad, batteryIpad, (float)12.9);
        SmartWatch watch = new SmartWatch("smart watch", "Apple", "Watch Series 7", "45 x 38 x 10.7", "grey", 39,  (float)1.9, batteryWatch);
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());
        System.out.println(iphone.toString() + " HashCode = " + iphone.hashCode());
        System.out.println(samsung.toString() + " HashCode = " + samsung.hashCode());
        System.out.println(ipad.toString() + " HashCode = " + ipad.hashCode());
        System.out.println(watch.toString() + " HashCode = " + watch.hashCode());

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
