package braces;

public class CheckBraces {
    
    public Stack stack = new Stack();
    private int p;
    private String s;
    private int leng;
    
    private Brace readXml() throws Exception{
        int i = p;
        boolean close = false;
        if(s.charAt(p) == '/'){
            close = true;
        }
        p++;
        while (p < leng && Character.isLetter(s.charAt(p))){
            p++;
        }
        String name = s.substring(i, p);
        while (p < leng && s.charAt(p) != '/' && s.charAt(p) != '>'){
            p++;
        }
        if(p >= leng) {throw new Exception();}
        if(s.charAt(p) == '/'){
            p++;
            if(p < leng && s.charAt(p) == '>' && !close){
                p++;
                return new Brace(BraceType.XML_OPCL);
            }
            else {throw new Exception();}
        }
        if(s.charAt(p) == '>'){
            p++;
            if (close){
                return new XmlClose(name);
            }
            else{return new XmlOpen(name);}
        }
        throw new Exception();
    }
    
    public boolean check(String s) throws Exception{
        this.s = s;
        boolean res = true;
        leng = s.length();
        while(res && p < leng){
            switch(s.charAt(p)){
                case '(': stack.push(new Brace(BraceType.ROUND));
                          p++;
                          break;
                
                case ')': if(stack.pop().gettype() != BraceType.ROUND){res = false;}
                          p++;
                          break;
                    
                case '[': stack.push(new Brace(BraceType.SQUARE));
                          p++;
                          break;
                    
                case ']': if(stack.pop().gettype() != BraceType.SQUARE){res = false;}
                          p++;
                          break;
                    
                case '<': p++;
                          Brace b = readXml();
                          if(b.gettype() == BraceType.XML_OP){
                              stack.push(b);
                          }
                          if(b.gettype() == BraceType.XML_CL){
                              Brace frSt = stack.pop();
                              if(frSt.gettype() != BraceType.XML_OP &&
                               !((XmlOpen)frSt).getname().equals(((XmlClose)b).getname())){
                                  res = false;
                              }
                          }
                          break;
                
                default: p++;
                         break;
                 
            }
        }
        
        if(stack.pop().gettype() != BraceType.NONE){
            res = false;
        }
        
        return res;
    }
}
