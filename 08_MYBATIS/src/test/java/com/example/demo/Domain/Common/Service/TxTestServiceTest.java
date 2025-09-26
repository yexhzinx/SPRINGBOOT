package com.example.demo.Domain.Common.Service;

import org.junit.jupiter.api.Test;

public class TxTestServiceTest {
    public void t1() throws Exception{
        txTestService.addMemoTx();
    }

    @Test
    public void t1() throws Exception{
        txTestService.addMemoWithMybatis(new MemoDto(9990L, 'a', ))
    }

}
