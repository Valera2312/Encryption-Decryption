class AsciiCharSequence implements java.lang.CharSequence {
    byte[] b;
    public AsciiCharSequence (byte[] b) {
        this.b = b;
    }
    int lenght(){
        return this.b.length;
    }
    char charAt(int index){
        return char b[index];
    }
    CharSequence subSequence(int start,int end) {
        byte[] charSequence;
        int count = 0;
        for(int i = start; i < end; i++) {
            count++;
            charSequence[count] = b[i];
        }
        return new  AsciiCharSequence(charSequence);
        }
    String toString(byte bytes) {

        return new String(bytes,StandardCharsets.UTF_8);
    }



}