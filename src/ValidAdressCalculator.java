public final class ValidAdressCalculator {
    private final Customer customer;
    private final String address;

    private String firstNums;
    private boolean passedFirstNums;
    private String word;
    private static final char SEPARATOR = ' ';

    private boolean passedFirstLetterOfWord;
    private int indexAtFirstLetterOfWord;

    public ValidAdressCalculator(Customer customer, String address){
        this.customer = customer;
        this.address = address;
        this.word = "";
        this.passedFirstNums = false;
        this.passedFirstLetterOfWord = false;
    }

    public boolean compute() {
        for(int i = 0; i<address.length(); i++){
            if (passedFirstNums && !charIsSeparator(i)) continue;

            if (!passedFirstNums && charIsSeparator(i)){
                getFirstNums(i);
                if (!firstNumsValid())
                    return false;
                continue;
            }

            if(!passedFirstLetterOfWord){
                indexAtFirstLetterOfWord = i;
                passedFirstLetterOfWord = true;
            }

            word = address.substring(indexAtFirstLetterOfWord, i);
            if(!wordValid())
                return false;
        }

        return true;
    }

    private void getFirstNums(int index){
        firstNums = address.substring(0, index);
        passedFirstNums = true;
    }

    private boolean charIsSeparator(int index){
        return address.charAt(index) == SEPARATOR;
    }

    private boolean firstNumsValid(){
        for (int i = 0; i<firstNums.length(); i++){
            if (!Character.isDigit(firstNums.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean wordValid(){
        return Character.isUpperCase(firstNums.charAt(0));
    }
}
