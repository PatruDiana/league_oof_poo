package heroes;

import abilities.Visitor;

public interface Visitable {
    // allows running the abilities on the current structure.
    void accept(Visitor v);
}
