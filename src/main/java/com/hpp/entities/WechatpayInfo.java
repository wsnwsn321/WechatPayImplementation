package com.hpp.entities;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@DynamicInsert
@Entity
@Table(name = "wechatpay_orderinfo")
public class WechatpayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "app_id")
    private String app_id;

    @Column(name = "mch_id")
    private String mch_id;

    @Column(name = "nonce_str")
    private String nonce_str;

    @Column(name = "sign")
    private String sign;

    @Column(name = "body")
    private String body;

    @Column(name = "out_trade_no")
    private String out_trade_no;

    @Column(name = "total_fee")
    private float fee;

    @Column(name = "spbill_create_ip")
    private String ip;

    @Column(name = "notify_url")
    private String notify_url;

    @Column(name = "trade_type")
    private String trade_type;

    @Column(name = "openid")
    private String open_id;

    @Column(name = "return_timestamp")
    private String time;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "contest_id")
    private Integer contest_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "return_nonce_str")
    private String return_nonce_str;


    @Column(name = "package")
    private String pkg;

    @Column(name = "signType")
    private String signType;

    @Column(name = "pay_sign")
    private String pay_sign;


    @Column(name="confirm_pay" ,nullable=false,columnDefinition="TINYINT default 0")
    private Integer confirm_pay;

    @Column(name = "inputStreamId")
    private Integer inputStreamId;

    public Integer getConfirm_pay() {
        return confirm_pay;
    }

    public void setConfirm_pay(Integer confirm_pay) {
        this.confirm_pay = confirm_pay;
    }

    public Integer getInputStreamId() {
        return inputStreamId;
    }

    public void setInputStreamId(Integer inputStreamId) {
        this.inputStreamId = inputStreamId;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public String getBody() {
        return body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public float getFee() {
        return fee;
    }

    public String getIp() {
        return ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public String getOpen_id() {
        return open_id;
    }

    public String getTime() {
        return time;
    }

    public String getReturn_nonce_str() {
        return return_nonce_str;
    }

    public String getPkg() {
        return pkg;
    }

    public String getSignType() {
        return signType;
    }

    public String getPay_sign() {
        return pay_sign;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setReturn_nonce_str(String return_nonce_str) {
        this.return_nonce_str = return_nonce_str;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public void setPay_sign(String pay_sign) {
        this.pay_sign = pay_sign;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getContest_id() {
        return contest_id;
    }

    public void setContest_id(Integer contest_id) {
        this.contest_id = contest_id;
    }
}
