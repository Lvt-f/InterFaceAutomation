package com.course.model;

//解绑时所需的数据
public class uBindingCase {


    private String errmsg;
    private String errno;
    private dataCase data;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public com.course.model.dataCase getDataCase() {
        return data;
    }

    public void setDataCase(com.course.model.dataCase dataCase) {
        this.data = dataCase;
    }

    public uBindingCase(String errmsg, String errno, com.course.model.dataCase dataCase) {
        this.errmsg = errmsg;
        this.errno = errno;
        this.data = dataCase;
    }

    @Override
    public String toString() {
        return "uBindingCase{" +
                "errmsg='" + errmsg + '\'' +
                ", errno='" + errno + '\'' +
                ", dataCase=" + data +
                '}';
    }
}
