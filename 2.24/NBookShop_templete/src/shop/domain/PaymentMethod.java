package shop.domain;


/**
 * PaymentMethod
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public enum PaymentMethod {

    CARD("C", "카드")
    ,RT("R", "실시간이체");
    
    private String code;
    private String name;
    
    private PaymentMethod(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    public static PaymentMethod findBy(String code) {  // card 인지 이체인지 받아와서 
        //
        for (PaymentMethod value : values()) { // enum에 들어있는코드값
            if (value.getCode().equals(code)) { // enum 코드값과 비교해서 같으면
                return value;  //그 값을 리턴한다.
            }
        }
        return null;
    }
}
