package com.epam.framework.model;

import java.util.Objects;

public class ProductWithPromoCode {
    private String url;
    private String promoCode;

    public ProductWithPromoCode(String url, String promoCode) {
        this.url = url;
        this.promoCode = promoCode;
    }

    public String getUrl() {
        return url;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductWithPromoCode{");
        sb.append("url='").append(url).append('\'');
        sb.append(", promoCode='").append(promoCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWithPromoCode that = (ProductWithPromoCode) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(promoCode, that.promoCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, promoCode);
    }
}
