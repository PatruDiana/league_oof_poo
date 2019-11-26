package abilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Visitor {
    void visit(Pyromancer p);
    void visit(Knight k);
    void visit(Rogue r);
    void visit(Wizard w);
}
