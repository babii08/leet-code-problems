/** Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
*/


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> output = new ArrayList<String>();
        int wordNr = 0;
        final int NR_OF_INPUT_WORDS = words.length;
        while (wordNr < NR_OF_INPUT_WORDS) {
            int index=0;
            StringBuilder row = new StringBuilder();
            int[] endOfWords = new int[NR_OF_INPUT_WORDS];
            while(wordNr < NR_OF_INPUT_WORDS && words[wordNr].length() + row.length() <= maxWidth) {
                row.append(words[wordNr]);
                endOfWords[index] = row.length();
                row.append(" ");
                index++;
                wordNr++;
            }
            row.deleteCharAt(row.length()-1);
            if ((wordNr == NR_OF_INPUT_WORDS) || (index == 1)) {
                row.append(generateSpaces(maxWidth - endOfWords[index-1]));
            }
            else if (index == 2) {
                row.insert(endOfWords[0], generateSpaces(maxWidth - endOfWords[1]));
            }
            else {
                int nrOfSpaces = maxWidth - endOfWords[index-1];
                if (nrOfSpaces < index - 1) {
                    row = insertSpaces(row, nrOfSpaces, endOfWords);
                }
                else {
                    int avgSpaces = nrOfSpaces / (index-1);
                    for (int i=index-2;i>=1;i--) {
                        row.insert(endOfWords[i], generateSpaces(avgSpaces));
                    }
                    if (nrOfSpaces % (index-1) != 0) {
                        row.insert(endOfWords[0], generateSpaces(avgSpaces + 1));
                    }
                    else {
                        row.insert(endOfWords[0], generateSpaces(avgSpaces));
                    }
                }
            }
            output.add(row.toString());
        }
       return output;
    }
    
    public StringBuilder insertSpaces(StringBuilder row, int spacesToInsert, int[] endOfWords) {
        int k = 0;
        while (spacesToInsert > 0) {
            row.insert(endOfWords[k++] + k, generateSpaces(1));    
            spacesToInsert--;
        }
        return row;
    }
    
    public String generateSpaces(int nrOfSpaces) {
        StringBuilder space = new StringBuilder();
        for(int i=0; i<nrOfSpaces; i++) {
            space.append(" ");
        }
        return space.toString();
    }
}
