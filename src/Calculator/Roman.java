package Calculator;

public enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8),IX(9),X(10),
        XX(20), XXX(30),XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);

        int value;


         Roman(int value) {
            this.value = value;
        }

        public int getValue() {

             return value;
        }

    public static Roman getRoman(int code){
        for(Roman r : Roman.values()){
            if(code == r.value) return r;

        }
        return null;
    }

    public static String expandedNumber(int num)
    {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? "+" + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;




        return outs;
    }
    }
