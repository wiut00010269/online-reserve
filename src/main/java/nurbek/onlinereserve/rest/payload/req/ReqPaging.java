package nurbek.onlinereserve.rest.payload.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReqPaging {

    private Integer page;
    private Integer size;

    public Integer getSize() {
        if (this.size == 6) {
            return 6;
        }
        if (this.size < 10) {
            return 10;
        }
        if (this.size > 100) {
            return 100;
        }
        return this.size;
    }
}
