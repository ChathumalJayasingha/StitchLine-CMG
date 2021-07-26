package lk.cmg.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class StandardResponse {
    private String code;
    private String message;
    private Object data;

}
