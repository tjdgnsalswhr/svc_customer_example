package com.skt.twd.customer.core.object.query;

import com.skt.twd.common.error.ErrorVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private T data;
    private ErrorVo errorVo;

    public ResponseDto(T data) {
        this(data, new ErrorVo());
    }

    public ResponseDto(ErrorVo errorVo) {
        this(null, errorVo);
    }
}
