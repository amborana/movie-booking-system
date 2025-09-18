package org.aashish.perfect.booking.core.spi;

public interface PaymentGateway {
    enum Result  { AUTHORIZED, DECLINED, ERROR }
    Result authorize(String bookingId,long amountMinorUnits,String currency);
}
