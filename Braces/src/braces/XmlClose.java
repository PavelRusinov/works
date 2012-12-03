package braces;

public class XmlClose extends Brace{
    private String name;
    public XmlClose(String name){
        super(BraceType.XML_CL);
        this.name = name;
    }
    public String getname(){
        return name;
    }
}