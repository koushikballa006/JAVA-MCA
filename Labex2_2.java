public class Labex2_2 {
    public static void main(String args[])
    {
        StringBuffer stringBuffer = new StringBuffer("koushik, ");
    
        stringBuffer.append("balla");
        System.out.println("Append(): " + stringBuffer);

        stringBuffer.insert(3,"mca ");
        System.out.println("After insert(): " + stringBuffer);

        
        stringBuffer.replace(7, 11, "bangalore");
        System.out.println("After replace(): " + stringBuffer);

        
        stringBuffer.delete(7, 18);
        System.out.println("After delete(): " + stringBuffer);

        
        char ch = stringBuffer.charAt(0);
        System.out.println("Character at index 0: " + ch);

        
        stringBuffer.setCharAt(0, 'H');
        System.out.println("After setCharAt(): " + stringBuffer);

        
        int length = stringBuffer.length();
        System.out.println("Length of the StringBuffer: " + length);

        
        int capacity = stringBuffer.capacity();
        System.out.println("Capacity of the StringBuffer: " + capacity);

        
        stringBuffer.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity(): " + stringBuffer.capacity());

        
        String str = stringBuffer.toString();
        System.out.println("String representation: " + str);

        
        String subStr1 = stringBuffer.substring(7);
        System.out.println("Substring from index 7: " + subStr1);

        
        String subStr2 = stringBuffer.substring(0, 5);
        System.out.println("Substring from index 0 to 5: " + subStr2);
    }
}
