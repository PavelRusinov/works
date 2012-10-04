package braces;

public class CheckBraces {
    
    public Stack stack = new Stack();
    
    public boolean check(String s) throws Exception{
        int i;
        boolean res = true;
        boolean slash = false;
        boolean angle = false;
        int leng = s.length();
        for(i = 0; i < leng; i++){
            switch(s.charAt(i)){
                case '(': if(angle) {stack.push(Braces.ANGLE); angle = false;}
                          stack.push(Braces.ROUND);
                          slash = false;
                          break;
                
                case ')': if(angle) {stack.push(Braces.ANGLE); angle = false;}
                          if(stack.pop() != Braces.ROUND) {res = false;}
                          slash = false;
                          break;
                    
                case '[': if(angle) {stack.push(Braces.ANGLE); angle = false;}
                          stack.push(Braces.SQUARE); 
                          slash = false;
                          break;
                    
                case ']': if(angle) {stack.push(Braces.ANGLE); angle = false;}
                          if(stack.pop() != Braces.SQUARE) {res = false;}
                          slash = false;
                          break;
                    
                case '<': if(angle) {stack.push(Braces.ANGLE);} angle = true; 
                          slash = false;
                          break;
                
                case '>': if(angle) {stack.push(Braces.ANGLE); angle = false;}
                          if(slash){
                              if(stack.pop() != Braces.ANGLE) {
                                  res = false;
                              }
                          }
                          else {
                              if(stack.pop() != Braces.ANGLE_SL) {
                                  res = false;
                              }
                          }
                          slash = false;
                          break;
                
                case '/': if(angle) {stack.push(Braces.ANGLE_SL); angle = false;}
                          else {slash = true;}
                          break;
                
                default: if(angle) {stack.push(Braces.ANGLE); angle = false;}
                         slash = false;
                         break;
            }
        }
        
        if(stack.pop() != Braces.NONE){
            res = false;
        }
        
        return res;
    }
}
