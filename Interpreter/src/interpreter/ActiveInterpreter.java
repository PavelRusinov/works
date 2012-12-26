
package interpreter;

import exceptions.*;
import interpreter.nodes.*;

public class ActiveInterpreter extends Interpreter{

    @Override
    Expression eval(FunCall func) throws Exception {
         Expression f = eval(func.getFun());
        
        if (f.getType() != ExprType.FUNDEF) {
            throw new UnexpectedTypeException();
        }
        
        FunDef fun = (FunDef)f;
        
        return eval(substitute(fun.getBody(), fun.getId(), eval(func.getArg())));
    }

    @Override
    Expression eval(Let l) throws Exception {
        return eval(substitute(l.getExpr(), l.getId(), eval(l.getBound())));
    } 
}
