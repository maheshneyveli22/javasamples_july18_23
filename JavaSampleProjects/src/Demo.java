public class Demo {
    public static void main(String []args) {
        char ch = '\u5639';
        char ch2='\u3401';
        System.out.println(ch);
        System.out.println(ch2);


        Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
        System.out.println(block);
        System.out.println(Character.UnicodeBlock.of(' '));
        System.out.println(Character.UnicodeBlock.of('\u21ac'));
        System.out.println(Character.UnicodeBlock.of(1565));
    }
}