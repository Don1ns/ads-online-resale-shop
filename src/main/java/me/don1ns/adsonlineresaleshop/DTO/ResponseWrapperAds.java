package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

@Data
public class ResponseWrapperAds {
    private int count;
    private AdsDTO results;
}
