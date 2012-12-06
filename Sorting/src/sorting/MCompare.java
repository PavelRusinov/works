
package sorting;

 class MCompare implements Compare {
        @Override
        public ComRes compare(Object a, Object b) {
            if ((Integer)a > (Integer)b) {
                return ComRes.GT;
            } 
            else {
                if ((Integer)a < (Integer) b) {
                    return ComRes.LT;
                }
            }
            return ComRes.EQ;
        }
    }
