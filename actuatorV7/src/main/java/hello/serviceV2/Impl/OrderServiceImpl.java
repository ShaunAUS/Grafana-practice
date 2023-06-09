package hello.serviceV2.Impl;

import hello.serviceV2.OrderService;
import io.micrometer.core.annotation.Counted;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100);

    @Counted("my.order")
    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
    }
    @Counted("my.order")
    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
    }
    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
