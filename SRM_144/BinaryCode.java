public class BinaryCode {
  public String[] decode(String message) {
    String[] result = new String[2];
    if(message == "0") {
      result[0] = "0";
      result[1] = "NONE";
    } else if(message == "1") {
      result[0] = "NONE";
      result[1] = "0";
    } else if(message.length() == 1) {
      result[0] = "NONE";
      result[1] = "NONE";
    } else {
      result[0] = getResult("0", message);
      result[1] = getResult("1", message);
    }
    
    return result;
  }
  private String getResult(String firstBit, String message) {
    String result = firstBit;
    while(result.length() < message.length()) {
      
      char nextBit = getNextBit(result, message);
      if(!isValidBit(nextBit)) {
      	return "NONE";
      } else {
        result += nextBit;
      }
    }
    return result;
  }
  private char getNextBit(String result, String message) {
    int currentIndex = result.length() - 1;
    int currentResultBit = Character.getNumericValue(result.charAt(currentIndex));
       
    int leftResultBit;
    if(currentIndex <= 0) {
      leftResultBit = 0;
    } else {
      leftResultBit = Character.getNumericValue(result.charAt(currentIndex - 1));
    }
    
    int codedBit = Character.getNumericValue(message.charAt(currentIndex));
    int nextBit = codedBit - leftResultBit - currentResultBit;
    
    return Integer.toString(nextBit).charAt(0);
  }  
  
  private boolean isValidBit(char bit) {
    if(bit == '0' || bit == '1') {
      return true;
    } else {
      return false;
    }
  }
}