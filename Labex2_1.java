import java.util.Arrays;

public class Labex2_1 {

     public static void main(String args[])
     {
        String text = "We realizes that while our workers were thriving, the " +
                "surrounding villages were still suffering. It became our goal to uplift their " +
                "quality of life as well. I remember seeing a family of 4 on a motorbike in the " +
                "heavy Bombay rain — I knew I wanted to do more for these families who were " +
                "risking their lives for lack of an alternative, The alternative mentioned here " +
                "is the Tata Nano, which soon after came as the world’s cheapest car on retail " +
                "at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a " +
                "recent post by Humans of Bombay which formed the basis of his decision to come " +
                "up with a car like Tata Nano.";


                System.out.println("charAt(5): "+ text.charAt(5));
                System.out.println("compareto : "+ text.compareTo(text));
                System.out.println("concat(\" - Support the villages.\"): " + text.concat(" - Support the villages."));
                System.out.println("contains(\"Tata Nano\"): " + text.contains("Tata Nano"));
                System.out.println("endsWith(\".\"): " + text.endsWith("."));
                System.out.println("equals(\"Another String\"): " + text.equals("Another String"));
                System.out.println("equalsIgnoreCase(\"we realizes\"): " + text.equalsIgnoreCase("we realizes"));
                System.out.println("length(): " + text.length());
                System.out.println("replace(\"workers\", \"employees\"): " + text.replace("workers", "employees"));
                System.out.println("substring(50, 100): " + text.substring(50, 100));
                System.out.println("toLowerCase(): " + text.toLowerCase());
                System.out.println("toUpperCase(): " + text.toUpperCase());
                System.out.println("trim(): " + text.trim());
                System.out.println("valueOf(123): " + String.valueOf(123));
                System.out.println("format(): " + String.format("Formatted String: %s", text));
                byte[] bytes = text.getBytes();
                System.out.println("getBytes(): " + new String(bytes));
                char[] chars = new char[50];
                text.getChars(10, 60, chars, 0);
                System.out.println("getChars(): " + new String(chars));
                System.out.println("indexOf(\"Tata\"): " + text.indexOf("Tata"));
                System.out.println("intern(): " + text.intern());
                System.out.println("isEmpty(): " + text.isEmpty());
                String[] words = text.split(" ");
                System.out.println("split(): " + Arrays.toString(words));
                System.out.println("join(): " + String.join("-", words));
                System.out.println("lastIndexOf(\"the\"): " + text.lastIndexOf("the"));
                System.out.println("replaceFirst(\"the\", \"THE\"): " + text.replaceFirst("the", "THE"));
                System.out.println("replaceAll(\"the\", \"THE\"): " + text.replaceAll("the", "THE"));
                System.out.println("startsWith(\"We\"): " + text.startsWith("We"));
                System.out.println("substring(20): " + text.substring(20));
                
     }

    
   
}





  
        