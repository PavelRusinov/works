
package braces;

public class XmlOpen extends Brace{
    private String name;
    public XmlOpen(String name){
        super(BraceType.XML_OP);
        this.name = name;
    }
    public String getname(){
        return name;
    }
}
