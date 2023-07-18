package toTest;

public class TestProgram {
    public static void main(String[] args) {
        String multiLength="3";
        String multiHeight="4";
        String multiWidth="5";
        String pieceVolume=null;

        if (multiLength.isEmpty() && multiHeight.isEmpty() && multiWidth.isEmpty() ||
                ((!multiLength.isEmpty() && !multiHeight.isEmpty() && !multiWidth.isEmpty()) &&
                        (pieceVolume==null || pieceVolume.isEmpty()) ))
        {
            System.out.println("if is printed");
        }
        else
            System.out.println("else is printed");

    }
}
