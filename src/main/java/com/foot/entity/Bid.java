package com.foot.entity;

import com.foot.dto.bidProduct.BidRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "bids")
public class Bid extends Timestamped{
    /**
     * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "bidprice" , nullable = false)
    private Long bidPrice;


    /**
     * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
     */
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bidproductId", nullable = false)
    private BidProduct bidProduct;



    /**
     * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
     */

    public Bid(BidRequestDto requestDto, BidProduct bidProduct, User user) {
        bidPrice = requestDto.getBidPrice();
        this.user = user;
        this.bidProduct = bidProduct;
    }

    /**
     * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
     */


    /**
     * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
     * ex (update 메소드)
     */
}
