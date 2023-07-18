import java.nio.charset.StandardCharsets;

public class ChineseTest {
    public static void main(String[] args) {
     String s="李小狼";
     String s2="请司";
     String s3="語";
     String s4="语";
     String s5="a";
     char charToTest= '\u8BED';
     String s6 = String.valueOf(charToTest);
     String s7Trad="語";
        String s8Simplified="说";
        char cmed='说';
      /*  U+0000 - U+007F 1 Byte
        U+0080 - U+07FF 2 Bytes
        U+0800 - U+FFFF 3 Bytes
        U+10000 - U+10FFF 4 Bytes*/
     char ch='\u8BED';
        char ch2='\u8A9E';
        System.out.println(s);
        /*System.out.println(s.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(s2.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(s3.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(s4.getBytes(StandardCharsets.UTF_8).length);*/
        System.out.println(s5.getBytes(StandardCharsets.UTF_8).length);
/*        System.out.println(s6.getBytes(StandardCharsets.UTF_8).length);*/
        System.out.println(s7Trad.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(s8Simplified.getBytes(StandardCharsets.UTF_8).length);

        System.out.println(ch);
        //Character to unicode
        System.out.println("Mahesh "+String.format("\\u%04x", (int) cmed));
        Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
        System.out.println(block);

        System.out.println("------");
        System.out.println(ch2);
        Character.UnicodeBlock block2 = Character.UnicodeBlock.of(ch2);
        System.out.println(block2);


    }
}
