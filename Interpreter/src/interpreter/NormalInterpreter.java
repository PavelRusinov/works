
package interpreter;

import exceptions.*;
import interpreter.nodes.*;

public class NormalInterpreter extends Interpreter{

    @Override
    Expression eval(FunCall func) throws Exception {
         Expression f = eval(func.getFun());
        
        if (f.getType() != ExprType.FUNDEF) {
            throw new UnexpectedTypeException();
        }
        
        FunDef fun = (FunDef)f;
        
        Expression res = eval(substitute(fun.getBody(), fun.getId(), func.getArg()));
        return res;
    }

    @Override
    Expression eval(Let l) throws Exception {
        return eval(substitute(l.getExpr(), l.getId(), eval(l.getBound())));
    } 
}
