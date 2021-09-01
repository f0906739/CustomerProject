public final class ValidAdressCalculator {
    private final Address address;

    private String firstNums;
    private boolean passedFirstNums;
    private String word;
    private static final char SEPARATOR = ' ';

    private boolean passedFirstLetterOfWord;
    private int indexAtFirstLetterOfWord;

    public ValidAdressCalculator(Address address){
        this.address = address;
        this.word = "";
        this.passedFirstNums = false;
        this.passedFirstLetterOfWord = false;
    }

    public boolean compute() {
        for(int i = 0; i<address.getAddress().length(); i++){
            if (!passedFirstNums && !charIsSeparator(i)) continue;

            if (!passedFirstNums){
                getFirstNums(i);
                if (!firstNumsValid())
                    return false;
                continue;
            }

            if(!passedFirstLetterOfWord){
                indexAtFirstLetterOfWord = i;
                passedFirstLetterOfWord = true;
                continue;
            }

            if (charIsLastValue(i)) {
                getWord(i + 1);
                return wordValid();
            }

            if (!charIsSeparator(i)) continue;

            getWord(i);
            if(!wordValid())
                return false;
            passedFirstLetterOfWord = false;
        }

        return false;
    }

    private boolean charIsLastValue(int index){
        return index == address.getAddress().length() - 1;
    }

    private void getFirstNums(int index){
        firstNums = address.getAddress().substring(0, index);
        passedFirstNums = true;
    }

    private boolean charIsSeparator(int index){
        return address.getAddress().charAt(index) == SEPARATOR;
    }

    private boolean firstNumsValid(){
        for (int i = 0; i<firstNums.length(); i++){
            if (!Character.isDigit(firstNums.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean wordValid(){
        return Character.isUpperCase(word.charAt(indexAtFirstLetterOfWord));
    }

    private void getWord(int lastIndex){
        word = address.getAddress().substring(indexAtFirstLetterOfWord, lastIndex);
    }
}
