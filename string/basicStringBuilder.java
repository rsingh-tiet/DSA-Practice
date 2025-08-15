public class basicStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);
        sb.setCharAt(3, 'v');
        sb.insert(5, "mkmk");
        System.out.println("length by sb.length()->"+sb.length()+" getting char by\nsb.charAt()->"
        +sb.charAt(2)+"🍯🎶🪸 we can change a thing by sb.setCharAt(,)->"
        +sb.subSequence(0, 5)+"\ninsert char by .insert(,)"+sb);
    }}
