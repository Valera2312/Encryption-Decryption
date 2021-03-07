import java.nio.charset.StandardCharsets;

class AsciiCharSequence implements java.lang.CharSequence {

    byte[] b;
    public AsciiCharSequence (byte[] b) {
        this.b = b;
    }

    @Override
    public int length () {
        return this.b.length;
    }

    @Override
    public char charAt (int index) {
        return (char) this.b[index];
    }

    @Override
    public CharSequence subSequence (int start, int end) {

        byte[] CharSequence =  java.util.Arrays.copyOfRange(b, start, end);
        return new  AsciiCharSequence(CharSequence);

    }
    @Override
    public String toString () {
        return new String(this.b, StandardCharsets.UTF_8);
    }
}