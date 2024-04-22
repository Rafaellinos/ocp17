

 class RomanToInteger {

    public int romanToInt(String s) {
        
        char[] charArray = s.toCharArray();
        int total = 0;
        // I, X, C

        char currentChar = charArray[0];
        boolean isFirstIndex = false;
        for (int i = 0; i < charArray.length; i++) {
            
            currentChar = charArray[i];
            
            if ('I' == currentChar) {
                total += 1; 
            }
            if ('V' == currentChar) {
                total += 5;
                if (isFirstIndex && charArray[i-1] == 'I') {
                  total -= 2;
                  continue;
                }
            }
            if ('X' == currentChar) {
                total += 10;
                if (isFirstIndex && charArray[i-1] == 'I') {
                    total -= 2;
                    continue;
                }
            }
            if ('L' == currentChar) {
                total += 50;
                if (isFirstIndex && charArray[i-1] == 'X') {
                  total -= 20;
                  continue;
                }
            }
            if ('C' == currentChar) {
                total += 100;
                if (isFirstIndex && charArray[i-1] == 'X') {
                  total -= 20;
                  continue;
                } 
            }
            if ('D' == currentChar) {
                total += 500;
                if (isFirstIndex && charArray[i-1] == 'C') {
                    total -= 200;
                    continue;
                }
            }
            if ('M' == currentChar) {
                total += 1000;
                if (isFirstIndex && charArray[i-1] == 'C') {
                  total -= 200;
                }
            }
            isFirstIndex = true;
        }
         return total;
    }

   public static void main(String... args) {
     var r = new RomanToInteger();
     System.out.println(r.romanToInt(args[0]));
   }
}

