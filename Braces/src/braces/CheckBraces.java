package braces;

import java.util.Stack;

public class CheckBraces {
    
    public Stack stack = new Stack();
    private int p;
    private String s;
    private int leng;
    
    private Brace readXml() throws Exception{
        
        boolean close = false;
        if(s.charAt(p) == '/'){
            close = true;
            p++;
        }
        
        int i = p;
        while (p < leng && Character.isLetter(s.charAt(p))){
            p++;
        }
        String name = s.substring(i, p);
        while (p < leng && s.charAt(p) != '/' && s.charAt(p) != '>'){
            p++;
        }
        if(p >= leng) {throw new BraceWithoutEndException();}
        if(s.charAt(p) == '/'){
            p++;
            if(p < leng && s.charAt(p) == '>' && !close){
                p++;
                return new Brace(BraceType.XML_OPCL);
            }
            else {throw new BraceWithoutEndException();}
        }
        if(s.charAt(p) == '>'){
            p++;
            if (close){
                return new XmlClose(name);
            }
            else{return new XmlOpen(name);}
        }
        throw new BraceWithoutEndException();
    }
    
    public boolean check(String s) throws Exception{
        
        boolean res = true;
        
        if(s!=null){
            this.s = s;
            leng = s.length();
        
            while(res && p < leng){
                switch(s.charAt(p)){
                    case '(': stack.push(new Brace(BraceType.ROUND));
                              p++;
                              break;

                    case ')': if(((Brace)stack.pop()).gettype() != BraceType.ROUND){res = false;}
                              p++;
                              break;

                    case '[': stack.push(new Brace(BraceType.SQUARE));
                              p++;
                              break;

                    case ']': if(((Brace)stack.pop()).gettype() != BraceType.SQUARE){res = false;}
                              p++;
                              break;

                    case '<': p++;
                              Brace b = readXml();
                              if(b.gettype() == BraceType.XML_OP){
                                  stack.push(b);
                              }
                              if(b.gettype() == BraceType.XML_CL){
                                  Brace fromStack = (Brace)stack.pop();
                                  BraceType t = fromStack.gettype();
                                  if(t != BraceType.XML_OP){
                                      res = false;
                                      break;
                                  }
                                  String fsname = ((XmlOpen)fromStack).getname();
                                  String bname = ((XmlClose)b).getname();
                                  if(!fsname.equals(bname)){
                                      System.out.println(fsname+" "+bname);
                                      res = false;
                                  }
                              }
                              break;

                    default: p++;
                             break;

                }
            }
        }
        if(!stack.empty()){
            res = false;
        }
        
        return res;
    }
}
