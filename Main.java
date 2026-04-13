public class Main {

    // compress() method
    public String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }

        // Last character group
        compressed.append(input.charAt(input.length() - 1));
        compressed.append(count);

        return compressed.toString();
    }

    // decompress() method
    public String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder decompressed = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Build full number (handles counts like 10, 11, etc.)
            StringBuilder numStr = new StringBuilder();
            while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                i++;
                numStr.append(input.charAt(i));
            }

            int count = Integer.parseInt(numStr.toString());

            for (int j = 0; j < count; j++) {
                decompressed.append(ch);
            }
        }

        return decompressed.toString();
    }

    // displayResults() method
    public void displayResults(String original) {
        String compressed = compress(original);
        String decompressed = decompress(compressed);

        System.out.println("==============================");
        System.out.println(" File Compression Simulator   ");
        System.out.println("==============================");
        System.out.println("Original String   : " + original);
        System.out.println("Compressed String : " + compressed);
        System.out.println("Decompressed      : " + decompressed);
        System.out.println("Original Length   : " + original.length());
        System.out.println("Compressed Length : " + compressed.length());
        System.out.println("Match             : " + original.equals(decompressed));
        System.out.println("==============================");
    }

    // Main method
    public static void main(String[] args) {
        Main c = new Main();   // ✅ FIX HERE

        c.displayResults("AAABBBCCDDDDEE");
        System.out.println();
        c.displayResults("AABBCCDD");
        System.out.println();
        c.displayResults("AAAAAAAAAA");
    }
}