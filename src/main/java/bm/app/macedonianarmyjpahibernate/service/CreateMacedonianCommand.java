package bm.app.macedonianarmyjpahibernate.service;

import lombok.Value;

@Value
public class CreateMacedonianCommand {

    String name;
    String unitType;

    String armourType;
    String weapon;
    boolean isMounted; // TODO -> boolean isn't seen. Figure out why.

}
