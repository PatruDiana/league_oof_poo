package heroes;

import abilities.Visitor;

public interface Visitable {
    void accept(Visitor v);
}
