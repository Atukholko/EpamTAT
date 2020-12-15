package com.epam.framework.model;

import java.util.Objects;

public class Product {
    private String url;
    private String code;

    public Product(String url, String code) {
        this.url = url;
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public String getCode() {
        return code;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("url='").append(url).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, code);
    }
}
