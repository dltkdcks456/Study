package org.example.leave.me.alone;

public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12),
    DUPLICATESOLO(1);

    private final int numberOfmusicians;

    Ensemble(final int numberOfmusicians) {
        this.numberOfmusicians = numberOfmusicians;
    }

//    public int getNumberOfmusicians() {return ordinal()}
}
