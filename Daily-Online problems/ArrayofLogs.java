class Solution {
    
      class letterLogComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            // Values are the string after the first whitespace ' '
            String aValue = a.substring(a.indexOf(' '), a.length());
            String bValue = b.substring(b.indexOf(' '), b.length());

            // Keys are the string before whitespace ' '
            String aKey = a.substring(0, a.indexOf(' '));
            String bKey = b.substring(0, b.indexOf(' '));

            int comp = aValue.compareToIgnoreCase(bValue);

            // When both values are same, we need to compare the alphanumeric digits.
            return (comp == 0) ? aKey.compareToIgnoreCase(bKey) : comp;
        }
    }

    public String[] reorderLogFiles(String[] logs)
    {
        List<String> digitLog = new ArrayList<>();
        List<String> letterLog = new ArrayList<>();

        for (String s : logs)
        {
            // Take the first character after the fist whitespace.
            char key = s.substring(s.indexOf(' ') + 1, s.indexOf(' ') + 2).charAt(0);

            // If that character is digit, then add it to the digitLog list else letterLog list.
            if (Character.isDigit(key))
            {
                digitLog.add(s);
            }
            else
            {
                letterLog.add(s);
            }
        }

        // Sort the letter log based on the conditions in the problem.
        Collections.sort(letterLog, new letterLogComparator());

        // Append the digitLog to the end of letter log in the same order of the question.
        letterLog.addAll(digitLog);

        return letterLog.toArray(new String[0]);
    }
    
}