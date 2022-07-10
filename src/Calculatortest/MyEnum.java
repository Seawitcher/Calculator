package Calculatortest;

import java.util.HashMap;
import java.util.Map;

public enum MyEnum {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9),
    X(10),XI(11), XII(12),XIII(13),XIV(14),XV(15),XVI(16),XVII(17),XVIII(18),
    XIX(19),XX(20),XXX(30),XL(40),L(50),LX(60),LXX(70),LXXX(80),XC(90), C(100);
    public final Integer value;

    private static final Map<Integer, MyEnum> MY_MAP = new HashMap<>();
    static {
        for (MyEnum myEnum : values()) {
            MY_MAP.put(myEnum.getValue(), myEnum);
        }
    }

    public static MyEnum getByValue(Integer value) {
        return MY_MAP.get(value);
    }

    MyEnum(final int value) {
        this.value = value;
    }
    public Integer getValue(){
        return value;
    }

    public static MyEnum valueOfOrNull(String name) {
        try {
            return MyEnum.valueOf(name);
        } catch (Exception ex) {
            return null;
        }
    }
}