//SELECT
//    BOARD_ID,
//    WRITER_ID,
//    TITLE,
//    PRICE,
//    CASE
//        WHEN STATUS = 'SALE' THEN '판매중'
//        WHEN STATUS = 'RESERVED' THEN '예약중'
//        WHEN STATUS = 'DONE' THEN '거래완료'
//        ELSE STATUS
//    END AS STATUS
//FROM
//    USED_GOODS_BOARD
//WHERE
//    CREATED_DATE = STR_TO_DATE('2022-10-05', '%Y-%m-%d')
//ORDER BY
//    BOARD_ID DESC;
